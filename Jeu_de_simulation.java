package web_semantique;

import java.util.ArrayList;

public class Jeu_de_simulation extends Jeux_videos{
	// sans attributs 
	
	private static ArrayList<Jeu_de_simulation> listeJeuDeSimulation = new ArrayList<Jeu_de_simulation>();
	
	// constructeur 
	
	public Jeu_de_simulation(String nom, int date, String typeDeJeu, String DeveloppePar) {
		super(nom, date, typeDeJeu, DeveloppePar);
	}
	
	public static ArrayList<Jeu_de_simulation> getListJeuDeSimulation(){
		return listeJeuDeSimulation;
	}
}
