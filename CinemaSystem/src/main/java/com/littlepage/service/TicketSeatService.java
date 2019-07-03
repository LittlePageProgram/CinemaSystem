package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.Ticketseat;
import com.littlepage.mapper.TicketseatMapper;
/**
 * 票务座位服务类
 * @author 74302
 *
 */
@Service
public class TicketSeatService {
	
	@Autowired
	TicketseatMapper ticketseatMapper;

	/**
	 * 查找票务
	 * @param sid
	 * @return
	 */
	public List<Ticketseat> findAllByScheduleId(int sid) {
		return ticketseatMapper.findAllId(sid);
	}
	/**
	 * 增加票务
	 * @param id
	 * @param sid
	 * @param seatNum
	 */
	public void addTicketSeat(int id,int sid, int seatNum) {
		ticketseatMapper.addTicketSeat(id,sid,seatNum);
	}
	
	/**
	 * 根据id删除服务
	 * @param id
	 */
	public void deleteById(int id) {
		ticketseatMapper.deleteById(id);
	}

}
