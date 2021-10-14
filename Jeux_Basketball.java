package web_semantique;

import java.util.ArrayList;

public class Jeux_Basketball extends Jeu_de_sport{
	// sans attributs
	private static ArrayList<Jeux_Basketball> listeJeuBasketball = new ArrayList<Jeux_Basketball>();
	
	// constructeur 
	
	public Jeux_Basketball(String nom, int date, String typeDeJeu, String DeveloppePar) {
		super(nom, date,  typeDeJeu, DeveloppePar);
		ajoutJeu(this);
	}
	
	public static ArrayList<Jeux_Basketball> getListJeuBasketball(){
		return listeJeuBasketball;
	}
	
	public static void ajoutJeu(Jeux_Basketball jeu){
		for(int i=0; i < listeJeuBasketball.size(); i++) {
			if(listeJeuBasketball.get(i).equals(jeu)) {
				System.out.println("le jeu est déjà présent dans la liste");
			}else {
				listeJeuBasketball.add(jeu);
			}
		}
		 
	}
}
