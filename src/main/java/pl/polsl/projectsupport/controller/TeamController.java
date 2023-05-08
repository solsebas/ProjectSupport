package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projectsupport.dto.TeamDto;
import pl.polsl.projectsupport.dto.TeamStudentDto;
import pl.polsl.projectsupport.service.TeamService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api")
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/teams")
    public List<TeamDto> getTeams() {
        return teamService.getTeamDtos();
    }

    @PostMapping("/teams")
    public void addTeam(@RequestBody TeamDto teamDto){
        teamService.create(teamDto);
    }

    @PostMapping("teams/student")
    public void addStudent(@RequestBody TeamStudentDto dto){
        teamService.addStudent(dto);
    }
}
