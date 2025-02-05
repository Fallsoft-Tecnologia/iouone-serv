package br.com.iouone.service;

import br.com.iouone.dto.LoginRequest;
import br.com.iouone.dto.LoginResponse;
import br.com.iouone.exception.AssinaturaException;
import br.com.iouone.feign.PagamentoFeignClient;
import br.com.iouone.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LoginService {

    private final JwtEncoder jwtEncoder;
    private final PessoaRepository pessoaRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final PagamentoFeignClient pagamentoFeignClient;

    public LoginService(JwtEncoder jwtEncoder, PessoaRepository pessoaRepository, BCryptPasswordEncoder passwordEncoder, PagamentoFeignClient pagamentoFeignClient) {
        this.jwtEncoder = jwtEncoder;
        this.pessoaRepository = pessoaRepository;
        this.passwordEncoder = passwordEncoder;
        this.pagamentoFeignClient = pagamentoFeignClient;
    }

    public LoginResponse login(LoginRequest loginRequest) throws Exception{

        var pessoa = pessoaRepository.findByEmail(loginRequest.getEmail());
        if (pessoa.isEmpty() || !pessoa.get().isLoginCorrect(loginRequest, passwordEncoder)) {
            throw new BadCredentialsException("email or password is invalid");
        }

        var statusAssinatura = pagamentoFeignClient.statusAssinatura(pessoa.get().getCustomerId());

        if (!statusAssinatura) {
            throw new AssinaturaException("Assinatura finalizada");
        }

        var now = Instant.now();
        var expiresIn = 3600L;

        var claims = JwtClaimsSet.builder()
                .issuer("backend-iouone")
                .subject(pessoa.get().getNome())
                .claim("id", pessoa.get().getId())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponse(jwtValue, expiresIn);
    }
}
