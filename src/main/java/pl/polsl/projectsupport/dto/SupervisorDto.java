package pl.polsl.projectsupport.dto;

import lombok.Data;
import pl.polsl.projectsupport.model.UserModel;

@Data
public class SupervisorDto {
    int id;
    String firstname;
    String surname;
    UserModel user;
}
