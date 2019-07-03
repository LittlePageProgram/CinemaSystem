package com.littlepage.entity;

public class Ticketseat {
	private int id;
	private int filmScheduleId;
	private int seatNum;
	public Ticketseat() {
	}
	public Ticketseat(int id, int filmScheduleId, int seatNum) {
		super();
		this.id = id;
		this.filmScheduleId = filmScheduleId;
		this.seatNum = seatNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFilmScheduleId() {
		return filmScheduleId;
	}
	public void setFilmScheduleId(int filmScheduleId) {
		this.filmScheduleId = filmScheduleId;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	@Override
	public String toString() {
		return "Ticketseat [id=" + id + ", filmScheduleId=" + filmScheduleId + ", seatNum=" + seatNum + "]";
	}
}
