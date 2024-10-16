package Entities;

public class Raiting {
	private int id ;
	private int score ;
	private int user_id;
	private int media_id;
	private int episode_id;
	public Raiting(int id, int score, int user_id, int media_id, int episode_id) {
		super();
		this.id = id;
		this.score = score;
		this.user_id = user_id;
		this.media_id = media_id;
		this.episode_id = episode_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMedia_id() {
		return media_id;
	}
	public void setMedia_id(int media_id) {
		this.media_id = media_id;
	}
	public int getEpisode_id() {
		return episode_id;
	}
	public void setEpisode_id(int episode_id) {
		this.episode_id = episode_id;
	}
  @Override
	public String toString() {
		return "Raiting id=  " + id + "  score=" + score + " user_id= " + user_id + " media_id= " + media_id
				+ "  episode_id= " + episode_id ;
	}
		
	
	
	

}
