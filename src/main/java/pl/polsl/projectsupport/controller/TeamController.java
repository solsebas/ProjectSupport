package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projectsupport.dto.StudentTeamDto;
import pl.polsl.projectsupport.dto.TeamDto;
import pl.polsl.projectsupport.dto.TeamStudentDto;
import pl.polsl.projectsupport.service.TeamService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;


    //region TeamService Implementation
    //---------------------------------------------------------------------------------------
    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public List<TeamDto> getTeams() {
        return teamService.getTeamDtos();
    }

    @GetMapping("/student")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public List<TeamDto> getTeamsForStudent(@RequestParam Long id) {
        return teamService.getTeamDtosByStudent(id);
    }

    @GetMapping("/member")
    public StudentTeamDto getTeamMember(@RequestParam Long userId, @RequestParam Long teamId){
        return teamService.getStudentTeamDto(userId, teamId);
    }

    @PutMapping("/member/{id}")
    public StudentTeamDto editStudentTeam(@RequestBody StudentTeamDto studentTeamDto, @PathVariable Long id){
        return teamService.editStudentTeamDto(studentTeamDto, id);
    }

    @GetMapping("/supervisor")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public List<TeamDto> getTeamsForSupervisor(@RequestParam Long id) {
        return teamService.getTeamDtosBySupervisor(id);
    }

    @GetMapping("/members")
    public List<StudentTeamDto> getTeamMembers(@RequestParam Long teamId){
        return teamService.getTeamMemberDtos(teamId);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public void addTeam(@RequestBody TeamDto teamDto){
        teamService.create(teamDto);
    }

    @PostMapping("/student")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public void addStudent(@RequestBody TeamStudentDto dto){
        teamService.addStudent(dto);
    }
    //---------------------------------------------------------------------------------------
    //endregion

}
