package com.littlepage.entity;
/**
 * 购买信息
 * @author 74302
 *
 */
public class Customerlog {
	private int id;
	private String info;
	public Customerlog() {
	}
	public Customerlog(int id, String info) {
		super();
		this.id = id;
		this.info = info;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Customerlog [id=" + id + ", info=" + info + "]";
	}
}
