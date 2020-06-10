package com.apress.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apress.domain.User_Entity;

@Repository
public interface UserRepository extends CrudRepository<User_Entity, Long> {

}