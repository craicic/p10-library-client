package com.gg.proj.business.mapper;

import com.gg.proj.consumer.wsdl.books.Topic;
import com.gg.proj.model.TopicModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TopicMapper {


    List<TopicModel> topicListToTopicEntityList(List<Topic> topics);
}
