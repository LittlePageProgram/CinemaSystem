package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.FilmRoom;
import com.littlepage.mapper.FilmRoomMapper;
/**
 * 电影房间服务
 * @author 74302
 *
 */
@Service
public class FilmRoomService {
	
	@Autowired
	FilmRoomMapper filmRoomMapper;

	public void addFilmRoom(String name, String seatInfo) {
		filmRoomMapper.add(name,seatInfo);
	}

	public List<FilmRoom> getAllFilmRoom() {
		return filmRoomMapper.getAllFilmRoom();
	}

	public void modify(String name, String seatInfo,int id) {
		filmRoomMapper.modify(name,seatInfo,id);
	}

	public void delete(int id) {
		filmRoomMapper.deleteById(id);
	}
	
	
	
}
