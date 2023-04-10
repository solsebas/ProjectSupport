package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.projectsupport.model.TestUserModel;

import java.util.Optional;

public interface TestUserDao extends JpaRepository<TestUserModel, Long> {
    Optional<TestUserModel> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
