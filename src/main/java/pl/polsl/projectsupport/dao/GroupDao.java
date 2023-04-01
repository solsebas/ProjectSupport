package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.GroupModel;

@Repository
public interface GroupDao extends JpaRepository<GroupModel, Long> {
}
