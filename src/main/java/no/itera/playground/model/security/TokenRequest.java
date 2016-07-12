package no.itera.playground.model.security;

import lombok.Data;

/**
 * Pavol Rajzak, Itera
 */
@Data
public class TokenRequest {

    private String username;
    private String password;

}
