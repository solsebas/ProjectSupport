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

}