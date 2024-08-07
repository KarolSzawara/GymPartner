package pl.szawara.authserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szawara.authserver.Auth.Model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByEmail(String email);
}
