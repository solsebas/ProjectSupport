package pl.polsl.projectsupport.service;

import pl.polsl.projectsupport.dto.StudentTeamDto;
import pl.polsl.projectsupport.dto.TeamDto;
import pl.polsl.projectsupport.dto.TeamStudentDto;
import pl.polsl.projectsupport.model.StudentTeamModel;
import pl.polsl.projectsupport.model.TeamModel;

import java.util.List;

public interface TeamService {
    void create(TeamDto teamDto);
    void addStudent(TeamStudentDto dto);
    TeamDto convertToDto(TeamModel teamModel);
    TeamModel convertToModel(TeamDto teamDto);

    StudentTeamModel convertToModel(StudentTeamDto studentTeamDto);

    List<TeamModel> getTeams();
    List<TeamDto> getTeamDtos();
    StudentTeamModel getStudentTeam(Long userId, Long teamId);
    StudentTeamDto getStudentTeamDto(Long userId, Long teamId);
    List<TeamDto> getTeamDtosByStudent(Long userId);
    List<TeamDto> getTeamDtosBySupervisor(Long userId);
    List<StudentTeamDto> getTeamMemberDtos(Long teamId);
    StudentTeamDto editStudentTeamDto(StudentTeamDto studentTeamDto, Long id);
    TeamDto editTeamDto(TeamDto teamDto, Long id);
}
