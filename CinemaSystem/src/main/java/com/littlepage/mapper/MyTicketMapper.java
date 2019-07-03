package com.littlepage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.ShowTicket;

@Mapper
public interface MyTicketMapper {

	List<ShowTicket> getAllById(int id);

}
