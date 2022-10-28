package com.textileValley.authentication.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private static final String SECRET_KEY = "FoodiFy";

//    ----------first function-generate token-------------------
//    public String generateToken(UserDetails userDetials) {
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims, userDetials.getUsername());
//    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

//    ---------second-function-validate_token---------------------
    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
//    ----------third function-create token-------------------------------
//    -------------expire time is 10hrs-----------------------------------
    private String createToken(Map<String, Object> claims, String subject) {

    	Date now = new Date(System.currentTimeMillis());
    	Date until = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(now)
                .setExpiration(until)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
//    --------------fourth function-extract claim-----------------------------
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

//    -------------fifth-function-extract all claims---------------------------
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

//  ---------------sixth function-extract user name-------------------
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

//  -------------seventh function- extract-expiration-----------------
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

//	-------------last function-is token expired------------------------
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


}
