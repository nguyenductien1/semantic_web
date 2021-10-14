package web_semantique;

import java.util.ArrayList;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;

public class Jeu_de_sport extends Jeux_videos {
	
	// attributs : aucun, classe qui hérite de la classe jeux videos 
	// elle étend par conséquent toute ses méthodes
	
	private static ArrayList<Jeu_de_sport> listeJeudeSport = new ArrayList<Jeu_de_sport>();
	
	// constructeur 
	
	public Jeu_de_sport() {}

	public Jeu_de_sport(String nom, int date, String typeDeJeu, String DeveloppePar) {
		// hérite du constructeur de la classe Jeux_videos
		super(nom, date,  typeDeJeu, DeveloppePar);
		ajoutJeu(this);
			
	}
	
	// methode qui nous permettra de retorner la liste de tout nos jeux de sport
	
	public static ArrayList<Jeu_de_sport> getListJeuDeSport(){
		return listeJeudeSport;
	}
	
	// méthode qui permet d'ajouter un jeu de sport qui n'est pas dans la liste
	public static void ajoutJeu(Jeu_de_sport jeu){
		for(int i=0; i < listeJeudeSport.size(); i++) {
			if(listeJeudeSport.get(i).equals(jeu)) {
				System.out.println("le jeu est déjà présent dans la liste");
			}else {
				listeJeudeSport.add(jeu);
			}
		}
		 
	}

}
