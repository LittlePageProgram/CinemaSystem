package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.Ticketseat;
import com.littlepage.mapper.TicketseatMapper;

@Service
public class TicketSeatService {
	
	@Autowired
	TicketseatMapper ticketseatMapper;

	public List<Ticketseat> findAllByScheduleId(int sid) {
		return ticketseatMapper.findAllByScheduleId(sid);
	}

	public void addTicketSeat(int id,int sid, int seatNum) {
		ticketseatMapper.addTicketSeat(id,sid,seatNum);
	}

}
