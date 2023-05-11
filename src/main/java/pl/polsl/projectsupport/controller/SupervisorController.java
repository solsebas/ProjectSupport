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
@RequestMapping("/api/supervisor")
public class SupervisorController {




    //region user Implementation
    //---------------------------------------------------------------------------------------
    @GetMapping("/userBoard")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public String supervisorUserAccess() {
        return "SUPERVISOR user content";
    }
    //---------------------------------------------------------------------------------------
    //endregion

}
