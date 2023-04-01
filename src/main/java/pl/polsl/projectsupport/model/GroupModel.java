package pl.polsl.projectsupport.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "groups")
public class GroupModel {

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    TopicModel topic;

    @ManyToOne
    @JoinColumn(name = "term_id")
    TermModel term;

    //todo: group participants

    //todo: group status (enum)
}
