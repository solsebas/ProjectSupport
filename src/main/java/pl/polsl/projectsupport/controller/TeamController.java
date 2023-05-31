package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
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


    //region ADMIN and SUPERVISOR
    //---------------------------------------------------------------------------------------
    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public List<TeamDto> getTeams() {
        return teamService.getTeamDtos();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public void addTeam(@RequestBody TeamDto teamDto){
        teamService.create(teamDto);
    }

    @GetMapping("/supervisor")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public List<TeamDto> getTeamsForSupervisor(@RequestParam Long id) {
        return teamService.getTeamDtosBySupervisor(id);
    }

    @PutMapping("/member/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public StudentTeamDto editStudentTeam(@RequestBody StudentTeamDto studentTeamDto, @PathVariable Long id){
        return teamService.editStudentTeamDto(studentTeamDto, id);
    }

    @PutMapping("/status/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public TeamDto editTeam(@RequestBody TeamDto teamDto, @PathVariable Long id){
        return teamService.editTeamDto(teamDto, id);
    }

    @PostMapping("/student")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public void addStudent(@RequestBody TeamStudentDto dto){
        teamService.addStudent(dto);
    }

    @GetMapping("/members")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public List<StudentTeamDto> getTeamMembers(@RequestParam Long teamId){
        return teamService.getTeamMemberDtos(teamId);
    }

    //---------------------------------------------------------------------------------------
    //endregion

    @GetMapping("/member")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR') or hasRole('STUDENT')")
    public StudentTeamDto getTeamMember(@RequestParam Long userId, @RequestParam Long teamId){
        return teamService.getStudentTeamDto(userId, teamId);
    }

    @GetMapping("/student")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT')")
    public List<TeamDto> getTeamsForStudent(@RequestParam Long id) {
        return teamService.getTeamDtosByStudent(id);
    }

}
