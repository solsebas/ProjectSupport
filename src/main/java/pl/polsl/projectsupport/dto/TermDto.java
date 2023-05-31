package pl.polsl.projectsupport.dto;

import lombok.Data;

@Data
public class TermDto {
    Long id;
    String major;
    int year;
    int termNumber;
}
