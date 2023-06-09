package pl.polsl.projectsupport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.polsl.projectsupport.model.AttendanceModel;

@Repository
public interface AttendanceDao extends JpaRepository<AttendanceModel, Long> {

}
