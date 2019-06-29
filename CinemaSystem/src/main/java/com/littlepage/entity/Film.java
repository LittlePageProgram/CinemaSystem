package com.littlepage.entity;

import java.util.Arrays;

/**
 * 电影类
 * @author 74302
 *
 */
public class Film {
	private int id;
	private String name;
	private byte[] posterLink;
	private String director;
	private String scriptWriter;
	private String actor;
	private String type;
	private String location;
	private String language;
	private String releaseDate;
	private String length;
	private String reflectDate;
	public Film() {
		super();
	}
	public Film(int id, String name, byte[] posterLink, String director, String scriptWriter, String actor, String type,
			String location, String language, String releaseDate, String length, String reflectDate) {
		super();
		this.id = id;
		this.name = name;
		this.posterLink = posterLink;
		this.director = director;
		this.scriptWriter = scriptWriter;
		this.actor = actor;
		this.type = type;
		this.location = location;
		this.language = language;
		this.releaseDate = releaseDate;
		this.length = length;
		this.reflectDate = reflectDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getPosterLink() {
		return posterLink;
	}
	public void setPosterLink(byte[] posterLink) {
		this.posterLink = posterLink;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getScriptWriter() {
		return scriptWriter;
	}
	public void setScriptWriter(String scriptWriter) {
		this.scriptWriter = scriptWriter;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getReflectDate() {
		return reflectDate;
	}
	public void setReflectDate(String reflectDate) {
		this.reflectDate = reflectDate;
	}
	@Override
	public String toString() {
		return "Film [id=" + id + ", name=" + name + ", posterLink=" + Arrays.toString(posterLink) + ", director="
				+ director + ", scriptWriter=" + scriptWriter + ", actor=" + actor + ", type=" + type + ", location="
				+ location + ", language=" + language + ", releaseDate=" + releaseDate + ", length=" + length
				+ ", reflectDate=" + reflectDate + "]";
	}
}
