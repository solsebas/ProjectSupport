package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "supervisor")
public class SupervisorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supervisor_id")
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "surname")
    String surname;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    UserModel user;

    @OneToMany(mappedBy = "supervisor")
    @JsonIgnore
    List<TopicModel> topics;

    public SupervisorModel(String firstName, String surname, UserModel user) {
        this.firstName = firstName;
        this.surname = surname;
        this.user = user;
    }

}
