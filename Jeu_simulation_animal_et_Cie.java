package web_semantique;

import java.util.ArrayList;

public class Jeu_simulation_animal_et_Cie extends Jeu_de_simulation{
	// attributs 
	
	private static ArrayList<Jeu_simulation_animal_et_Cie> listeJeuSimuAnimalEtCie = new ArrayList<Jeu_simulation_animal_et_Cie>();
	
	// constructeur 
	
	public Jeu_simulation_animal_et_Cie(String nom, int date, String typeDeJeu, String DeveloppePar) {
		super(nom, date,  typeDeJeu, DeveloppePar);
	}
	
	public static ArrayList<Jeu_simulation_animal_et_Cie> getListJeuSimuAnimalEtCie(){
		return listeJeuSimuAnimalEtCie;
	}
}
