package com.littlepage.entity;
/**
 * 会员卡实体类
 * @author 74302
 *
 */
public class ClubCard {
	private int id;
	private int uid;
	private double price;
	public ClubCard() {
	}
	public ClubCard(int id, int uid, double price) {
		super();
		this.id = id;
		this.uid = uid;
		this.price = price;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ClubCard [id=" + id + ", uid=" + uid + ", price=" + price + "]";
	}
}
