package pl.szawara.authserver.Auth.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.szawara.authserver.Register.model.RegisterUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Builder
public class User  {
    private static final long seralVersionUID=1L;
    @Getter @Setter

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String email;
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Role> roles;
    @Column
    String firstName;
    @Column
    private String lastName;
    @Column
    private Date birthDate;
    @Column
    private Date lastLogin;

    @Column
    private Boolean enabled;

    public User(RegisterUser user, PasswordEncoder passwordEncoder){
        this.email= user.email();;
        this.birthDate=user.birtDate();
        this.enabled=true;
        this.password=passwordEncoder.encode(user.password());
        this.firstName= user.firstName();
        this.lastName= user.lastName();
        this.roles=new ArrayList<>(List.of(Role.USER));
    }
}
