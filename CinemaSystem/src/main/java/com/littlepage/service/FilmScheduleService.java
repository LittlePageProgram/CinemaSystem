package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.Film;
import com.littlepage.entity.FilmSchedule;
import com.littlepage.mapper.FilmMapper;
import com.littlepage.mapper.FilmScheduleMapper;

@Service
public class FilmScheduleService {
	
	@Autowired
	FilmScheduleMapper filmScheduleMapper;
	
	@Autowired
	FilmMapper filmMapper;
	
	/**
	 * 根据日期进行查找电影排班
	 * @param date
	 * @return
	 */
	public List<FilmSchedule> findByDate(String date) {
		return filmScheduleMapper.findByDate(date);
	}

	/**
	 * 增加电影排班,false为时间段重复
	 * @param film
	 * @param filmSchedule
	 */
	public boolean addSchedule(String filmName, FilmSchedule filmSchedule) {
		List<Film> film=filmMapper.findByName(filmName);
		filmSchedule.setFid(film.get(0).getId()+"");
		
		//如果这个时间段有时间重复,直接返回失败
		List<FilmSchedule> li=filmScheduleMapper.findRepeat(filmSchedule);
		if(li.size()!=0) {
			return false;
		}
		//前中后插入30个排班
		filmSchedule.setView("前排");
		for(int i=0;i<30;i++) {
			filmScheduleMapper.addFilmSchedule(filmSchedule);
		}
		filmSchedule.setView("中排");
		for(int i=0;i<30;i++) {
			filmScheduleMapper.addFilmSchedule(filmSchedule);
		}
		filmSchedule.setView("后排");
		for(int i=0;i<30;i++) {
			filmScheduleMapper.addFilmSchedule(filmSchedule);
		}
		return true;
	}

	public List<FilmSchedule> showList(String startDate, String endDate, String filmRoom, String sightView) {
		List<FilmSchedule> list=null;
		if(sightView.equals("影厅")) {
			list=filmScheduleMapper.showByFilmRoom(startDate,endDate,filmRoom);
		}else {
			list=filmScheduleMapper.showByFilm(startDate,endDate,filmRoom);
		}
		return list;
	}
}
