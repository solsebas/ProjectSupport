package pl.polsl.projectsupport.dto;

import lombok.Data;

@Data
public class TopicDto {
    Long id;
    String topicName;
    String topicDescription;
    Long idUser;
    boolean archieve;
}