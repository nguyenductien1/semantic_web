package web_semantique;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainModele {
	
	public static void main(String[]args) {
		try {
			
			// jeux de sports : 
			// jeux de type Football
			Jeux_Football Fifa21 = new Jeux_Football("FiFa21", 2020, "Jeu_de_Football", "EA_Sport" );
			Jeux_Football Fifa20 = new Jeux_Football("FiFa20", 2019, "Jeu_de_Football", "EA_Sport" );
			
			// jeux de Basketball
			Jeux_Basketball NBA2k21 = new Jeux_Basketball("NBA2k21", 2020, "jeu_de_Basketball", "2K_Sports");
			Jeux_Basketball NBA2k20 = new Jeux_Basketball("NBA2k20", 2019, "jeu_de_Basketball", "2K_Sports");
			
			// jeux d'avnentures:
			// jeu FPS
			Jeu_FPS Call_Of_Duty_Cold_War = new Jeu_FPS("Call_Of_Duty_Cold_War", 2020, "Jeu_FPS", "Treyarch");
			
			// jeu de plateforme
			Jeu_de_plateforme Super_Mario_Run = new Jeu_de_plateforme("Super_Mario_Run", 2017, "Jeu_de_plateforme", "Nitendo_Entertainment");
			
			// jeux de simulation
			// jeu de gestion
			Jeu_de_gestion Football_Manager_2021 = new Jeu_de_gestion("Football_Manager_2021", 2020, "Jeu_de_gestion", "Interactive_Sport");
			
			// jeu de simulation animaux de compagnies
			
			Jeu_simulation_animal_et_Cie Sims_Animaux_et_Cie = new Jeu_simulation_animal_et_Cie("Sims_Animaux_et_Cie", 2011,
					"Jeu_de_simulation_animal_et_Cie", "Maxis");
			
			// on créer le modèle
			Modele modele1 = new Modele("FirstModele", "http://www.jeux.fr/jeux#", "http://www.type_jeux_videos.fr/jeux#",
					Jeu_d_aventure.getListJeuDaventure(), Jeu_de_sport.getListJeuDeSport(), Jeu_de_simulation.getListJeuDeSimulation(),
					Jeu_de_gestion.getListJeuGestion(), Jeu_de_plateforme.getListJeuPlateforme(), Jeu_FPS.getListJeuFPS(),
					Jeu_simulation_animal_et_Cie.getListJeuSimuAnimalEtCie(),Jeux_Football.getListJeuFootball(),
					Jeux_Basketball.getListJeuBasketball());
			
			// on crée le fichier en N3
			
			modele1.getModele().write(System.out, "N3");
			
			try {
				FileOutputStream fs = new FileOutputStream("JeuxAvecClasses.n3");
				modele1.getModele().write(fs, "N3");
				fs.close();
			}catch(FileNotFoundException e) {
				System.out.println("File not found");
			}catch(IOException e) {
				System.out.println("IO exception");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
