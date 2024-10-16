package Entities;

import java.util.Date;

public class Episode {
	private int id ;
	private int season_id ;
	private String title;
	private Date aire_date ;
	private int media_id;
	private String synopsis;
	private int numero ;
	
	public Episode(int id, int season_id, String title, Date aire_date, int media_id, String synopsis, int numero) {
		super();
		this.id = id;
		this.season_id = season_id;
		this.title = title;
		this.aire_date = aire_date;
		this.media_id = media_id;
		this.synopsis = synopsis;
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeason_id() {
		return season_id;
	}

	public void setSeason_id(int season_id) {
		this.season_id = season_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getAire_date() {
		return aire_date;
	}

	public void setAire_date(Date aire_date) {
		this.aire_date = aire_date;
	}

	public int getMedia_id() {
		return media_id;
	}

	public void setMedia_id(int media_id) {
		this.media_id = media_id;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Episode [id=" + id + ", season_id=" + season_id + ", title=" + title + ", aire_date=" + aire_date
				+ ", media_id=" + media_id + ", synopsis=" + synopsis + ", numero=" + numero + "]";
	}
	
	
	
	
	
	
	

}
