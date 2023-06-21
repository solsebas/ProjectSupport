package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projectsupport.dto.TopicDto;
import pl.polsl.projectsupport.service.TermService;
import pl.polsl.projectsupport.service.TopicService;
import pl.polsl.projectsupport.service.AttachmentService;
import pl.polsl.projectsupport.dto.AttachmentDto;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"}, maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/files")

public class  FileController {

    private final AttachmentService attt ;



    @PostMapping("")
    public void addFile(@RequestBody AttachmentDto attachmentDto )
    {
        attt.create(attachmentDto);
    }



}
