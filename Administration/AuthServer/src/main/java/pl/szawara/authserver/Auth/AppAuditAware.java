package pl.szawara.authserver.Auth;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.szawara.authserver.Auth.Model.User;

import java.util.Optional;

public class AppAuditAware implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if ((authentication==null||!authentication.isAuthenticated())){
            return Optional.empty();
        }
        User userPrincipal=(User)authentication.getPrincipal();
        return Optional.ofNullable(userPrincipal.getId());
    }
}
