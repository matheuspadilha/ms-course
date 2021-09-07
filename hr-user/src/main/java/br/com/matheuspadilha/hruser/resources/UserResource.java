package br.com.matheuspadilha.hruser.resources;

import br.com.matheuspadilha.hruser.entities.User;
import br.com.matheuspadilha.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired
    private UserRepository repository;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = repository.findById(id).get();
        
        return ResponseEntity.ok().body(user);
    }
    
    @GetMapping(value = "/search")
    public ResponseEntity<User> findById(@RequestParam String email) {
        User user = repository.findByEmail(email);
        
        return ResponseEntity.ok().body(user);
    }
}