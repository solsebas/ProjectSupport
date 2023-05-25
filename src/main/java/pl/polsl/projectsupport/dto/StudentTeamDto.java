package pl.polsl.projectsupport.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentTeamDto {
    StudentDto student;
    int grade;
    TeamDto team;
    List<AttendanceDto> attendanceList;
}
