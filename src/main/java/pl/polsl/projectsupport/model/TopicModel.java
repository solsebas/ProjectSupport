package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "topic")
public class TopicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    Long id;

    String name;

    String description;

    boolean archieve = false;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    SupervisorModel supervisor;

    @OneToMany(mappedBy = "topic")
    @JsonIgnore
    List<TeamModel> teams;
}