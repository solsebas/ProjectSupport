package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.TeamModel;

@Repository
public interface TeamDao extends JpaRepository<TeamModel, Long> {
}
