package pl.polsl.projectsupport.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student_term")
public class StudentTermModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_term_id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "term_id")
    TermModel term;

    @ManyToOne
    @JoinColumn(name = "student_id")
    StudentModel student;
}
