package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.projectsupport.dao.StudentDao;
import pl.polsl.projectsupport.dao.StudentTeamDao;
import pl.polsl.projectsupport.dao.TeamDao;
import pl.polsl.projectsupport.dto.*;
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
                .map(StudentTeamModel::getStudent)
                .map(studentModel -> modelMapper.map(studentModel, StudentDto.class))
                .collect(Collectors.toList());
        teamDto.setStudentList(students);
        return teamDto;
    }

    public StudentTeamDto convertToDto(StudentTeamModel studentTeamModel) {
        StudentTeamDto studentTeamDto = modelMapper.map(studentTeamModel, StudentTeamDto.class);
        List<StudentDto> students = studentDao.findByTeamId(studentTeamModel.getTeam().getId()).stream()
                .map(studentModel -> modelMapper.map(studentModel, StudentDto.class))
                .collect(Collectors.toList());
        List<AttendanceDto> attendances = studentTeamModel.getAttendances().stream()
                .map(attendanceModel -> modelMapper.map(attendanceModel, AttendanceDto.class))
                .collect(Collectors.toList());
        studentTeamDto.getTeam().setStudentList(students);
        studentTeamDto.setAttendanceList(attendances);
        return studentTeamDto;
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

    @Override
    public StudentTeamModel getStudentTeam(Long userId, Long teamId) {
        return studentTeamDao.findStudentTeamModelByTeamAndStudent(userId, teamId);
    }

    @Override
    public StudentTeamDto getStudentTeamDto(Long userId, Long teamId) {
        return convertToDto(getStudentTeam(userId, teamId));
    }

    @Override
    public List<TeamDto> getTeamDtosByStudent(Long userId) {
        return getTeamsByStudent(userId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TeamDto> getTeamDtosBySupervisor(Long userId) {
        return getTeamsBySupervisor(userId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentTeamDto> getTeamMemberDtos(Long teamId) {
        return getTeamMembers(teamId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private List<StudentTeamModel> getTeamMembers(Long teamId) {
        return studentTeamDao.findMembersByTeamId(teamId);
    }

    private List<TeamModel> getTeamsBySupervisor(Long userId) {
        return teamDao.findTeamsBySupervisorUserId(userId);
    }

    private List<TeamModel> getTeamsByStudent(Long userId) {
        return teamDao.findTeamsByParticipantUserId(userId);
    }
}
