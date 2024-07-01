package pl.szawara.authserver.Register;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.szawara.authserver.Auth.Model.User;
import pl.szawara.authserver.Register.model.RegisterUser;
import pl.szawara.authserver.repositories.UserRepository;
@Service
@AllArgsConstructor
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void registerUser(RegisterUser user){

        userRepository.save(new User(user,passwordEncoder));
    }
}
