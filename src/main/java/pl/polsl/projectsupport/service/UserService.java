package pl.polsl.projectsupport.service;

import pl.polsl.projectsupport.dto.UserDto;
import pl.polsl.projectsupport.model.UserModel;

import java.util.List;

public interface UserService {
    public void create(UserDto userDto);
    public UserDto convertToDto(UserModel userModel);
    public UserModel convertToModel(UserDto userDto);
    public List<UserModel> getUsers();
    public List<UserDto> getUsersDtos();
}
