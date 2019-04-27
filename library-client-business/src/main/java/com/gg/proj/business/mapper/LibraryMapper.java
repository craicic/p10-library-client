package com.gg.proj.business.mapper;

import com.gg.proj.consumer.wsdl.books.Library;
import com.gg.proj.model.LibraryModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryMapper {

    LibraryModel libraryToLibraryModel(Library library);
}
