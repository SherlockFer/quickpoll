package com.apress.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apress.domain.Option;

@Repository
public interface OptionRepository extends CrudRepository<Option, Long> {

}