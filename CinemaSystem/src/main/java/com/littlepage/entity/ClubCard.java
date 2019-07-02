package com.littlepage.entity;
/**
 * 会员卡实体类
 * @author 74302
 *
 */
public class ClubCard {
	private int id;
	private int uid;
	private String prices;
	public ClubCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClubCard(int id, int uid, String prices) {
		super();
		this.id = id;
		this.uid = uid;
		this.prices = prices;
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
	public String getPrices() {
		return prices;
	}
	public void setPrices(String prices) {
		this.prices = prices;
	}
	@Override
	public String toString() {
		return "ClubCard [id=" + id + ", uid=" + uid + ", prices=" + prices + "]";
	}
}
