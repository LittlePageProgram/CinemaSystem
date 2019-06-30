package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.FilmSchedule;
import com.littlepage.mapper.FilmMapper;
import com.littlepage.mapper.FilmScheduleMapper;

@Service
public class FilmScheduleService {
	
	@Autowired
	FilmScheduleMapper filmScheduleMapper;

	public List<FilmSchedule> findByDate(String date) {
		return filmScheduleMapper.findByDate(date);
	}
}
