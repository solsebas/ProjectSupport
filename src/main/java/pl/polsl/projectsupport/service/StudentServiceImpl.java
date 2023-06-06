package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.projectsupport.dao.StudentDao;
import pl.polsl.projectsupport.dto.StudentDto;
import pl.polsl.projectsupport.model.StudentModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(StudentModel studentModel) {
        studentDao.save(studentModel);
    }

    @Override
    public StudentDto convertToDto(StudentModel studentModel) {
        StudentDto studentDto = modelMapper.map(studentModel, StudentDto.class);
        return studentDto;
    }

    @Override
    public StudentModel convertToModel(StudentDto studentDto) {
        return null;
    }

    @Override
    public List<StudentModel> getStudents() {
        return studentDao.findAll();
    }

    @Override
    public List<StudentDto> getStudentDtos() {
        return getStudents().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentsByTerm(Long termId) {
        List<StudentModel> students = studentDao.findStudentTerm(termId);
        return students.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

}
