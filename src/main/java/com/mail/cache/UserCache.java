package com.mail.cache;

import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;

import com.mail.bo.UserDto;

public final class UserCache {

	private Map<String, Object> dataMap = null;

	private UserCache() {
		dataMap = new ConcurrentHashMap<String, Object>();
	}

	public void put(String mobile, String message) {
		UserDto userDto = null;
		userDto = new UserDto();
		userDto.setMessage(message);
		userDto.setMobile(mobile);
		dataMap.put(mobile, userDto);
	}

	public Object get(String key) {
		return dataMap.get(key);
	}

	public void putAll(Map<String, Object> data) {
		dataMap.putAll(data);
	}

	public boolean containsKey(String key) {
		return dataMap.containsKey(key);
	}
}
