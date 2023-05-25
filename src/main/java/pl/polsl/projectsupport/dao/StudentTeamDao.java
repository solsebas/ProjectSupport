package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.StudentTeamModel;
import pl.polsl.projectsupport.model.SupervisorModel;

import java.util.List;

@Repository
public interface StudentTeamDao extends JpaRepository<StudentTeamModel, Long> {
    @Query(value = "select st.* " +
            "from student_team st " +
            "where st.team_id = :teamId and st.student_id = (select s.student_id from student s where user_id = :userId)" , nativeQuery = true)
    StudentTeamModel findStudentTeamModelByTeamAndStudent(@Param("userId") Long userId, @Param("teamId") Long teamId);

    @Query(value = "select st.* " +
            "from student_team st " +
            "where st.team_id = :teamId" , nativeQuery = true)
    List<StudentTeamModel> findMembersByTeamId(Long teamId);
}
