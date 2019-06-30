package com.littlepage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.Film;
/**
 * 电影的mybatis映射接口
 * @author 74302
 *
 */
@Mapper
public interface FilmMapper {
	public void addFilm(Film film);
	
	public List<Film> findAll();

	public List<Film> findById(int id);

	public List<Film> findByName(String name);
}
