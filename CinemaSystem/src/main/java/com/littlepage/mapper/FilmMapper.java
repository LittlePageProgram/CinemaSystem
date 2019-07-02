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

	public List<Film> searchAll(String search);

	public List<Film> findByDate(String date);

	public void topUp(String price, int userid);

	public void deleteById(int id);

	public void modifyFilmById(int id, String name, String director, String scriptWriter, String actor, String type,
			String location, String language);
}
