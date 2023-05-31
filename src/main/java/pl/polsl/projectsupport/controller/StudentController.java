package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.projectsupport.dto.StudentDto;
import pl.polsl.projectsupport.service.StudentService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;


    //region StudentService Implementation
    //---------------------------------------------------------------------------------------
    @GetMapping("/students")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT') or hasRole('SUPERVISOR')")
    public List<StudentDto> getStudents(){
        return studentService.getStudentDtos();
    }
    //---------------------------------------------------------------------------------------
    //endregion


}
