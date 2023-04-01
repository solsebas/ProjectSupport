package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "sudent_group")
public class StudentGroupModel {

    @Id
    @GeneratedValue
    @Column(name = "student_group_id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    GroupModel group;

    @ManyToOne
    @JoinColumn(name = "student_id")
    StudentModel student;

    @OneToMany(mappedBy = "participant")
    @JsonIgnore
    List<AttendanceModel> attendances;
}
