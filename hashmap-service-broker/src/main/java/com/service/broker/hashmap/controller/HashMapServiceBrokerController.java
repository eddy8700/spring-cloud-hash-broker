package com.service.broker.hashmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.broker.hashmap.service.HashMapBrokerService;

/**
 * 
 * @author aditya.gupta2
 *
 */
@RestController
public class HashMapServiceBrokerController {

	@Autowired
	private HashMapBrokerService hashMapBrokerService;

	/**
	 * 
	 * @param instanceId
	 * @param key
	 * @param value
	 * @return
	 */
	@RequestMapping(value = "/hash/{instanceId}/{key}", method = RequestMethod.PUT)
	public ResponseEntity<String> put(@PathVariable("instanceId") String instanceId, @PathVariable("key") String key,
			@RequestBody String value) {
		hashMapBrokerService.put(instanceId, key, value);
		return new ResponseEntity<>("{}", HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param instanceId
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/hash/{instanceId}/{key}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("instanceId") String instanceId, @PathVariable("key") String key) {
		Object result = hashMapBrokerService.get(instanceId, key);
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("{}", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 
	 * @param instanceId
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/hash/{instanceId}/{key}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("instanceId") String instanceId,
			@PathVariable("key") String key) {
		Object result = hashMapBrokerService.get(instanceId, key);
		if (result != null) {
			hashMapBrokerService.delete(instanceId, key);
			return new ResponseEntity<>("{}", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("{}", HttpStatus.GONE);
		}
	}

}
