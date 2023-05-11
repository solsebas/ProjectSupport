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
@RequestMapping("/api/admin")
public class AdminController {


    //region user Implementation
    //---------------------------------------------------------------------------------------
    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "ADMIN content";
    }
    //---------------------------------------------------------------------------------------
    //endregion

}
