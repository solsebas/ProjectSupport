package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.projectsupport.model.UserModel;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
