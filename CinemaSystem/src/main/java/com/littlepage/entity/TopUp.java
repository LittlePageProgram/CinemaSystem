package com.littlepage.entity;
/**
 * 充值信息实体类
 * @author 74302
 *
 */
public class TopUp {
	private int id;
	private String info;
	public TopUp() {
	}
	public TopUp(int id, String info) {
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
		return "TopUp [id=" + id + ", info=" + info + "]";
	}
}
