package pl.polsl.projectsupport.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student_term")
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
