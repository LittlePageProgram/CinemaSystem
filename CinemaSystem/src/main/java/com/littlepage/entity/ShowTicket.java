package com.littlepage.entity;
/**
 * 票务展示类
 * @author 74302
 *
 */
public class ShowTicket {
    private Integer id;
    private String date;
    private String starttime;
    private String endtime;
    private String fid;
    private String filmroom;
    private String price;
	private int seatNum;
	private String name;
	public ShowTicket() {
		super();
	}
	public ShowTicket(Integer id, String date, String starttime, String endtime, String fid, String filmroom,
			String price, int seatNum, String name) {
		super();
		this.id = id;
		this.date = date;
		this.starttime = starttime;
		this.endtime = endtime;
		this.fid = fid;
		this.filmroom = filmroom;
		this.price = price;
		this.seatNum = seatNum;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFilmroom() {
		return filmroom;
	}
	public void setFilmroom(String filmroom) {
		this.filmroom = filmroom;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ShowTicket [id=" + id + ", date=" + date + ", starttime=" + starttime + ", endtime=" + endtime
				+ ", fid=" + fid + ", filmroom=" + filmroom + ", price=" + price + ", seatNum=" + seatNum + ", name="
				+ name + "]";
	}
}
