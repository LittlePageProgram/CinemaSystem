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
	public FilmLike() {
	}
	public FilmLike(int id, int uid, int fid) {
		super();
		this.id = id;
		this.uid = uid;
		this.fid = fid;
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
	@Override
	public String toString() {
		return "Filmlike [id=" + id + ", uid=" + uid + ", fid=" + fid + "]";
	}
}
