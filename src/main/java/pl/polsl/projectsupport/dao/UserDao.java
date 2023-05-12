package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.polsl.projectsupport.model.UserModel;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query(value = "select * from public.users u where u.username = :name" , nativeQuery = true)
    public UserModel findUserByName(@Param("name") String name);
}
