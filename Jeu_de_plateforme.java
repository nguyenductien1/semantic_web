package web_semantique;

import java.util.ArrayList;

public class Jeu_de_plateforme extends Jeu_d_aventure{
	// sans attributs 
	
	private static ArrayList<Jeu_de_plateforme> listeJeuPlateforme = new ArrayList<Jeu_de_plateforme>();
	
	// constructeur 
	
	public Jeu_de_plateforme(String nom, int date, String typeDeJeu, String DeveloppePar) {
		super(nom, date,  typeDeJeu, DeveloppePar);
	}
	
	public static ArrayList<Jeu_de_plateforme> getListJeuPlateforme(){
		return listeJeuPlateforme;
	}
}
