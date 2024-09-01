package org.hello.spring.model;

public class Song {

	private Integer id;
	private String title;
	private String artists;
	private String year;
	
	public Song(Integer id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getArtists() {
		return this.artists;
	}
	
	public String getYear() {
		return this.year;
	}
	
	@Override
	public String toString() {
		return String.format("%d, %s, %s, %s", this.id, this.title, this.artists, this.year);
	}
	
}
