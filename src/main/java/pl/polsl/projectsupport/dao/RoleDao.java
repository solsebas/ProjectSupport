package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.projectsupport.enums.EnumRole;
import pl.polsl.projectsupport.model.RoleModel;

import java.util.Optional;

public interface RoleDao extends JpaRepository<RoleModel, Long>  {
    Optional<RoleModel> findByName(EnumRole name);
}
