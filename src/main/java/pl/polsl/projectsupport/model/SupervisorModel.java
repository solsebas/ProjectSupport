package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "supervisor")
public class SupervisorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supervisor_id")
    Long id;

    @Column(name = "first_name")
    String firstName;

    String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    UserModel user;

    @OneToMany(mappedBy = "supervisor")
    @JsonIgnore
    List<TopicModel> topics;

}
