package pl.polsl.projectsupport.service;

import org.springframework.web.multipart.MultipartFile;
import pl.polsl.projectsupport.dto.AttachmentDto;
import pl.polsl.projectsupport.dto.AttendanceDto;

public interface AttachmentService {
   // void addAttachmentService(AttachmentService dto);

    void create(Long id, MultipartFile file);
    void  addFile(AttachmentDto att);
}
