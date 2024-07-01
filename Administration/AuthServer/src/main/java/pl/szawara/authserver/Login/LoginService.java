package pl.szawara.authserver.Login;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import pl.szawara.authserver.Auth.Model.User;
import pl.szawara.authserver.Auth.Model.UserSecurity;
import pl.szawara.authserver.JWT.JwtService;
import pl.szawara.authserver.Login.model.AuthRequest;
import pl.szawara.authserver.repositories.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {
    JwtService jwtService;

    private AuthenticationManager authenticationManager;
    public Optional<String> loginUser(AuthRequest user){
        var auth=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        if(auth.isAuthenticated()){
            return Optional.of(jwtService.generateToken(((UserSecurity)auth.getPrincipal()).getUser()));
        }else {
            return Optional.empty();
        }
    }

}
