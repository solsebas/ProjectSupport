package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projectsupport.dto.StudentDto;
import pl.polsl.projectsupport.dto.TopicDto;
import pl.polsl.projectsupport.model.TopicModel;
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

    @PostMapping("/topics")
    public void addTopic(@RequestBody TopicModel topicModel)
    {
        topicService.create(topicModel);
    }
    //@GetMapping("/topics")
    //public List<TopicDto> getTopic(){ return topicService.getTopicDtos();}
    @GetMapping("/students")
    public List<StudentDto> getStudents(){
        return studentService.getStudentDtos();
    }
}
