package pl.szawara.authserver.Login;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import pl.szawara.authserver.Auth.Model.User;
import pl.szawara.authserver.JWT.JwtService;
import pl.szawara.authserver.Login.model.AuthRequest;
import pl.szawara.authserver.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    JwtService jwtService;
    private AuthenticationManager authenticationManager;
    public Optional<String> loginUser(AuthRequest user){
        var auth=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        if(auth.isAuthenticated()){
            return Optional.of(jwtService.generateToken((User)auth.getPrincipal()));
        }else {
            return Optional.empty();
        }
    }

}
