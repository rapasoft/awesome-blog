package no.itera.playground.service;

import no.itera.playground.exceptions.NotAuthorizedException;
import no.itera.playground.model.security.TokenRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Pavol Rajzak, Itera
 */
@Service
public class TokenService {

    @Value("${security.user.name}")
    private String username;
    @Value("${security.user.password}")
    private String password;

    private Map<String, Date> tokenCache = new HashMap<>();

    public String generateToken(TokenRequest tokenRequest) {
        if (isValidRequest(tokenRequest)) {
            String blogToken = UUID.randomUUID().toString();
            tokenCache.put(blogToken, Date.from(Instant.now().plus(1L, ChronoUnit.DAYS)));
            return blogToken;
        }

        throw new NotAuthorizedException();
    }

    public boolean isValidToken(String blogToken) {
        if (tokenCache.containsKey(blogToken)) {
            if (tokenCache.get(blogToken).compareTo(Date.from(Instant.now())) > 0) {
                return true;
            } else {
                tokenCache.remove(blogToken);
            }
        }
        return false;
    }

    private boolean isValidRequest(TokenRequest tokenRequest) {
        return tokenRequest.getUsername().equals(username) && tokenRequest.getPassword().equals(password);
    }

}
