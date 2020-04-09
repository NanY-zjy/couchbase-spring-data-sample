package com.cb.springdata.sample.annotation.config;

import java.util.Collections;

import org.springframework.data.convert.DefaultTypeMapper;
import org.springframework.data.couchbase.core.convert.CouchbaseTypeMapper;
import org.springframework.data.couchbase.core.convert.DefaultCouchbaseTypeMapper;
import org.springframework.data.couchbase.core.mapping.CouchbaseDocument;

public class TypeBasedCouchbaseTypeMapper extends DefaultTypeMapper<CouchbaseDocument> implements CouchbaseTypeMapper {

    private final String typeKey;

    public TypeBasedCouchbaseTypeMapper(final String typeKey) {
        super(new DefaultCouchbaseTypeMapper.CouchbaseDocumentTypeAliasAccessor(typeKey),
              Collections.singletonList(new TypeAwareTypeInformationMapper()));
        this.typeKey = typeKey;
    }

    @Override
    public String getTypeKey() {
        return typeKey;
    }
}
