package com.gg.proj.business.mapper;

import com.gg.proj.consumer.wsdl.books.Language;
import com.gg.proj.model.LanguageModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

    LanguageModel languageToLanguageModel(Language language);
}
