package no.itera.playground.model.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;

/**
 * Pavol Rajzak, Itera
 */
public class TokenAuthentication implements Authentication {

    private boolean authenticated;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList((GrantedAuthority) new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "blogger";
            }
        });
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return new Principal() {
            @Override
            public String getName() {
                return "blog-user";
            }
        };
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    @Override
    public String getName() {
        return "blog-user";
    }
}
