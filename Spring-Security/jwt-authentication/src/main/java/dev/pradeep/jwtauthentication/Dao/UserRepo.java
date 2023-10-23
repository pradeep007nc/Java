package dev.pradeep.jwtauthentication.Dao;

import dev.pradeep.jwtauthentication.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email);

}
