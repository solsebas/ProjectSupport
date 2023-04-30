package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.TopicModel;

@Repository
public interface TopicDao extends JpaRepository<TopicModel, Long> {
}