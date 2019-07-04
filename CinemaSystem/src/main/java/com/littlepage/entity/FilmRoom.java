package com.littlepage.entity;

public class FilmRoom {
	private int id;
	private String name;
	private String seatInfo;
	public FilmRoom() {
		super();
	}
	public FilmRoom(int id, String seatInfo, String name) {
		super();
		this.id = id;
		this.seatInfo = seatInfo;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSeatInfo() {
		return seatInfo;
	}
	public void setSeatInfo(String seatInfo) {
		this.seatInfo = seatInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "FilmRoomController [id=" + id + ", seatInfo=" + seatInfo + ", name=" + name + "]";
	}
}
