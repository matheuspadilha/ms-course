package br.com.matheuspadilha.hruser.repositories;

import br.com.matheuspadilha.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
