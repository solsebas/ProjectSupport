package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.StudentModel;

@Repository
public interface StudentDao extends JpaRepository<StudentModel, Long> {
}
