package pl.szawra.getwayserver.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUntil {
    @Value("${jwt.secret}")
    public String SECRET;
    public void validateToken(final String token){
        Jwts.parserBuilder().setSigningKey(SECRET).build().parseClaimsJwt(token);
    }
    private Key getSignKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
