package com.cb.springdata.sample.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.config.BeanNames;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;

import com.cb.springdata.sample.annotation.config.CustomMappingCouchbaseConverter;

@Configuration
@EnableReactiveCouchbaseRepositories
public class CustomReactiveCouchbaseConfiguration extends AbstractCouchbaseConfiguration {
	@Value(value = "${spring.couchbase.bucket.name}")
	private String bucket;
	
	@Value(value = "${spring.couchbase.bootstrap-hosts}")
	private String hosts;
	
	@Value(value = "${spring.couchbase.bucket.password}")
	private String password;
	 
	// 自定义注解@DocumentType配置
	// implement abstract methods
    // and configure custom mapping convereter
	// 重置默认属性 _class:value(通过@DocumentType)
    @Bean(name = BeanNames.COUCHBASE_MAPPING_CONVERTER)
    public MappingCouchbaseConverter mappingCouchbaseConverter() throws Exception {
        MappingCouchbaseConverter converter = new CustomMappingCouchbaseConverter(couchbaseMappingContext(), typeKey());
        converter.setCustomConversions(customConversions());
        return converter;
    }

    //重置默认属性 _class:key
    @Override
    public String typeKey() {
        return "type"; // this will owerride '_class'
    }

	@Override
	protected List<String> getBootstrapHosts() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add(hosts);
		return list;
	}

	@Override
	protected String getBucketName() {
		// TODO Auto-generated method stub
		return bucket;
	}

	@Override
	protected String getBucketPassword() {
		// TODO Auto-generated method stub
		return password;
	}
}
