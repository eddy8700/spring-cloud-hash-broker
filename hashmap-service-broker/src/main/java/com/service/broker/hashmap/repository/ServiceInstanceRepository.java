package com.service.broker.hashmap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.service.broker.hashmap.domain.ServiceInstance;

/**
 * 
 * @author aditya.gupta2
 *
 */
@Repository
public interface ServiceInstanceRepository extends CrudRepository<ServiceInstance, String> {
}
