package com.littlepage.entity;
/**
 * 打折实体类
 * @author 74302
 *
 */
public class Discount {
	private int id;
	private int discount;
	private String startTime;
	private String endTime;
	private int condi;
	public Discount() {
		super();
	}
	public Discount(int id, int discount, String startTime, String endTime, int condi) {
		super();
		this.id = id;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
		this.condi = condi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getCondi() {
		return condi;
	}
	public void setCondi(int condi) {
		this.condi = condi;
	}
	@Override
	public String toString() {
		return "Discount [id=" + id + ", discount=" + discount + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", condi=" + condi + "]";
	}
}
