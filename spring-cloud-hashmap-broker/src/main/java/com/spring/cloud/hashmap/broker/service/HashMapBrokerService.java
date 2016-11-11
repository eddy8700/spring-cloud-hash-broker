package com.spring.cloud.hashmap.broker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.cloud.hashmap.broker.util.CustomHashMap;
import com.spring.cloud.hashmap.broker.util.CustomHashMapApi;

@Component
public class HashMapBrokerService {
	
	@Autowired
	CustomHashMapApi<String, CustomHashMapApi<Object, Object>> customHashMapApi;
	

    public void create(String id) {
    	customHashMapApi.put(id, new CustomHashMap<Object, Object>());
    }

    public void delete(String id) {
    	customHashMapApi.remove(id);
    }

    public void put(String id, Object key, Object value) {
        CustomHashMapApi<Object, Object> mapInstance = customHashMapApi.get(id);
        mapInstance.put(key, value);
    }

    public Object get(String id, Object key) {
        CustomHashMapApi<Object, Object> mapInstance = customHashMapApi.get(id);
        return mapInstance.get(key);
    }

    public void delete(String id, Object key) {
        CustomHashMapApi<Object, Object> mapInstance = customHashMapApi.get(id);
        mapInstance.remove(key);
    }

}
