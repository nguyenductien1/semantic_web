package web_semantique;

import java.util.ArrayList;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.XSD;

public class Modele {
	
	// attribut 
	// on créer le model
	Model m = ModelFactory.createDefaultModel();
	private String jeux_ns = "http://www.jeux.fr/jeux#";
	private String type_jeux_videos_ns = "http://www.type_jeux_videos.fr/jeux#";
	private static ArrayList<Jeu_d_aventure> listejeuxaventure;
	private static ArrayList<Jeu_de_sport> listejeuxsport;
	private static ArrayList<Jeu_de_gestion> listejeuxgestion;
	private static ArrayList<Jeu_de_plateforme> listejeuxplateforme;
	private static ArrayList<Jeu_de_simulation> listejeuxsimulation;
	private static ArrayList<Jeu_FPS> listejeuxFPS;
	private static ArrayList<Jeu_simulation_animal_et_Cie> listejeuxsimulationAnimalEtCie;
	private static ArrayList<Jeux_Football> listejeuxfootball;
	private static ArrayList<Jeux_Basketball> listejeuxbasketball;
	
	
	
	// constructeur 
	public Modele(String m, String jeux_ns, String type_jeux_videos_ns, ArrayList<Jeu_d_aventure> listejeuxaventure, 
			ArrayList<Jeu_de_sport> listejeuxsport, ArrayList<Jeu_de_simulation> listejeuxsimulation, ArrayList<Jeu_de_gestion> listejeuxgestion,
			ArrayList<Jeu_de_plateforme> listejeuxplateforme, ArrayList<Jeu_FPS> listejeuxFPS, 
			ArrayList<Jeu_simulation_animal_et_Cie> listejeuxsimulationAnimalEtCie, ArrayList<Jeux_Football> listejeuxfootball,
			ArrayList<Jeux_Basketball> listejeuxbasketball){
		this.m = ModelFactory.createDefaultModel();
		this.jeux_ns = jeux_ns;
		this.type_jeux_videos_ns = type_jeux_videos_ns;
		this.listejeuxaventure = listejeuxaventure;
		this.listejeuxsport = listejeuxsport;
		this.listejeuxfootball = listejeuxfootball;
		this.listejeuxbasketball = listejeuxbasketball;
		this.listejeuxFPS = listejeuxFPS;
		this.listejeuxgestion = listejeuxgestion;
		this.listejeuxsimulationAnimalEtCie = listejeuxsimulationAnimalEtCie;
		this.listejeuxplateforme = listejeuxplateforme;
		this.listejeuxsimulation = listejeuxsimulation;
		ajoutPrefix();
		ajouterJeuxDeSport(listejeuxsport);
		ajouterJeuxDaventure(listejeuxaventure);
		ajouterJeuxGestion(listejeuxgestion);
		ajouterJeuxPlateforme(listejeuxplateforme);
		ajouterJeuxSimulation(listejeuxsimulation);
		ajouterJeuxFPS(listejeuxFPS);
		ajouterJeuxAnimalEtCie(listejeuxsimulationAnimalEtCie);
		ajouterJeuxDeFootball(listejeuxfootball);
		ajouterJeuxDeBasketball(listejeuxbasketball);
		
		
	}
	// getteurs et setteurs
	public Model getModele() {
		return m;
	}
	public void setModele(Model m) {
		this.m = m;
	}
	public String getJeux_ns() {
		return jeux_ns;
	}
	public void setJeux_ns(String jeux_ns) {
		this.jeux_ns = jeux_ns;
	}
	public String getType_de_jeux_ns() {
		return type_jeux_videos_ns;
	}
	public void setType_de_jeux_ns(String typeJeux) {
		this.type_jeux_videos_ns = typeJeux;
	}
	public static ArrayList<Jeu_d_aventure> getListeJeuxAventure(){
		return listejeuxaventure;
	}
	public static void setListeJeuxaventure(ArrayList<Jeu_d_aventure> listeA){
		Modele.listejeuxaventure = listeA;
	}
	public static ArrayList<Jeu_de_sport> getListeJeuxSport(){
		return listejeuxsport;
	}
	public static void setListeJeuxSport(ArrayList<Jeu_de_sport> listeS) {
		Modele.listejeuxsport = listeS;
	}
	public ArrayList<Jeu_de_simulation> getListeJeuxDeSimulation(){
		return listejeuxsimulation;
	}
	public static void setListeJeuxDeSimulation(ArrayList<Jeu_de_simulation> listeSimu) {
		Modele.listejeuxsimulation = listeSimu;
	}
	public ArrayList<Jeu_de_plateforme> getListeJeuxDePlateforme(){
		return listejeuxplateforme;
	}
	public static void setListeJeuxDePlateforme(ArrayList<Jeu_de_plateforme> listeP) {
		Modele.listejeuxplateforme = listeP;
	}
	public ArrayList<Jeu_de_gestion> getListeJeuxDeGestion(){
		return listejeuxgestion;
	}
	public static void setListeJeuxDeGestion(ArrayList<Jeu_de_gestion> listeG) {
		Modele.listejeuxgestion = listeG;
	}
	public ArrayList<Jeu_FPS> getListeJeuxFPS(){
		return listejeuxFPS;
	}
	public static void setListeJeuxFPS(ArrayList<Jeu_FPS> listeFPS) {
		Modele.listejeuxFPS = listeFPS;
	}
	public ArrayList<Jeu_simulation_animal_et_Cie> getListeJeuxSimuAnimalEtCie(){
		return listejeuxsimulationAnimalEtCie;
	}
	public static void setListeJeuxSimuAnimalEtCie(ArrayList<Jeu_simulation_animal_et_Cie> listeACie) {
		Modele.listejeuxsimulationAnimalEtCie = listeACie;
	}
	public ArrayList<Jeux_Football> getListeJeuxFootball(){
		return listejeuxfootball;
	}
	public static void setListeJeuxFootball(ArrayList<Jeux_Football> listeF) {
		Modele.listejeuxfootball = listeF;
	}
	public ArrayList<Jeux_Basketball> getListeJeuxBasketball(){
		return listejeuxbasketball;
	}
	public static void setListeJeuxBasketball(ArrayList<Jeux_Basketball> listeB) {
		Modele.listejeuxbasketball = listeB;
	}
	
	
	
	// méthode qui permet d'ajouter des jeux de sports au modèle
	
	public void ajouterJeuxDeSport(ArrayList<Jeu_de_sport> listeJS) {
		Resource Jeux_videos = m.createResource(jeux_ns + "Jeux_de_sport");		
		m.add(Jeux_videos, RDFS.subClassOf,RDFS.Class);	
		
		listeJS.addAll(getListeJeuxBasketball());
		listeJS.addAll(getListeJeuxFootball());
	}
	
	//méthode qui permet d'ajouter des de football
	
	public void ajouterJeuxDeFootball(ArrayList<Jeux_Football> listeF) {
		Resource Jeux_de_sport = m.createResource(jeux_ns + "Jeux_Football");		
		m.add(Jeux_de_sport, RDFS.subClassOf,RDFS.Class);	
		
		// ajout des propriétés dont seront doté chaque resource
		Property developpe_par = m.createProperty(jeux_ns + "Developpe_par");
		Property annee_de_sortie = m.createProperty(jeux_ns + "annee_de_sortie");
		
		// on parcours l'ensemble des jeux de sport
		for(int i=0; i<listeF.size(); i++) {
			Resource jeux_football = m.createResource(type_jeux_videos_ns + listeF.get(i).getTypeDeJeu());
			jeux_football.addProperty(RDF.type, jeux_football);
			jeux_football.addProperty(RDFS.subClassOf, Jeux_de_sport);	
			
			jeux_football.addProperty(RDFS.label, listeF.get(i).getNomDuJeux());
			jeux_football.addProperty(developpe_par, m.createTypedLiteral(listeF.get(i).getDeveloppePar(),"en"));
			jeux_football.addProperty(annee_de_sortie, m.createTypedLiteral(listeF.get(i).getDateDeSortie(),"int"));
			
			
		}
	}
	
	// méthode qui permet d'ajouter des jeux de basketball
	
	public void ajouterJeuxDeBasketball(ArrayList<Jeux_Basketball> listeB) {
		Resource Jeux_de_sport = m.createResource(jeux_ns + "Jeux_Basketball");		
		m.add(Jeux_de_sport, RDFS.subClassOf,RDFS.Class);	
		
		// ajout des propriétés dont seront doté chaque resource
		Property developpe_par = m.createProperty(jeux_ns + "Developpe_par");
		Property annee_de_sortie = m.createProperty(jeux_ns + "annee_de_sortie");
		
		// on parcours l'ensemble des jeux de sport
		for(int i=0; i<listeB.size(); i++) {
			Resource jeux_basketball = m.createResource(type_jeux_videos_ns + listeB.get(i).getTypeDeJeu());
			jeux_basketball.addProperty(RDF.type, jeux_basketball);
			jeux_basketball.addProperty(RDFS.subClassOf, Jeux_de_sport);	
			
			jeux_basketball.addProperty(RDFS.label, listeB.get(i).getNomDuJeux());
			jeux_basketball.addProperty(developpe_par, m.createTypedLiteral(listeB.get(i).getDeveloppePar(),"en"));
			jeux_basketball.addProperty(annee_de_sortie, m.createTypedLiteral(listeB.get(i).getDateDeSortie(),"int"));
			
			
		}
	}
	
	
	// mathode qui permet d'ajouter des jeux d'aventure
	
	public void ajouterJeuxDaventure(ArrayList<Jeu_d_aventure> listeJA) {
		Resource Jeux_videos = m.createResource(jeux_ns + "Jeux_d_aventure");		
		m.add(Jeux_videos, RDFS.subClassOf,RDFS.Class);	
		
		// ajout des liste de jeux FPS et de plateforme
		listeJA.addAll(getListeJeuxFPS());
		listeJA.addAll(getListeJeuxDePlateforme());
		
		
	}
	
	// méthode qui permet d'ajouter des jeux de gestion 
	
	public void ajouterJeuxGestion(ArrayList<Jeu_de_gestion> listeJG) {
		
		Resource Jeux_Simulation = m.createResource(jeux_ns + "Jeux_de_Gestion");		
		m.add(Jeux_Simulation, RDFS.subClassOf,RDFS.Class);	
		
		// ajout des propriétés dont seront doté chaque resource
		Property developpe_par = m.createProperty(jeux_ns + "Developpe_par");
		Property annee_de_sortie = m.createProperty(jeux_ns + "annee_de_sortie");
		
		// on parcours l'ensemble des jeux de sport
		for(int i=0; i<listeJG.size(); i++) {
			Resource jeu_de_gestion = m.createResource(type_jeux_videos_ns + listeJG.get(i).getTypeDeJeu());
			jeu_de_gestion.addProperty(RDF.type, jeu_de_gestion);
			jeu_de_gestion.addProperty(RDFS.subClassOf, Jeux_Simulation);	
				
			jeu_de_gestion.addProperty(RDFS.label, listeJG.get(i).getNomDuJeux());
			jeu_de_gestion.addProperty(developpe_par, m.createTypedLiteral(listeJG.get(i).getDeveloppePar(), "en"));
			jeu_de_gestion.addProperty(annee_de_sortie, m.createTypedLiteral(listeJG.get(i).getDateDeSortie(),"int"));
			
			
		}
		
	}
	
	// méthode qui permet d'ajouter des jeux de plateforme
	
	public void ajouterJeuxPlateforme(ArrayList<Jeu_de_plateforme> listeJP) {
		Resource Jeux_simulation = m.createResource(jeux_ns + "Jeux_de_plateforme");		
		m.add(Jeux_simulation, RDFS.subClassOf,RDFS.Class);	
		
		// ajout des propriétés dont seront doté chaque resource
		Property developpe_par = m.createProperty(jeux_ns + "Developpe_par");
		Property annee_de_sortie = m.createProperty(jeux_ns + "annee_de_sortie");
		
		// on parcours l'ensemble des jeux de sport
		for(int i=0; i<listeJP.size(); i++) {
			Resource jeu_de_plateforme = m.createResource(type_jeux_videos_ns + listeJP.get(i).getTypeDeJeu());
			jeu_de_plateforme.addProperty(RDF.type, jeu_de_plateforme);
			jeu_de_plateforme.addProperty(RDFS.subClassOf, Jeux_simulation);	
		
			jeu_de_plateforme.addProperty(RDFS.label, listeJP.get(i).getNomDuJeux());
			jeu_de_plateforme.addProperty(developpe_par, m.createTypedLiteral(listeJP.get(i).getDeveloppePar(),"en"));
			jeu_de_plateforme.addProperty(annee_de_sortie, m.createTypedLiteral(listeJP.get(i).getDateDeSortie(),"int"));
			
			
		}
	}
	
	// méthode qui permet d'ajouter des jeux de simulation 
	
	public void ajouterJeuxSimulation(ArrayList<Jeu_de_simulation> listeJS) {
		
		Resource Jeux_videos = m.createResource(jeux_ns + "Jeux_de_simulation");		
		m.add(Jeux_videos, RDFS.subClassOf,RDFS.Class);	
		
		// ajout des jeux de simulation d'animaux de compagnie et de gestion
		listeJS.addAll(getListeJeuxSimuAnimalEtCie());
		listeJS.addAll(getListeJeuxDeGestion());
		
		
	}
	
	// mathode qui permet d'ajouter des jeux FPS
	
	public void ajouterJeuxFPS(ArrayList<Jeu_FPS> listeFPS) {
		
		Resource Jeux_d_aventure = m.createResource(jeux_ns + "Jeux_FPS");		
		m.add(Jeux_d_aventure, RDFS.subClassOf,RDFS.Class);	
		
		// ajout des propriétés dont seront doté chaque resource
		Property developpe_par = m.createProperty(jeux_ns + "Developpe_par");
		Property annee_de_sortie = m.createProperty(jeux_ns + "annee_de_sortie");
		
		// on parcours l'ensemble des jeux de sport
		for(int i=0; i<listeFPS.size(); i++) {
			Resource Jeux_FPS = m.createResource(type_jeux_videos_ns + listeFPS.get(i).getTypeDeJeu());
			Jeux_FPS.addProperty(RDF.type, Jeux_FPS);
			Jeux_FPS.addProperty(RDFS.subClassOf, Jeux_d_aventure);	
			
			Jeux_FPS.addProperty(RDFS.label, listeFPS.get(i).getNomDuJeux());
			Jeux_FPS.addProperty(developpe_par, m.createTypedLiteral(listeFPS.get(i).getDeveloppePar(), "en"));
			Jeux_FPS.addProperty(annee_de_sortie, m.createTypedLiteral(listeFPS.get(i).getDateDeSortie(), "int"));
			
			
		}
		
	}
	
	// méthode qui permet d'ajouter des jeux de simulation d'animal de compagnie
	
	public void ajouterJeuxAnimalEtCie(ArrayList<Jeu_simulation_animal_et_Cie> listeAC) {
		
		Resource Jeux_Simu = m.createResource(jeux_ns + "Jeux_simulation_animal_et_Cie");		
		m.add(Jeux_Simu, RDFS.subClassOf,RDFS.Class);	
		
		// ajout des propriétés dont seront doté chaque resource
		Property developpe_par = m.createProperty(jeux_ns + "Developpe_par");
		Property annee_de_sortie = m.createProperty(jeux_ns + "annee_de_sortie");
		
		// on parcours l'ensemble des jeux de sport
		for(int i=0; i<listeAC.size(); i++) {
			Resource jeux_animal_et_Cie = m.createResource(type_jeux_videos_ns + listeAC.get(i).getTypeDeJeu());
			jeux_animal_et_Cie.addProperty(RDF.type, jeux_animal_et_Cie);
			jeux_animal_et_Cie.addProperty(RDFS.subClassOf, Jeux_Simu);	
		
			jeux_animal_et_Cie.addProperty(RDFS.label, listeAC.get(i).getNomDuJeux());
			jeux_animal_et_Cie.addProperty(developpe_par, m.createTypedLiteral(listeAC.get(i).getDeveloppePar(),"en"));
			jeux_animal_et_Cie.addProperty(annee_de_sortie, m.createTypedLiteral(listeAC.get(i).getDateDeSortie(),"int"));
			
			
		}
		
	}
	
	
	// méthode qui permet d'ajouter tout les prefix des espaces de noms
	public void ajoutPrefix() {
		m.setNsPrefix("jeux", jeux_ns);	
		m.setNsPrefix("type_jeux_videos", type_jeux_videos_ns);
		m.setNsPrefix("rdf", RDF.getURI());		
		m.setNsPrefix("rdfs", RDFS.getURI());	
		m.setNsPrefix("xsd", XSD.getURI());
		
	}

}
