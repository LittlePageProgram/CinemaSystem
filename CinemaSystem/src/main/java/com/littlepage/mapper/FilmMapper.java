package com.littlepage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.Film;

@Mapper
public interface FilmMapper {
	public void addFilm(Film film);
	
	public List<Film> findAll();
}
