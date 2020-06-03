package com.apress.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apress.domain.Poll;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {

}