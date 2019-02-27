package com.gg.proj.business;

import com.gg.proj.consumer.wsdl.Book;
import com.gg.proj.model.BookModel;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperWorker {

    BookModel bookXsdToBookModel(Book book);

    List<BookModel> listXsdToListModel (Collection<Book> listXsd);
}
