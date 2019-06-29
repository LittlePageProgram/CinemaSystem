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

@Service
public class FilmService {

	@Autowired
	FilmMapper filmMapper;
	
	public String addFilm(Film film) {
		filmMapper.addFilm(film);
		return "";
	}

	public List<Film> findAll() {
		return filmMapper.findAll();
	}


}
