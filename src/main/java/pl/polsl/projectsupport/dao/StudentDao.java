package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.dto.StudentDto;
import pl.polsl.projectsupport.model.StudentModel;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<StudentModel, Long> {

    @Query(value = "select s.* from student s where s.student_id in " +
            "(select st.student_id from student_team st where st.team_id = :id)" , nativeQuery = true)
    List<StudentModel> findByTeamId(@Param("id") Long teamId);
}
