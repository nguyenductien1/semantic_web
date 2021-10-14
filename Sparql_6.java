package web_semantique;

import java.util.Iterator;
import org.apache.jena.atlas.io.IndentedWriter;
import org.apache.jena.query.Query;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.RDFVisitor;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

public class Sparql_6 {
	public static final String NL = System.getProperty("line.separator") ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model m = ModelFactory.createDefaultModel();
		  String file_jeux = "jeux.n3";
		
		  String jeux_ns1 = "http://www.type_jeux_videos.fr/jeux#";
		  String jeux_ns ="http://www.jeux.fr/jeux#";
		  String prolog = "PREFIX jeux: <"+jeux_ns1+">" ;
		  String prolog1 = "PREFIX jeux: <"+jeux_ns+">" ;
		  String prolog2 = "PREFIX rdf: <"+RDF.getURI()+">" ;
		  String prolog3 = "PREFIX rdfs: <"+RDFS.getURI()+">";
		 
		  System.out.println(prolog);
		  System.out.println(prolog2);
		  System.out.println(prolog3);
		  System.out.println(prolog1);
		 
		  m.read(file_jeux);
		  
		  // requête qui nous permet de renvoyer tout les jeux qui ont une date de sorti mentionné dans le graphe
		  String rdq = prolog + NL + prolog2 + NL  + prolog3 + NL + prolog1 + NL + 
				  	  
		  /*"SELECT ?s ?label ?object WHERE { ?s jeux:annee_de_sortie ?label }";
		  "SELECT DISTINCT ?annee ?jeux WHERE{?annee_de_sortie jeux:annee_de_sortie ?annee ."
		  + "?jeux rdf:type ?label} ";*/
		  
		  "SELECT ?annees (count(?annee) as ?nbr_jeux_sorti_cette_annee) WHERE {?annee jeux:annee_de_sortie ?annees .}"
		  + "group by ?annees having (count(?annee) >=1) ORDERBY ?annee";
		  
		  /*" SELECT ?class  (count(?type_de_jeux) as ?nbre_de_type_de_jeux) WHERE {  " 
		 +  " ?type_de_jeux rdf:type ?class .  }   "
		 + " group by ?class  having (count(?type_de_jeux) >=1)   " ;*/
		  
		  Query query = QueryFactory.create(rdq);
		  QueryExecution qexec = QueryExecutionFactory.create(query, m);
		  query.serialize(new IndentedWriter(System.out,true));
		  System.out.println("jeux trier par ordre croissant selon leur date de sortie ainsi que le nombre de jeux sortie cette année: ");
		  
		  try {
		       ResultSet rs = qexec.execSelect() ;
		       //formatage lors de l'éxécution de la requête
		       ResultSetFormatter.out(System.out, rs, query);		  
		  }
		  finally {qexec.close();}
		  /*try {
			  // céer une liste itérative avec visiteur nous permettant de parcourir notre class jeu de sport via notre requête 
			  // tout les élémémt de type rdf:type et les afficher les à à la suite des autres
			  Iterator<QuerySolution> results = qexec.execSelect();
			  RDFVisitor aVisitor = new Un_Visiteur();
			  System.out.println("tout les jeux-vidéos qui ont une date de sortie : ");
			  System.out.println();
			  for (;results.hasNext();)
			  {
				  QuerySolution solution = results.next();
				  RDFNode s = solution.get("s");
				  System.out.println(" - " + s.visitWith(aVisitor)+"    ");
			  }
		  }
		  finally {qexec.close();}*/

	}

}
