package Entities;

public class Serie extends Media {
	
	
	private int nbre_de_saison ;

	public Serie(int id, String nom1, int annne_sortie, String langue, String pays_origine, String genre,
			int id_producer, String urlaffiche, String synopsis, String type, int nbr_vu, int nbr_votant,
			int nbre_de_saison) {
		super(id, nom1, annne_sortie, langue, pays_origine, genre, id_producer, urlaffiche, synopsis, type, nbr_vu,
				nbr_votant);
		this.nbre_de_saison = nbre_de_saison;
	}

	public Serie(int idMedia, String name, int year, String language, String country, int producerId, String imageUrl,
			String synopsis, String genre, int nbrVues, int nbrVotants, int nbSeasons) {
		// TODO Auto-generated constructor stub
	}

	public int getNbre_de_saison() {
		return nbre_de_saison;
	}

	public void setNbre_de_saison(int nbre_de_saison) {
		this.nbre_de_saison = nbre_de_saison;
	}

	@Override
	public String toString() {
	    return nom1 + " (" + annne_sortie + ")";
	}

	public int getYear() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
	
	
	

}
