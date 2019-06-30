package com.littlepage.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.FilmSchedule;

/**
 * FilmScheduleMapper继承基类
 */
@Mapper
public interface FilmScheduleMapper {
	List<FilmSchedule> findByDate(String date);
}