package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.SupervisorModel;
import pl.polsl.projectsupport.model.TopicModel;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TopicDao extends JpaRepository<TopicModel, Long> {
    @Query(value = "SELECT t.* FROM topic t WHERE t.supervisor_id = (select s.supervisor_id from supervisor s where s.user_id = :id)", nativeQuery = true)
    List<TopicModel> findBySupervisorId(@Param("id") Long supervisorId);
}