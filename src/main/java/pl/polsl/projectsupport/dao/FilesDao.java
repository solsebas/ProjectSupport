package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.AttachmentModel;
import pl.polsl.projectsupport.model.TopicModel;

import java.util.List;

@Repository
public interface FilesDao extends JpaRepository<AttachmentModel, Long> {

}