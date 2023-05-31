package pl.polsl.projectsupport.dto;

import lombok.Data;
import pl.polsl.projectsupport.model.UserModel;

@Data
public class StudentDto {
    Long id;
    String firstName;
    String surname;
    UserModel user;
}
