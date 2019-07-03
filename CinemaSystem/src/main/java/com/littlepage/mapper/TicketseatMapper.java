package com.littlepage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.Ticketseat;

@Mapper
public interface TicketseatMapper {

	List<Ticketseat> findAllByScheduleId(int sid);

	void addTicketSeat(int id,int sid, int seatNum);

}
