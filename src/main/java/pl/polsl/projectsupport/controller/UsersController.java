package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/test")
public class UsersController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "ADMIN content";
    }

    @GetMapping("/studentUser")
    @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT')")
    public String studentUserAccess() {
        return "STUDENT user content";
    }

    @GetMapping("/supervisorUser")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public String supervisorUserAccess() {
        return "SUPERVISOR user content";
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Public content";
    }

}
