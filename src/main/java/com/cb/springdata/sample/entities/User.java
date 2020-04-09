package com.cb.springdata.sample.entities;

import org.springframework.data.couchbase.core.mapping.Document;

import com.cb.springdata.sample.annotation.DocumentType;
import com.couchbase.client.java.repository.annotation.Id;

import lombok.*;

@DocumentType("task-list")
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
	@Id
    private String id;

    private String name;

    private String owner="user1";
    
//    private String type = "task-list";


}
