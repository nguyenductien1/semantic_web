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

public class Sparql_7 {
	
	public static final String NL = System.getProperty("line.separator") ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Model m = ModelFactory.createDefaultModel();
		  String file_jeux = "jeux.n3";
			
		  String jeux_ns1 = "http://www.type_jeux_videos.fr/jeux#";
		  String jeux_ns ="http://www.jeux.fr/jeux#";
		  String prolog = "PREFIX jeux: <"+jeux_ns+">" ;
		  String prolog1 = "PREFIX type_jeux_videos: <"+jeux_ns1+">" ;
		  String prolog2 = "PREFIX rdf: <"+RDF.getURI()+">" ;
		  String prolog3 = "PREFIX rdfs: <"+RDFS.getURI()+">" ;
		 
		  System.out.println(prolog);
		  System.out.println(prolog1);
		  System.out.println(prolog2);
		  System.out.println(prolog3);
		 
		  m.read(file_jeux);
		  
		  // requête qui nous permet de renvoyer la liste de tout les jeux de sports
		  String rdq = prolog1 + NL + prolog2 + NL  + prolog3 + NL  + prolog + NL +
		  "SELECT ?jeux_de_sports WHERE {{?jeux_de_sports rdf:type type_jeux_videos:Football} UNION {?jeux_de_sports rdf:type type_jeux_videos:Basketball}}";
		  
		
		  Query query = QueryFactory.create(rdq);
		  QueryExecution qexec = QueryExecutionFactory.create(query, m);
		  query.serialize(new IndentedWriter(System.out,true)) ;
		  System.out.println("liste de tous les jeux de sports");
		  
		  try {
		       ResultSet rs = qexec.execSelect() ;
		       //formatage lors de l'éxécution de la requête
		       ResultSetFormatter.out(System.out, rs, query);		  
		  }
		  finally {qexec.close();}


	}

}
