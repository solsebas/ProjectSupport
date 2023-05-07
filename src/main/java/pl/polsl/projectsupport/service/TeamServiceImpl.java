package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.projectsupport.dao.StudentDao;
import pl.polsl.projectsupport.dao.StudentTeamDao;
import pl.polsl.projectsupport.dao.TeamDao;
import pl.polsl.projectsupport.dto.StudentDto;
import pl.polsl.projectsupport.dto.TeamDto;
import pl.polsl.projectsupport.dto.TeamStudentDto;
import pl.polsl.projectsupport.enums.TeamStatus;
import pl.polsl.projectsupport.model.StudentModel;
import pl.polsl.projectsupport.model.StudentTeamModel;
import pl.polsl.projectsupport.model.TeamModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentTeamDao studentTeamDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(TeamDto teamDto) {
        TeamModel teamModel = convertToModel(teamDto);
        teamModel.setStatus(TeamStatus.NEW);
        teamModel.setStudents(new ArrayList<>());
        teamDao.save(teamModel);
    }

    @Override
    public void addStudent(TeamStudentDto dto) {
        Optional<StudentModel> student = studentDao.findById(dto.getStudentId());
        Optional<TeamModel> team = teamDao.findById(dto.getTeamId());
        StudentTeamModel studentTeamModel = new StudentTeamModel();
        studentTeamModel.setStudent(student.get());
        studentTeamModel.setTeam(team.get());
        studentTeamDao.save(studentTeamModel);
        //todo: walidacja od strony backendu czy już jest takie połączenie
    }

    @Override
    public TeamDto convertToDto(TeamModel teamModel) {
        TeamDto teamDto = modelMapper.map(teamModel, TeamDto.class);
        List<StudentDto> students = teamModel.getStudents().stream()
                .map(studentTeamModel -> studentTeamModel.getStudent())
                .map(studentModel -> modelMapper.map(studentModel, StudentDto.class))
                .collect(Collectors.toList());
        teamDto.setStudentList(students);
        return teamDto;
    }

    @Override
    public TeamModel convertToModel(TeamDto teamDto) {
        TeamModel teamModel = modelMapper.map(teamDto, TeamModel.class);
        return teamModel;
    }

    @Override
    public List<TeamModel> getTeams() {
        return teamDao.findAll();
    }

    @Override
    public List<TeamDto> getTeamDtos() {
        return getTeams().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
