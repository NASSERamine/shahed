package Entities;

public class Film extends Media {
	
	private String dure;

	public Film(int id, String nom1, int annne_sortie, String langue, String pays_origine, String genre,
			int id_producer, String urlaffiche, String synopsis, String type, int nbr_vu, int nbr_votant, String dure) {
		super(id, nom1, annne_sortie, langue, pays_origine, genre, id_producer, urlaffiche, synopsis, type, nbr_vu,
				nbr_votant);
		this.dure = dure;
	}

	public String getDure() {
		return dure;
	}

	public void setDure(String dure) {
		this.dure = dure;
	}

	

	
	

	
	

	








}
