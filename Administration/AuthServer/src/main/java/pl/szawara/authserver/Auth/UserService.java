package pl.szawara.authserver.Auth;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.szawara.authserver.Auth.Model.User;
import pl.szawara.authserver.Auth.Model.UserSecurity;
import pl.szawara.authserver.repositories.UserRepository;
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email)
                .map(user->new UserSecurity(user))
                .filter(UserSecurity::isAccountNonExpired)
                .filter(UserSecurity::isAccountNonLocked)
                .filter(UserSecurity::isEnabled)
                .orElseThrow(()->new UsernameNotFoundException("Not found user with email:" + email));
    }
}
