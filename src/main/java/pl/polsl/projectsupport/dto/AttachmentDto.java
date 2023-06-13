package pl.polsl.projectsupport.dto;

import lombok.Data;

@Data
public class AttachmentDto {
    Long id;
    String filename;
    byte[] content;
    Long idUser;

}