package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "students")
public class StudentModel {

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    Long id;

    @Column(name = "first_name")
    String firstName;

    String surname;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    List<StudentTermModel> terms;
}
