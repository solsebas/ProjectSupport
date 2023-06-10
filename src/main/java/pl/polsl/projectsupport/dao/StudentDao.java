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

    @Query(value = "SELECT student.student_id, student.first_name, student.surname, student.user_id " +
            "FROM student " +
            "JOIN student_term ON student.student_id = student_term.student_id " +
            "JOIN term ON student_term.term_id = term.term_id " +
            "JOIN team ON term.term_id = team.term_id " +
            "WHERE term.term_id = :termId " +
            "GROUP BY student.student_id", nativeQuery = true)
    List<StudentModel> findStudentTerm(@Param("termId") Long termId);

}
