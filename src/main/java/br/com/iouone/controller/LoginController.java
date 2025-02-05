package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.dto.LoginRequest;
import br.com.iouone.dto.LoginResponse;
import br.com.iouone.exception.AssinaturaException;
import br.com.iouone.service.LoginService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/login")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping()
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            return ResponseEntity.ok(loginService.login(loginRequest));
        }catch (AssinaturaException ae){
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
