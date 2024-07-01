package pl.szawara.authserver.Register.model;

import java.util.Date;

public record RegisterUser(
        String email,
        String password,
        String firstName,
        String lastName,
        Date birtDate

) {
}
