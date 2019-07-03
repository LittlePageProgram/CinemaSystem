package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.ShowTicket;
import com.littlepage.mapper.MyTicketMapper;
/**
 * 电影服务
 * @author 74302
 *
 */
@Service
public class MyTicketService {
	
	@Autowired
	MyTicketMapper myticketMapper;

	public List<ShowTicket> getAllByTicket(int id) {
		return myticketMapper.getAllById(id);
	}

}
