package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.projectsupport.dao.TopicDao;
import pl.polsl.projectsupport.dto.TopicDto;
import pl.polsl.projectsupport.model.TopicModel;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TopicDto convertToDto(TopicModel topicModel) {
        TopicDto topicDto = modelMapper.map(topicModel, TopicDto.class);
        return topicDto;
    }

    @Override
    public TopicModel convertToModel(TopicDto topicDto) {
        //todo: implement if needed
        return null;
    }

    @Override
    public List<TopicModel> getTopics() {
        return topicDao.findAll();
    }

    @Override
    public List<TopicDto> getTopicDtos() {
        return getTopics().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    @Override
    public void create(TopicModel topicModel)
    {
        topicDao.save(topicModel);
    }
}
