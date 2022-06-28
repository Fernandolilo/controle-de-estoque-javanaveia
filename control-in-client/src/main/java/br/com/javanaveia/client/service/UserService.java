package br.com.javanaveia.client.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.javanaveia.client.security.UserSS;

@Service
public class UserService {
    public static UserSS authenticated() {
        try {
            /*
             * retorna o usuario logado
             */
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        }catch (Exception e) {
            return null;
        }
    }
}