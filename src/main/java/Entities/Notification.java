package Entities;

public class Notification {
	
	private int id ;
	private int user_id;
	private int media_media ;
	private String  text;
	
	
	public Notification(int id, int user_id, int media_media, String text) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.media_media = media_media;
		this.text = text;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getMedia_media() {
		return media_media;
	}


	public void setMedia_media(int media_media) {
		this.media_media = media_media;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
	

}
