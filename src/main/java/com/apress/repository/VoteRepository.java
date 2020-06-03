package com.apress.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apress.domain.Vote;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {

}
