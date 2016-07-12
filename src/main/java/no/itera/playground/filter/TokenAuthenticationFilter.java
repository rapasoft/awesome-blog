package no.itera.playground.filter;

import no.itera.playground.model.security.TokenAuthentication;
import no.itera.playground.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * Pavol Rajzak, Itera
 */
@Component
public class TokenAuthenticationFilter implements Filter {

    @Autowired
    private TokenService tokenService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        Optional<String> token = Optional.ofNullable(request.getHeader("token"));

        if (token.isPresent()) {
            tokenService.isValidToken(token.get());

            Authentication authentication = new TokenAuthentication();
            authentication.setAuthenticated(true);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
