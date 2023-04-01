package pl.polsl.projectsupport.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sudent_term")
public class StudentTermModel {

    @Id
    @GeneratedValue
    @Column(name = "student_term_id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "term_id")
    TermModel term;

    @ManyToOne
    @JoinColumn(name = "student_id")
    StudentModel student;
}
