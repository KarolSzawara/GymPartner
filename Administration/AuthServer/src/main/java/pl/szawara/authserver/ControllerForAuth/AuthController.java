package pl.szawara.authserver.ControllerForAuth;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szawara.authserver.Login.LoginService;
import pl.szawara.authserver.Login.model.AuthRequest;
import pl.szawara.authserver.Register.RegisterService;
import pl.szawara.authserver.Register.model.RegisterUser;

@RestController()
@RequestMapping("/auth")
@AllArgsConstructor
@OpenAPIDefinition
@Tag(name = "Authorization end points")
public class AuthController {
    RegisterService registerService;
    LoginService loginService;
    @Operation(summary = "Register user")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUser registerUser){
        registerService.registerUser(registerUser);
        return ResponseEntity.ok().build();
    }
    @Operation(summary = "Login user")
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody AuthRequest authRequest){
        var token=loginService.loginUser(authRequest);
        if(token.isPresent()){
            return ResponseEntity.ok(token.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
