package br.com.matheuspadilha.hroauth.services;

import br.com.matheuspadilha.hroauth.entities.User;
import br.com.matheuspadilha.hroauth.feingclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    private UserFeignClient userFeignClient;
    
    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        
        if (Objects.isNull(user)) {
            logger.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found!");
        }
        logger.info("Email found: " + email);
        
        return user;
    }
}
