package Entities;

public class Season {
	private int id;
	private int num ;
	private int start_year;
	private int media_id;
	private String synopsis ;
	int nbr_episode;
	
	public Season(int id, int num, int start_year, int media_id, String synopsis, int nbr_episode) {
		super();
		this.id = id;
		this.num = num;
		this.start_year = start_year;
		this.media_id = media_id;
		this.synopsis = synopsis;
		this.nbr_episode = nbr_episode;
	}

	
	

	public Season(int num, int start_year, String synopsis, int nbr_episode) {
		this.num = num;
		this.start_year = start_year;
		
		this.synopsis = synopsis;
		this.nbr_episode = nbr_episode;
	}








	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStart_year() {
		return start_year;
	}

	public void setStart_year(int start_year) {
		this.start_year = start_year;
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

	public int getNbr_episode() {
		return nbr_episode;
	}

	public void setNbr_episode(int nbr_episode) {
		this.nbr_episode = nbr_episode;
	}
	
	
	
	

	
}
