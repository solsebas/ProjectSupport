package pl.polsl.projectsupport.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "attendance", uniqueConstraints = { @UniqueConstraint(columnNames = { "date", "student_team_id" }) })
public class AttendanceModel {

    @Id
    @GeneratedValue
    @Column(name = "attendance_id")
    Long id;

    boolean present;

    @Temporal(TemporalType.DATE)
    Date date;

    @ManyToOne
    @JoinColumn(name = "student_team_id")
    StudentTeamModel participant;
}
