package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dto.device;
import com.baidu.mapper.deviceMapper;

@Service
public class DeviceServiceImp implements IDeviceService{
	@Autowired
	private deviceMapper mapper;
	public List<device> seachDevice() {
		return mapper.seachDevice();
	}


}
