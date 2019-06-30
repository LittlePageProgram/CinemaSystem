package com.littlepage.entity;
/**
 * 电影喜好统计表
 * @author 74302
 *
 */
public class FilmLikeCount {
	String filmName;
	int count;
	public FilmLikeCount() {
		super();
	}
	public FilmLikeCount(String filmName, int count) {
		super();
		this.filmName = filmName;
		this.count = count;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "FilmLikeCount [filmName=" + filmName + ", count=" + count + "]";
	}
}
