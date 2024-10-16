package Entities; 



public class Media {
	protected int id ;
	protected String nom1;
	protected int annne_sortie;
	protected String langue;
	protected String pays_origine;
	protected String genre;
	protected int id_producer ;
	protected String urlaffiche ;
	protected String synopsis;
	protected String type ;
	protected int nbr_vu ;
	protected int nbr_votant ;
	public Media(int id, String nom1, int annne_sortie, String langue, String pays_origine, String genre,
			int id_producer, String urlaffiche, String synopsis, String type, int nbr_vu, int nbr_votant) {
		super();
		this.id = id;
		this.nom1 = nom1;
		this.annne_sortie = annne_sortie;
		this.langue = langue;
		this.pays_origine = pays_origine;
		this.genre = genre;
		this.id_producer = id_producer;
		this.urlaffiche = urlaffiche;
		this.synopsis = synopsis;
		this.type = type;
		this.nbr_vu = nbr_vu;
		this.nbr_votant = nbr_votant;
	}
	public Media(String urlaffiche2) {
		// TODO Auto-generated constructor stub
	}
	
	
	public Media() {
		super();
	}
	public Media(int int1, String string, int int2, String string2, String string3, int int3, String string4,
			String string5, String string6, int int4, String string7, String string8, int int5, int int6) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom1() {
		return nom1;
	}
	public void setNom1(String nom1) {
		this.nom1 = nom1;
	}
	public int getAnnne_sortie() {
		return annne_sortie;
	}
	public void setAnnne_sortie(int annne_sortie) {
		this.annne_sortie = annne_sortie;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getPays_origine() {
		return pays_origine;
	}
	public void setPays_origine(String pays_origine) {
		this.pays_origine = pays_origine;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getId_producer() {
		return id_producer;
	}
	public void setId_producer(int id_producer) {
		this.id_producer = id_producer;
	}
	public String getUrlaffiche() {
		return urlaffiche;
	}
	public void setUrlaffiche(String urlaffiche) {
		this.urlaffiche = urlaffiche;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNbr_vu() {
		return nbr_vu;
	}
	public void setNbr_vu(int nbr_vu) {
		this.nbr_vu = nbr_vu;
	}
	public int getNbr_votant() {
		return nbr_votant;
	}
	public void setNbr_votant(int nbr_votant) {
		this.nbr_votant = nbr_votant;
	}
	
	
	
	
	
	
	
	




	
	
}

	
	
	
	
	
	



