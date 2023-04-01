package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "groups")
public class GroupModel {

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    Long id;

    //todo: group status (enum)

    @ManyToOne
    @JoinColumn(name = "topic_id")
    TopicModel topic;

    @ManyToOne
    @JoinColumn(name = "term_id")
    TermModel term;

    @OneToMany(mappedBy = "group")
    @JsonIgnore
    List<StudentGroupModel> students;
}
