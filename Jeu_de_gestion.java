package web_semantique;

import java.util.ArrayList;

public class Jeu_de_gestion extends Jeu_de_simulation{
	//attributs 
	
	private static ArrayList<Jeu_de_gestion> listeJeuGestion = new ArrayList<Jeu_de_gestion>();
	
	// constructeur 
	
	public Jeu_de_gestion(String nom, int date, String typeDeJeu, String DeveloppePar) {
		super(nom, date,  typeDeJeu, DeveloppePar);
	}
	
	public static ArrayList<Jeu_de_gestion> getListJeuGestion(){
		return listeJeuGestion;
	}
}
