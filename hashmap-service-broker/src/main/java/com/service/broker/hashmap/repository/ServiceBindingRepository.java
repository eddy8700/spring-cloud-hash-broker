package com.service.broker.hashmap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.service.broker.hashmap.domain.ServiceBinding;


/**
 * 
 * @author aditya.gupta2
 *
 */
@Repository
public interface ServiceBindingRepository extends CrudRepository<ServiceBinding,String> {
}
