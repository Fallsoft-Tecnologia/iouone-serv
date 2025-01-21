package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.dto.LoginRequest;
import br.com.iouone.dto.LoginResponse;
import br.com.iouone.repository.PessoaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/v2/login")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class LoginController {

    private final JwtEncoder jwtEncoder;
    private final PessoaRepository pessoaRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public LoginController(JwtEncoder jwtEncoder,
                           PessoaRepository pessoaRepository,
                           BCryptPasswordEncoder passwordEncoder){
        this.jwtEncoder = jwtEncoder;
        this.pessoaRepository = pessoaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping()
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){

        var pessoa = pessoaRepository.findByEmail(loginRequest.getEmail());
        if (pessoa.isEmpty() || !pessoa.get().isLoginCorrect(loginRequest, passwordEncoder)){
            throw new BadCredentialsException("email or password is invalid");
        }

        var now = Instant.now();
        var expiresIn = 300L;

        var claims = JwtClaimsSet.builder()
                .issuer("backend-iouone")
                .subject(pessoa.get().getNome())
                .claim("id", pessoa.get().getId())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
    }
}
