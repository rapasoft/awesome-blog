package no.itera.playground.controller;

import no.itera.playground.model.security.TokenRequest;
import no.itera.playground.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Pavol Rajzak, Itera
 */
@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getToken(@RequestBody TokenRequest tokenRequest) {
        return tokenService.generateToken(tokenRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{token}")
    public ResponseEntity validateToken(@PathVariable String token) {
        if (tokenService.isValidToken(token)) {
            return ResponseEntity.ok("Valid token");
        }

        return ResponseEntity.notFound().build();
    }

}
