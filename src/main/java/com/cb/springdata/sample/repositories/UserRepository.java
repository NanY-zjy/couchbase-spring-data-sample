package com.cb.springdata.sample.repositories;

import com.cb.springdata.sample.entities.User;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;


@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "user")
public interface UserRepository extends CouchbasePagingAndSortingRepository<User, String> {


}
