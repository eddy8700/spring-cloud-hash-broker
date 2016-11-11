package com.spring.cloud.hashmap.broker.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.cloud.hashmap.broker.domain.ServiceInstance;

/**
 * 
 * @author aditya.gupta2
 *
 */
public interface ServiceInstanceRepository extends CrudRepository<ServiceInstance, String> {
}
