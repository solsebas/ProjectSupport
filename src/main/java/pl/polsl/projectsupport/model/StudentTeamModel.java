package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "student_team")
public class StudentTeamModel {

    @Id
    @GeneratedValue
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
