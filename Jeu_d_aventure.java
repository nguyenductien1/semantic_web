package web_semantique;

import java.util.ArrayList;

public class Jeu_d_aventure extends Jeux_videos{
	// sans atributs 
	private static ArrayList<Jeu_d_aventure> listeJeudaventure = new ArrayList<Jeu_d_aventure>();
	 
	// constructeur 
	
	public Jeu_d_aventure(String nom, int date, String typeDeJeu, String DeveloppePar) {
		super(nom, date, typeDeJeu, DeveloppePar);
	}
	
	public static ArrayList<Jeu_d_aventure> getListJeuDaventure(){
		return listeJeudaventure;
	}
}
