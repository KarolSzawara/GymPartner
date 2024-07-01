package pl.szawara.authserver.JWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import pl.szawara.authserver.Auth.Model.User;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {
    public static final String SECRET="6500703933257012948208681463081259978395";

    public void validateToken(final String token){
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJwt(token);
    }
    public String generateToken(User user){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",user.getId());
        claims.put("email",user.getEmail());
        claims.put("birth_date",user.getBirthDate());
        claims.put("first_name",user.getFirstName());
        claims.put("last_name",user.getLastName());
        return createToken(claims,user.getEmail());
    }
    private String createToken(Map<String,Object> claims,String email){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
