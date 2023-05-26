package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.projectsupport.dao.AttendanceDao;
import pl.polsl.projectsupport.dao.StudentTeamDao;
import pl.polsl.projectsupport.dto.AttendanceDto;
import pl.polsl.projectsupport.model.AttendanceModel;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AttendanceDao attendanceDao;

    @Autowired
    private StudentTeamDao studentTeamDao;

    @Override
    public void addAttendance(AttendanceDto dto) {
        AttendanceModel model = convertToModel(dto);
        attendanceDao.save(model);
    }

    private AttendanceModel convertToModel(AttendanceDto dto){
        AttendanceModel model = modelMapper.map(dto, AttendanceModel.class);
        model.setParticipant(studentTeamDao.findById(dto.getMemberId()).get());
        return model;
    }
}
