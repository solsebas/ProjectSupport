package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.projectsupport.dao.AttendanceDao;
import pl.polsl.projectsupport.dao.StudentTeamDao;
import pl.polsl.projectsupport.dto.AttendanceDto;
import pl.polsl.projectsupport.dto.StudentTeamDto;
import pl.polsl.projectsupport.model.AttendanceModel;
import pl.polsl.projectsupport.model.StudentTeamModel;
import pl.polsl.projectsupport.service.email.EmailService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AttendanceDao attendanceDao;

    @Autowired
    private StudentTeamDao studentTeamDao;

    @Autowired
    private EmailService emailService;

    @Override
    public void addAttendance(AttendanceDto dto) {
        AttendanceModel model = convertToModel(dto);
        attendanceDao.save(model);

        StudentTeamModel studentTeamModel = studentTeamDao.findById(dto.getMemberId()).get();
        String targetEmail = studentTeamModel.getStudent().getUser().getEmail();
        emailService.sendNewAttendanceNotification(targetEmail, dto, studentTeamModel.getStudent().getFirstName(), studentTeamModel.getTeam().getTopic().getName());
    }

    private AttendanceModel convertToModel(AttendanceDto dto){
        AttendanceModel model = modelMapper.map(dto, AttendanceModel.class);
        model.setParticipant(studentTeamDao.findById(dto.getMemberId()).get());
        return model;
    }
}
