package com.spring.cloud.hashmap.broker.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.cloud.hashmap.broker.domain.Service;


/**
 * 
 * @author aditya.gupta2
 *
 */
public interface ServiceRepository extends CrudRepository<Service, String> {
}
