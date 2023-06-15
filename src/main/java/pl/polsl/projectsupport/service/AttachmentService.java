package pl.polsl.projectsupport.service;

import pl.polsl.projectsupport.dto.AttachmentDto;
import pl.polsl.projectsupport.dto.AttendanceDto;

public interface AttachmentService {
    void addAttachmentService(AttachmentService dto);

    void create(AttachmentDto attachmenDto);
}
