package com.littlepage.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.littlepage.entity.Film;
import com.littlepage.mapper.FilmMapper;
import com.littlepage.utils.TimeUtils;

@Service
public class FilmService {

	@Autowired
	FilmMapper filmMapper;
	
	public String addFilm(Film film) {
		List<Film> f=filmMapper.findByName(film.getName());
		/**
		 * 判断是否存在
		 */
		if(f.size()!=0) {
			return "该电影已经存在";
		}
		/**
		 * 格式化时间
		 */
		film.setReleaseDate(TimeUtils.formatTime(film.getReleaseDate()));
		film.setReflectDate(TimeUtils.formatTime(film.getReflectDate()));
		/**
		 * 判断时间和当前时间比
		 */
		if(film.getReleaseDate().compareTo(TimeUtils.getCurrentTime())<0) {
			System.out.println(film.getReleaseDate());
			System.out.println(TimeUtils.getCurrentTime());
			return "上映日期应该在当前日期之前";
		}
		/**
		 * 判断下映日期应该在上映日期之前
		 */
		if(film.getReflectDate().compareTo(film.getReleaseDate())<0) {
			return "下映日期输入不能在上映日期之前";
		}
		filmMapper.addFilm(film);
		return "success";
	}

	public List<Film> findAll() {
		return filmMapper.findAll();
	}

	public Film findById(int id) {
		return filmMapper.findById(id);
	}


}
