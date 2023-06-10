package pl.polsl.projectsupport.service;

import pl.polsl.projectsupport.dto.StudentDto;
import pl.polsl.projectsupport.model.StudentModel;

import java.util.List;

public interface StudentService {
    void create(StudentModel studentModel);
    public StudentDto convertToDto(StudentModel studentModel);
    public StudentModel convertToModel(StudentDto studentDto);
    public List<StudentModel> getStudents();
    public List<StudentDto> getStudentDtos();

    List<StudentDto> getStudentsByTerm(Long termId);
}
