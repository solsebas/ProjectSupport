package pl.polsl.projectsupport.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AttendanceDto {
    Long id;
    boolean present;
    String date;
    Long memberId;
}
