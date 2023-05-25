package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.TeamModel;

import java.util.List;

@Repository
public interface TeamDao extends JpaRepository<TeamModel, Long> {
    @Query(value = "select t.* from team t where t.team_id in " +
            "(select st.team_id from student_team st where student_id = " +
            "(select s.student_id from student s where s.user_id = :id))" , nativeQuery = true)
    List<TeamModel> findTeamsByParticipantUserId(@Param("id") Long userId);
}