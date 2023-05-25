package pl.polsl.projectsupport.service;

import pl.polsl.projectsupport.dto.TermDto;
import pl.polsl.projectsupport.model.TermModel;

import java.util.List;

public interface TermService {
    void create(TermDto termDto);
    TermDto convertToDto(TermModel termModel);
    TermModel convertToModel(TermDto termDto);
    List<TermModel> getTerms();
    List<TermDto> getTermDtos();
    List<TermModel> findActiveTerms();

}
