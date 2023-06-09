package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    Long id;

    @Column(name = "first_name")
    String firstName;

    String surname;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    UserModel user;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    List<StudentTermModel> terms;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    List<StudentTeamModel> teams;
}
