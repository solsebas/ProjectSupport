package pl.polsl.projectsupport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;
import pl.polsl.projectsupport.enums.TeamStatus;

import java.util.List;

@Data
@Entity
@Table(name = "team")
public class TeamModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    Long id;

    @Column(name = "member_limit")
    Short limit;

    @Enumerated(EnumType.STRING)
    TeamStatus status;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    TopicModel topic;

    @ManyToOne
    @JoinColumn(name = "term_id")
    TermModel term;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    @JsonIgnore
    List<StudentTeamModel> students;
}
