package com.wiperi.novuscrm.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.lang.Classes;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;
import io.jsonwebtoken.security.SignatureAlgorithm;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JWTUtils {

    private final static String secret = "sdoifjsdjfaspjfsadjfsfpsijfwoeijfwojfe";
    private final static Long expiration = 604800L;

    private static SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

    public static String createToken(Map<String, Object> claims) {
        MacAlgorithm alg = Jwts.SIG.HS256; // or HS384 or HS256
        return Jwts.builder()
                .claims(claims)
                .signWith(key, alg)
                .expiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    public static Claims parseToken(String token) throws Exception {
        var payload = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return payload;
    }

    public static boolean verifyToken(String token) {
        return false;
    }

    public static void main(String[] args) {
        var res = createToken(Map.of("name", "John Doe"));
        System.out.println(res);
    }
}

// // Create a test key suitable for the desired HMAC-SHA algorithm:
// MacAlgorithm alg = Jwts.SIG.HS512; //or HS384 or HS256
// SecretKey key = alg.key().build();
//
// String message = "Hello World!";
// byte[] content = message.getBytes(StandardCharsets.UTF_8);
//
// // Create the compact JWS:
// String jws = Jwts.builder().content(content, "text/plain").signWith(key, alg).compact();
//
// // Parse the compact JWS:
// content = Jwts.parser().verifyWith(key).build().parseSignedContent(jws).getPayload();
//
// assert message.equals(new String(content, StandardCharsets.UTF_8));
