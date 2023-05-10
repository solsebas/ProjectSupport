package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "student_team")
public class StudentTeamModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_team_id")
    Long id;

    Short grade;

    @ManyToOne
    @JoinColumn(name = "team_id")
    TeamModel team;

    @ManyToOne
    @JoinColumn(name = "student_id")
    StudentModel student;

    @OneToMany(mappedBy = "participant")
    @JsonIgnore
    List<AttendanceModel> attendances;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    List<AttachmentModel> attachments;
}
