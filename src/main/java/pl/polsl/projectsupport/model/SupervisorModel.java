package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "supervisor")
public class SupervisorModel {

    @Id
    @GeneratedValue
    @Column(name = "supervisor_id")
    Long id;

    @Column(name = "first_name")
    String firstName;

    String surname;

    @OneToMany(mappedBy = "supervisor")
    @JsonIgnore
    List<TopicModel> topics;

}
