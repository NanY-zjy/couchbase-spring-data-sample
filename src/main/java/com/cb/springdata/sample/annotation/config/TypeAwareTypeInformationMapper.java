package com.cb.springdata.sample.annotation.config;

import org.springframework.data.convert.SimpleTypeInformationMapper;
import org.springframework.data.mapping.Alias;
import org.springframework.data.util.TypeInformation;

import com.cb.springdata.sample.annotation.DocumentType;

public class TypeAwareTypeInformationMapper extends SimpleTypeInformationMapper {
	// @DocumentType set value
	@Override
    public Alias createAliasFor(TypeInformation<?> type) {
        DocumentType[] documentType = type.getType().getDeclaredAnnotationsByType(DocumentType.class);

        if (documentType.length == 1) {
            return Alias.of(documentType[0].value());
        }

        return super.createAliasFor(type);
    }
}