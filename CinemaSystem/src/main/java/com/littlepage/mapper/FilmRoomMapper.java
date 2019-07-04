package com.littlepage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.FilmRoom;

@Mapper
public interface FilmRoomMapper {

	public void add(String name, String seatInfo) ;

	public List<FilmRoom> getAllFilmRoom();

	public void modify(String name, String seatInfo,int id);

	public void deleteById(int id);

}
