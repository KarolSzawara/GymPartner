package pl.szawara.authserver.Auth.Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
    USER("user"),ADMIN("admin"),STAFF("staff");
    private final String role;
}
