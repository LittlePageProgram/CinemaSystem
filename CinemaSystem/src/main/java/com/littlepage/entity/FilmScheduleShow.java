package com.littlepage.entity;

public class FilmScheduleShow {
	private String filmroom;
	private String name;
	private String starttime;
	private String endtime;
	private String price;
	public FilmScheduleShow() {
		super();
	}
	public FilmScheduleShow(String filmroom, String name, String starttime, String endtime, String price) {
		super();
		this.filmroom = filmroom;
		this.name = name;
		this.starttime = starttime;
		this.endtime = endtime;
		this.price = price;
	}
	public String getFilmroom() {
		return filmroom;
	}
	public void setFilmroom(String filmroom) {
		this.filmroom = filmroom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "FilmScheduleShow [filmroom=" + filmroom + ", name=" + name + ", starttime=" + starttime + ", endtime="
				+ endtime + ", price=" + price + "]";
	}
}
