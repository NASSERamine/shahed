package Entities;

public class Commentaire {
	private int id ;
	private String commentaire;
	private int media_id ;
	private int saason_id ;
	private int episode_id ;
	
	
	
	public Commentaire(int id, String commentaire, int media_id, int saason_id, int episode_id) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.media_id = media_id;
		this.saason_id = saason_id;
		this.episode_id = episode_id;
	}
	
	



	public Commentaire() {
		super();
	}





	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}



	public int getMedia_id() {
		return media_id;
	}



	public void setMedia_id(int media_id) {
		this.media_id = media_id;
	}



	public int getSaason_id() {
		return saason_id;
	}



	public void setSaason_id(int saason_id) {
		this.saason_id = saason_id;
	}



	public int getEpisode_id() {
		return episode_id;
	}



	public void setEpisode_id(int episode_id) {
		this.episode_id = episode_id;
	}





	@Override
	public String toString() {
		return "Commentaire id= " + id + " commentaire= " + commentaire + " media_id= " + media_id + " saason_id= "
				+ saason_id + " episode_id= " + episode_id  ;
	}
	
	
	
	
	
	
	
	
	

}
