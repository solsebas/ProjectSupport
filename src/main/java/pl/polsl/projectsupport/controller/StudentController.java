package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projectsupport.dto.StudentDto;
import pl.polsl.projectsupport.dto.TopicDto;
import pl.polsl.projectsupport.service.StudentService;
import pl.polsl.projectsupport.service.TopicService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;
    private final TopicService topicService;

    //@GetMapping("/supervisorId")
    //public List<SupervisorDto> getSupervisors(){ return supervisorService.getSupervisorDtos();}

    @PostMapping("/topics/delete")
    public void deleteTopic(@RequestBody TopicDto topicDto) {topicService.delete(topicDto);}
    @PostMapping("/topics/add")
    public void addTopic(@RequestBody TopicDto topicDto) {topicService.create(topicDto);}
    @GetMapping("/topics")
    public List<TopicDto> getTopics(){ return topicService.getTopicDtos();}

    @GetMapping("/students")
    public List<StudentDto> getStudents(){
        return studentService.getStudentDtos();
    }
}
