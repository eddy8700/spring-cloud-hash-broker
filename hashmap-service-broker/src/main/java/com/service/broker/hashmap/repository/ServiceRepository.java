package com.service.broker.hashmap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.service.broker.hashmap.domain.Service;


/**
 * 
 * @author aditya.gupta2
 *
 */
@Repository
public interface ServiceRepository extends CrudRepository<Service, String> {
}
