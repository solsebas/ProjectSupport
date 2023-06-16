package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projectsupport.dto.TopicDto;
import pl.polsl.projectsupport.service.TermService;
import pl.polsl.projectsupport.service.TopicService;
import pl.polsl.projectsupport.service.AttachmentService;
import pl.polsl.projectsupport.dto.AttachmentDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/files")

public class  FileController {

    private final AttachmentService attt ;



    @PostMapping("")
    public void handleFileUpload(
            @RequestParam("id") Long id,
            @RequestParam("file") MultipartFile file,
    @RequestBody AttachmentDto dto) {
        attt.addFile(dto);
        // Обработка загруженного файла и идентификатора в вашем бэкенд-коде
        // ...
 }


}
