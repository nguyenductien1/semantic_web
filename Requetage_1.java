package web_semantique;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.XSD;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;

public class Requetage_1 {
	
	public static final String rdf_file = "jeux.n3";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Model model = ModelFactory.createDefaultModel();
			model.read(rdf_file);
			String jeux_ns = model.getNsPrefixURI("jeux");
			Resource NBA2k21 = model.getResource(jeux_ns + " NBA2k21");
			StmtIterator propertiesIter = model.listStatements(NBA2k21, (Property)null, (RDFNode)null );
			for(; propertiesIter.hasNext();) {
				Statement stmt = propertiesIter.nextStatement();
				Property p = stmt.getPredicate();
				System.out.print(p.getLocalName() + "  ");
				RDFNode o = stmt.getObject();
				if(o.isLiteral()) {
					System.out.println("  " + o.toString());
				}else if(o.isAnon()) {
					Resource r1 = (Resource) o;
					System.out.println("Id : " + r1.getId());
				}else {
					Resource r2 = (Resource) o;
					System.out.println("Nom qualifié  : " + r2.getLocalName());
				System.out.println();
				}
			}
		}catch(Exception e) {
			System.out.println("Failure " + e);
		}

	}

}
