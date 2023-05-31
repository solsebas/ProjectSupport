package pl.polsl.projectsupport.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamDto {

    Long id;

    Short limit;

    String status;

    TopicDto topic;

    TermDto term;

    List<StudentDto> studentList;
}
