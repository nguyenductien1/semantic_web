package web_semantique;

import java.util.ArrayList;

public class Jeu_FPS extends Jeu_d_aventure{
	// attributs 
	
	private static ArrayList<Jeu_FPS> listeJeuFPS = new ArrayList<Jeu_FPS>();
	
	// constructeur 
	
	public Jeu_FPS(String nom, int date, String typeDeJeu, String DeveloppePar) {
		super(nom, date,  typeDeJeu, DeveloppePar);
	}
	
	public static ArrayList<Jeu_FPS> getListJeuFPS(){
		return listeJeuFPS;
	}

}
