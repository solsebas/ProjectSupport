package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.TermModel;

import java.util.List;

@Repository
public interface TermDao extends JpaRepository<TermModel, Long> {
    @Query(value = "SELECT * FROM term t WHERE t.year = (SELECT MAX(year) FROM term)", nativeQuery = true)
    List<TermModel> findActiveTerms();
}
