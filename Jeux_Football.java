package web_semantique;

import java.util.ArrayList;

public class Jeux_Football extends Jeu_de_sport  {
	
	// attributs
	
	private static ArrayList<Jeux_Football> listeJeuFootball = new ArrayList<Jeux_Football>();
	
	// constructeur sans paramètre
	
	public Jeux_Football(String nom, int date, String typeDeJeu, String DeveloppePar) {
		super(nom, date,  typeDeJeu, DeveloppePar);
		ajoutJeuFootball(this);
	}
	
	public static ArrayList<Jeux_Football> getListJeuFootball(){
		return listeJeuFootball;
	}
	
	// méthode qui permet d'ajouter des éléments dans une liste
	public static void ajoutJeuFootball(Jeux_Football jeu) {
		for(int i=0; i <getListJeuFootball().size(); i++) {
			if(getListJeuFootball().get(i).equals(jeu)) {
				System.out.println("le jeu est déjà présent dans la liste");
			}else {
				getListJeuFootball().add(jeu);
			}
			
		}
	}
	
	

}
