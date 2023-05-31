package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pl.polsl.projectsupport.dao.UserDao;
import pl.polsl.projectsupport.dto.UserDto;
import pl.polsl.projectsupport.model.UserModel;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(UserDto userDto) {}

    @Override
    public UserDto convertToDto(UserModel userModel) {
        UserDto userDto = modelMapper.map(userModel, UserDto.class);
        //tutaj można edytować, np dodawać jakie nowe rzeczy
        return userDto;
    }

    @Override
    public UserModel convertToModel(UserDto userDto) {
        UserModel userModel = modelMapper.map(userDto, UserModel.class);
        return userModel;
    }

    @Override
    public List<UserModel> getUsers() {
        return userDao.findAll();
    }

    @Override
    public List<UserDto> getUsersDtos() {
        return getUsers().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
