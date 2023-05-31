package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.projectsupport.dao.TermDao;
import pl.polsl.projectsupport.dto.TermDto;
import pl.polsl.projectsupport.model.TermModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TermServiceImpl implements TermService {
    @Autowired
    private TermDao termDao;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void create(TermDto termDto) {
        TermModel termModel = convertToModel(termDto);
        termDao.save(termModel);
    }

    @Override
    public TermDto convertToDto(TermModel termModel) {
        TermDto termDto = modelMapper.map(termModel, TermDto.class);
        return termDto;
    }

    @Override
    public TermModel convertToModel(TermDto termDto) {
        TermModel termModel = modelMapper.map(termDto, TermModel.class);
        return termModel;
    }

    @Override
    public List<TermModel> getTerms() {
        return termDao.findAll();
    }

    @Override
    public List<TermDto> getTermDtos() {
        List<TermModel> terms = findActiveTerms();
        return terms.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TermModel> findActiveTerms() {
        return termDao.findActiveTerms();
    }
}
