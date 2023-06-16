package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.polsl.projectsupport.dao.AttendanceDao;
import pl.polsl.projectsupport.dao.StudentTeamDao;
import pl.polsl.projectsupport.dto.AttachmentDto;
import pl.polsl.projectsupport.model.AttachmentModel;
import pl.polsl.projectsupport.model.StudentModel;
import pl.polsl.projectsupport.model.StudentTeamModel;
import pl.polsl.projectsupport.model.TeamModel;
import pl.polsl.projectsupport.service.email.EmailService;
import pl.polsl.projectsupport.dao.FilesDao;
import pl.polsl.projectsupport.dao.*;

import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {

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
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private FilesDao filesDao;


    @Override
    public void create(Long id, MultipartFile file) {

    }

    private AttachmentModel convertToModel(AttachmentDto attachmenDto) {
        AttachmentModel filemodel = modelMapper.map(attachmenDto, AttachmentModel.class);

        return  filemodel;
    }
        public void  addFile (AttachmentDto dto)

        {
            Optional<TeamModel> team = teamDao.findById(dto.getIdUser());
            AttachmentModel model = new AttachmentModel();
            model.setContent(dto.getContent());

            StudentTeamModel studentTeamModel = new StudentTeamModel();

            studentTeamModel.setTeam(team.get());
            model.setAuthor(studentTeamModel);

            filesDao.save(model);

        }


}
