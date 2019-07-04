package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.Customerlog;
import com.littlepage.mapper.CustomerlogMapper;

@Service
public class CustomerlogService {
	
	@Autowired
	CustomerlogMapper customerlogMapper;

	public void add(int id, String info) {
		customerlogMapper.add(id,info);
	}

	public List<Customerlog> getAllBuyId(int id) {
		return customerlogMapper.getAllBuyId(id);
	}
}
