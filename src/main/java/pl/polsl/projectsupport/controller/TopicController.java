package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projectsupport.dto.TopicDto;
import pl.polsl.projectsupport.service.TopicService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/topics")
public class TopicController {

    private final TopicService topicService;


    //region TopicService Implementation
    //---------------------------------------------------------------------------------------
    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public void addTopic(@RequestBody TopicDto topicDto) {topicService.create(topicDto);}

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public List<TopicDto> getTopics(){ return topicService.getTopicDtos();}
    //---------------------------------------------------------------------------------------
    //endregion
    @GetMapping("/topicsS")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public List<TopicDto> getTopicsBySupervisorId(@RequestParam Long supervisorId) {
        return topicService.getTopicDtosBySupervisorId(supervisorId);
    }

    @PutMapping("/{topicId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public void updateTopic(@PathVariable Long topicId, @RequestBody TopicDto topicDto) {
        topicService.updateArchieve(topicId, topicDto);
    }

}
