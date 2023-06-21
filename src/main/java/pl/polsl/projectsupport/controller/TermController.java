package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projectsupport.dto.TermDto;
import pl.polsl.projectsupport.model.TermModel;
import pl.polsl.projectsupport.service.TermService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"}, maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/terms")
public class TermController {
    private final TermService termService;
    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public List<TermDto> getTerms() {
        return termService.getTermDtos();
    }
}
