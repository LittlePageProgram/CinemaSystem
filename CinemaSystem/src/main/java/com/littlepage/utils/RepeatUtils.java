package com.littlepage.utils;

import java.util.ArrayList;
import java.util.List;

import com.littlepage.entity.FilmSchedule;

public class RepeatUtils {
	/**
	 * 去除 重复
	 * @param li
	 * @return
	 */
	public static List<FilmSchedule> repeatSolve(List<FilmSchedule> li){
		List<FilmSchedule> li2=new ArrayList<FilmSchedule>();
		for (FilmSchedule filmSchedule : li) {
			boolean flag=true;
			for (FilmSchedule filmSchedule2 : li2) {
				if(filmSchedule2.getStarttime().equals(filmSchedule.getStarttime())) {
					flag=false;
					break;
				}
			}
			if(flag) li2.add(filmSchedule);
		}
		return li2;
	}
}
