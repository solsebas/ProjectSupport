package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.projectsupport.dao.AttendanceDao;
import pl.polsl.projectsupport.dao.StudentTeamDao;
import pl.polsl.projectsupport.dto.AttachmentDto;
import pl.polsl.projectsupport.model.AttachmentModel;
import pl.polsl.projectsupport.service.email.EmailService;
import pl.polsl.projectsupport.dao.FilesDao;

@Service
public abstract class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FilesDao fileDao;
    @Autowired
    private AttendanceDao attendanceDao;

    @Autowired
    private StudentTeamDao studentTeamDao;

    @Autowired
    private EmailService emailService;

    @Override
    public void create(AttachmentDto attachmenDto) {
        AttachmentModel attModel = convertToModel(attachmenDto);
        fileDao.save(attModel);
    }

    private AttachmentModel convertToModel(AttachmentDto attachmenDto) {
        AttachmentModel filemodel = modelMapper.map(attachmenDto, AttachmentModel.class );

    return  filemodel;
    }
}
