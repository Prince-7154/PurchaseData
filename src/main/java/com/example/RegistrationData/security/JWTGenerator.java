package com.example.RegistrationData.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JWTGenerator {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

   public String generateToken(Authentication authentication) {
       String username = authentication.getName();
       Date currentDate = new Date();
       Date expirationDate = new Date(currentDate.getTime() + SecurityConstant.JWT_EXPIRATION);
       String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expirationDate).signWith(key,SignatureAlgorithm.HS256).compact();

       return token;
   }


   public String getUsernameFromToken(String token) {
       Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
       return claims.getSubject();
   }

   public Boolean validateToken(String token) {
       try{
           Jwts.parser().setSigningKey(key).parseClaimsJws(token);
           return true;
       }catch (Exception e){
           throw new AuthenticationCredentialsNotFoundException("JWT Token not found");
       }
   }
}
