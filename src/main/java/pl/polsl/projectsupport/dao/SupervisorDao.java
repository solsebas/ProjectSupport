package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.SupervisorModel;

@Repository
public interface SupervisorDao extends JpaRepository<SupervisorModel, Long> {
    @Query(value = "select * from supervisor s where s.user_id = :id" , nativeQuery = true)
    public SupervisorModel findSupervisor(@Param("id") Long idUser);
}
