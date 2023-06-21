package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"}, maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("")
    public String allAccess() {
        return "Public content";
    }

}
