package com.ninjaone.rmm.shared.infrastructure.security;

import com.ninjaone.shared.infrastructure.config.Parameter;
import com.ninjaone.shared.infrastructure.config.ParameterNotExist;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private final Parameter config;

    public JwtUtils(Parameter config) {
        this.config = config;
    }

    public String generateJwtToken(Authentication authentication) throws ParameterNotExist {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
            .setSubject((userPrincipal.getUsername()))
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + Long.parseLong(config.get("JWT_EXPIRATION"))))
            .signWith(SignatureAlgorithm.HS512, config.get("JWT_SECRET"))
            .compact();
    }

    public String getUserNameFromJwtToken(String token) throws ParameterNotExist {
        return Jwts.parser().setSigningKey(config.get("JWT_SECRET")).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(config.get("JWT_SECRET")).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        } catch (ParameterNotExist e) {
            e.printStackTrace();
        }

        return false;
    }
}
