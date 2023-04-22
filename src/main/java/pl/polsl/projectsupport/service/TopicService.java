package pl.polsl.projectsupport.service;

import pl.polsl.projectsupport.dto.TopicDto;
import pl.polsl.projectsupport.model.TopicModel;

import java.util.List;

public interface TopicService {
    public void create(TopicModel topicModel);
    public TopicDto convertToDto(TopicModel topicModel);
    public TopicModel convertToModel(TopicDto topicDto);
    public List<TopicModel> getTopics();
    public List<TopicDto> getTopicDtos();
}
