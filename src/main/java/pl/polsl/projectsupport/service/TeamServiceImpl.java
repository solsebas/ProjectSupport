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
import pl.polsl.projectsupport.service.email.EmailService;

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
    private EmailService emailService;

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

        String targetEmail = studentTeamModel.getStudent().getUser().getEmail();
        emailService.sendNewTeamNotification(targetEmail, convertToDto(studentTeamModel));
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
        List<AttendanceDto> attendances = null;
        if (studentTeamModel.getAttendances() != null) {
            attendances = studentTeamModel.getAttendances().stream()
                    .map(attendanceModel -> modelMapper.map(attendanceModel, AttendanceDto.class))
                    .collect(Collectors.toList());
        }
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
    public StudentTeamModel convertToModel(StudentTeamDto studentTeamDto) {
        StudentTeamModel studentTeamModel = modelMapper.map(studentTeamDto, StudentTeamModel.class);
        return studentTeamModel;
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

    @Override
    public StudentTeamDto editStudentTeamDto(StudentTeamDto dto, Long id) {
        StudentTeamModel studentTeamModel = editStudentTeam(dto, id);

        String targetEmail = studentTeamModel.getStudent().getUser().getEmail();
        emailService.sendNewGradeNotification(targetEmail, dto);

        return convertToDto(studentTeamModel);
    }

    @Override
    public TeamDto editTeamDto(TeamDto teamDto, Long id) {
        TeamModel teamModel = editTeam(teamDto, id);
        return convertToDto(teamModel);
    }

    private StudentTeamModel editStudentTeam(StudentTeamDto studentTeamDto, Long id){
        return studentTeamDao.findById(id)
                .map(studentTeamModel -> {
                    studentTeamModel.setGrade((short)studentTeamDto.getGrade());
                    return studentTeamDao.save(studentTeamModel);
                })
                .orElseGet(() -> studentTeamDao.save(convertToModel(studentTeamDto)));
    }

    private TeamModel editTeam(TeamDto teamDto, Long id){
        return teamDao.findById(id)
                .map(teamModel -> {
                    teamModel.setStatus(TeamStatus.valueOf(teamDto.getStatus()));
                    return teamDao.save(teamModel);
                })
                .orElseGet(() -> teamDao.save(convertToModel(teamDto)));
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
