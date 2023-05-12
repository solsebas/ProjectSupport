package pl.polsl.projectsupport.service;


import pl.polsl.projectsupport.dto.SupervisorDto;
import pl.polsl.projectsupport.model.SupervisorModel;

import java.util.List;

public interface SupervisorService {

    void create(SupervisorDto supervisorDto);
    public SupervisorDto convertToDto(SupervisorModel supervisorModel);
    public SupervisorModel convertToModel(SupervisorDto supervisorDto);
    public List<SupervisorModel> getSupervisors();
    public List<SupervisorDto> getSupervisorsDtos();

}
