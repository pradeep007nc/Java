package dev.pradeep.JwtAuth.Repositoy;

import dev.pradeep.JwtAuth.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

}

