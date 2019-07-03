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

	void addFilmSchedule(FilmSchedule filmSchedule);

	List<FilmSchedule> findRepeat(FilmSchedule filmSchedule);

	List<FilmSchedule> showByFilmRoom(String startDate, String endDate, String filmRoom);

	List<FilmSchedule> showByFilm(String startDate, String endDate, String filmRoom);

	void setStartDateAndEndDate(String id, String startDate, String endDate);

	void deleteById(String id);

	List<FilmSchedule> findById(int fid,String date);
}