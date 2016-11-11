package com.spring.cloud.hashmap.broker.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.cloud.hashmap.broker.domain.ServiceBinding;


/**
 * 
 * @author aditya.gupta2
 *
 */
public interface ServiceBindingRepository extends CrudRepository<ServiceBinding,String> {
}
