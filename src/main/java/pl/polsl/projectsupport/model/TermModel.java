package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "term")
public class TermModel {

    @Id
    @GeneratedValue
    @Column(name = "term_id")
    Long id;

    //todo: do we need majorModel
    String major;

    int year;

    @Column(name = "term_number")
    int termNumber;

    @OneToMany(mappedBy = "term")
    @JsonIgnore
    List<StudentTermModel> students;
}
