package com.gg.proj.business.mapper;

import com.gg.proj.consumer.wsdl.books.*;
import com.gg.proj.model.BookModel;
import com.gg.proj.model.LanguageModel;
import com.gg.proj.model.LibraryModel;
import com.gg.proj.model.TopicModel;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookModel bookXsdToBookModel(Book book);

    List<BookModel> listXsdToListModel (Collection<Book> listXsd);

    List<BookModel> bookListToBookModelList(List<Book> books);

    List<LanguageModel> languageListToLanguageModelList(List<Language> languages);

    List<LibraryModel> libraryListToLibraryModelList(List<Library> libraries);

    List<TopicModel> topicListToTopicModelList(List<Topic> topics);

    BookModel bookFullToBookModel(BookFull bookFull);
}
