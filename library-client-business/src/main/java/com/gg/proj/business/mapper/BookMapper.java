package com.gg.proj.business.mapper;

import com.gg.proj.consumer.wsdl.books.*;
import com.gg.proj.model.*;
import com.gg.proj.model.complex.BookAndBookingInfoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookModel bookXsdToBookModel(Book book);

    List<BookModel> listXsdToListModel(Collection<Book> listXsd);

    List<BookModel> bookListToBookModelList(List<Book> books);

    List<LanguageModel> languageListToLanguageModelList(List<Language> languages);

    List<LibraryModel> libraryListToLibraryModelList(List<Library> libraries);

    List<TopicModel> topicListToTopicModelList(List<Topic> topics);

    BookModel bookFullToBookModel(BookFull bookFull);

    BookMinModel bookToBookMinModel(com.gg.proj.consumer.wsdl.loans.Book book);

    @Mappings({
            @Mapping(source = "id", target = "bookModel.id"),
            @Mapping(source = "title", target = "bookModel.title"),
            @Mapping(source = "author", target = "bookModel.author"),
            @Mapping(source = "isbn", target = "bookModel.isbn"),
            @Mapping(source = "topics", target = "topicModelList"),
            @Mapping(source = "language", target = "languageModel"),
            @Mapping(source = "quantity", target = "bookModel.quantity"),
            @Mapping(source = "publicationDate", target = "bookModel.publicationDate"),
            @Mapping(source = "library", target = "libraryModel"),
            @Mapping(source = "summary", target = "bookModel.summary")
    })
    BookAndBookingInfoModel bookAndBookingInfoDTOToModel(BookAndBookingInfo bookAndBookingInfo);
}
