package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.projectsupport.dao.SupervisorDao;
import pl.polsl.projectsupport.dto.SupervisorDto;
import pl.polsl.projectsupport.model.SupervisorModel;
import pl.polsl.projectsupport.model.UserModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    @Autowired
    private SupervisorDao supervisorDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(SupervisorDto supervisorDto) {
        SupervisorModel supervisorModel = convertToModel(supervisorDto);
        supervisorDao.save(supervisorModel);
    }

    @Override
    public SupervisorDto convertToDto(SupervisorModel supervisorModel) {
        SupervisorDto supervisorDto = modelMapper.map(supervisorModel, SupervisorDto.class);
        return supervisorDto;
    }

    @Override
    public SupervisorModel convertToModel(SupervisorDto supervisorDto) {
        //modelMapper.addMapping(mapper -> mapper.skip(TopicModel::setId));  TODO cleaner rozwiązanie
        SupervisorModel supervisorModel = modelMapper.map(supervisorDto, SupervisorModel.class);
        supervisorModel.setId(null);
        return supervisorModel;
    }

    @Override
    public List<SupervisorModel> getSupervisors() {
        return supervisorDao.findAll();
    }

    @Override
    public List<SupervisorDto> getSupervisorsDtos() {
        return getSupervisors().stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
