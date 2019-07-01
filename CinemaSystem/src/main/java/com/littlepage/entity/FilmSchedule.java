package com.littlepage.entity;

import java.io.Serializable;

/**
 * filmSchedule实体类
 * @author 
 */
public class FilmSchedule implements Serializable{
    private Integer id;
    private String date;
    private String starttime;
    private String endtime;
    private String fid;
    private String filmroom;
    private String price;
    private String visiabletimestart;
    private String visiabletimeend;
    private String view;
    private static final long serialVersionUID = 1L;

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

    public String getVisiabletimestart() {
        return visiabletimestart;
    }

    public void setVisiabletimestart(String visiabletimestart) {
        this.visiabletimestart = visiabletimestart;
    }

    public String getVisiabletimeend() {
        return visiabletimeend;
    }

    public void setVisiabletimeend(String visiabletimeend) {
        this.visiabletimeend = visiabletimeend;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

	@Override
	public String toString() {
		return "FilmSchedule [id=" + id + ", date=" + date + ", starttime=" + starttime + ", endtime=" + endtime
				+ ", fid=" + fid + ", filmroom=" + filmroom + ", price=" + price + ", visiabletimestart="
				+ visiabletimestart + ", visiabletimeend=" + visiabletimeend + ", view=" + view + "]";
	}

	
	

}