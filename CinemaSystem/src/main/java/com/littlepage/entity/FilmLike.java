package com.littlepage.entity;
/**
 * 用户-喜欢电影表
 * @author 74302
 *
 */
public class FilmLike {
	private int id;
	private int uid;
	private int fid;
	private String time;
	public FilmLike() {
	}
	public FilmLike(int id, int uid, int fid, String time) {
		super();
		this.id = id;
		this.uid = uid;
		this.fid = fid;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "FilmLike [id=" + id + ", uid=" + uid + ", fid=" + fid + ", time=" + time + "]";
	}
}
