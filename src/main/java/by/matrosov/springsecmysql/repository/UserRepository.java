package by.matrosov.springsecmysql.repository;

import by.matrosov.springsecmysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByFirstName(String s);
}
