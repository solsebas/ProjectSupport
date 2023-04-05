package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "topic")
public class TopicModel {
    @Id
    @GeneratedValue
    @Column(name = "topic_id")
    Long id;

    String name;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    SupervisorModel supervisor;

    @OneToMany(mappedBy = "topic")
    @JsonIgnore
    List<TeamModel> teams;
}