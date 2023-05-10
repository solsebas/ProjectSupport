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
@RequestMapping("/api")
public class TopicController {

    private final TopicService topicService;

    @PostMapping("/topics/add")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public void addTopic(@RequestBody TopicDto topicDto) {topicService.create(topicDto);}

    @GetMapping("/topics/get")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public List<TopicDto> getTopics(){ return topicService.getTopicDtos();}
}
