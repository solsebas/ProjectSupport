package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.StudentTeamModel;

@Repository
public interface StudentTeamDao extends JpaRepository<StudentTeamModel, Long> {
}
