package pl.polsl.projectsupport.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attachment")
public class AttachmentModel {

    @Id
    @GeneratedValue
    @Column(name = "attachment_id")
    Long id;

    String filename;

    @Lob
    byte[] content;

    @ManyToOne
    @JoinColumn(name = "student_team_id")
    StudentTeamModel author;
}
