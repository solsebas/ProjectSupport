package pl.polsl.projectsupport.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.projectsupport.dao.TopicDao;
import pl.polsl.projectsupport.dto.TopicDto;
import pl.polsl.projectsupport.model.TopicModel;

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
        //tutaj można edytować, np dodawać jakie nowe rzeczy
        return topicDto;
    }

    @Override
    public TopicModel convertToModel(TopicDto topicDto) {
        TopicModel topicModel = modelMapper.map(topicDto, TopicModel.class);
        return topicModel;
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
    public void create(TopicDto topicDto)
    {
        TopicModel topicModel = convertToModel(topicDto);
        topicDao.save(topicModel);
    }
}