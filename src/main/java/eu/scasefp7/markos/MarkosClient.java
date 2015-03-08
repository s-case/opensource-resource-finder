package eu.scasefp7.markos;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import eu.scasefp7.markos.response.MarkosAsset;
import eu.scasefp7.markos.response.SparqlParser;
import eu.scasefp7.osrf.Forges;
import eu.scasefp7.osrf.response.OSRF;

public class MarkosClient {

	static public String formMarkosInput(String className, String implements_,
			String extends_, String projectName) {
		String query = "";
		if (className != null && !className.equals("")
				&& (implements_ == null || implements_.equals(""))
				&& (extends_ == null || extends_.equals(""))
				&& (projectName == null || projectName.equals(""))) {
			// query2
			query = "PREFIX luc: <http://www.ontotext.com/owlim/lucene#>"
					+ "PREFIX mtop:<http://www.markosproject.eu/ontologies/top#>"
					+ "PREFIX msw:<http://www.markosproject.eu/ontologies/software#>"
					+ "SELECT * WHERE {"
					+ "?class (mtop:name|mtop:fullyQualifiedName)/luc:ftsIndexShort \"\\\""
					+ className
					+ "\\\"~0\". "
					+ "?class a msw:SoftwareClass. "
					+ "?c_name ^mtop:fullyQualifiedName ?class. "
					+ "?class msw:provenanceRelease ?release. "
					+ "OPTIONAL { ?class msw:manifestation/mtop:webSiteURL ?url. } "
					+ "OPTIONAL { ?c_name luc:score ?score } "
					+ " ?release msw:provenance [ "
					+ "msw:hostingForge ?p_forge; " + "mtop:name ?p_name] "
					+ "}";
		} else if (className != null && !className.equals("")
				&& implements_ != null && !implements_.equals("")
				&& (extends_ == null || extends_.equals(""))
				&& (projectName == null || projectName.equals(""))) {
			// query4
			query = "PREFIX luc: <http://www.ontotext.com/owlim/lucene#> "
					+ "PREFIX top:<http://www.markosproject.eu/ontologies/top#> "
					+ "PREFIX msw:<http://www.markosproject.eu/ontologies/software#> "
					+ "SELECT * WHERE {"
					+ "?class a msw:SoftwareClass."
					+ "?class (top:name|top:fullyQualifiedName)/luc:ftsIndexShort \"\\\""
					+ className
					+ "\\\"~0\"."
					+ "?impl_iface (top:name|top:fullyQualifiedName)/luc:ftsIndexShort \"\\\""
					+ implements_
					+ "\\\"~0\"."
					+ "?class msw:directImplementedInterface ?ext_class. "
					+ "?c_name ^top:name ?class. "
					+ "?class msw:provenanceRelease ?release. "
					+ "OPTIONAL { ?class msw:manifestation/top:webSiteURL ?url. } "
					+ "OPTIONAL { ?c_name luc:score ?score } "
					+ " ?release msw:provenance [ "
					+ "msw:hostingForge ?p_forge; " + "top:name ?p_name] "
					+ "}";
		} else if (className != null && !className.equals("")
				&& extends_ != null && !extends_.equals("")
				&& (implements_ == null || implements_.equals(""))
				&& (projectName == null || projectName.equals(""))) {
			// query 5
			query = "PREFIX luc: <http://www.ontotext.com/owlim/lucene#> "
					+ "PREFIX top:<http://www.markosproject.eu/ontologies/top#> "
					+ "PREFIX msw:<http://www.markosproject.eu/ontologies/software#> "
					+ "SELECT * WHERE {"
					+ "?class a msw:SoftwareClass."
					+ "?class (top:name|top:fullyQualifiedName)/luc:ftsIndexShort \"\\\""
					+ className
					+ "\\\"~0\"."
					+ "?ext_class (top:name|top:fullyQualifiedName)/luc:ftsIndexShort \"\\\""
					+ implements_
					+ "\\\"~0\"."
					+ "?class msw:directExtendedType ?ext_class."
					+ "?c_name ^top:name ?class. "
					+ "?class msw:provenanceRelease ?release. "
					+ "OPTIONAL { ?class msw:manifestation/top:webSiteURL ?url. } "
					+ "OPTIONAL { ?c_name luc:score ?score } "
					+ " ?release msw:provenance [ "
					+ "msw:hostingForge ?p_forge; " + "top:name ?p_name] "
					+ "}";
		} else if (projectName != null && !projectName.equals("")) {
			// query1
			query = "PREFIX luc: <http://www.ontotext.com/owlim/lucene#> "
					+ "PREFIX mtop:<http://www.markosproject.eu/ontologies/top#> "
					+ "PREFIX msw:<http://www.markosproject.eu/ontologies/software#> "
					+ "PREFIX foaf:<http://xmlns.com/foaf/0.1/> "
					+ "SELECT * WHERE {"
					+ "?proj mtop:name/luc:ftsIndexShort \"\\\""
					+ projectName
					+ "\\\"~0\". "
					+ "?proj a msw:SoftwareProject; "
					+ "mtop:name ?p_name; "
					+ "msw:softwareRepository ?repo; "
					+ "msw:hostingForge ?p_forge. "
					+ " OPTIONAL { ?proj msw:mantainer/foaf:name ?owner_name. } "
					+ "OPTIONAL { " + "?repo msw:webInterfaceURL ?branch_url. "
					+ "}" + "OPTIONAL { ?p_name luc:score ?score } " + " }";
		}
		return query;
	}

	public static ArrayList<MarkosAsset> queryMarkos(String query) {
		ArrayList<MarkosAsset> result = new ArrayList<MarkosAsset>();
		try {

			Client client = Client.create();
			client.setConnectTimeout(10000);
			client.setReadTimeout(10000);
			WebResource webResource = client
					.resource("http://demo.markosproject.eu/data/sparql");

			MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
			formData.add("query", query);

			ClientResponse response = webResource
					.accept("application/sparql-results+xml")
					.entity(formData, MediaType.APPLICATION_FORM_URLENCODED)
					.post(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			String output = response.getEntity(String.class);
			// System.out.println("Output from Server");
			System.out.println(output);

			// JAXBContext context = JAXBContext.newInstance(Result.class);
			// Unmarshaller un = context.createUnmarshaller();
			// InputStream is = new ByteArrayInputStream(output.getBytes());
			// result = (Result) un.unmarshal(is);
			// System.out.println();
			result = SparqlParser.parseSparql(output);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	static public ArrayList<OSRF> parseResponse(ArrayList<MarkosAsset> markos) {
		ArrayList<OSRF> response = new ArrayList<OSRF>();
		for (int i = 0; i < markos.size(); i++) {
			MarkosAsset m = markos.get(i);
			OSRF res = new OSRF();

			res.setSimilarityScore(m.getScore());
			res.setUrl(m.getUrl());
			res.setClassName(m.getClassName());
			if (m.getForge().endsWith("sourceforge")) {
				res.setForge(Forges.SF);
			} else if (m.getForge().endsWith("apache")) {
				res.setForge(Forges.APACHE);
			} else if (m.getForge().endsWith("github")) {
				res.setForge(Forges.GITHUB);
			} else
				res.setForge(m.getForge());
			res.setProjectName(m.getProjectName());
			response.add(res);
		}
		return response;
	}

	public static void main(String[] args) {

		// System.out.println(
		// "PREFIX luc: <http://www.ontotext.com/owlim/lucene#> "
		// + "PREFIX top:<http://www.markosproject.eu/ontologies/top#> "
		// + "PREFIX msw:<http://www.markosproject.eu/ontologies/software#> "
		// + "SELECT ?class WHERE { "
		// + "?class a msw:SoftwareClass. "
		// +
		// "?class (top:name|top:fullyQualifiedName)/luc:ftsIndexShort \"\\\"Stack\\\"~0\". "
		// + "?class top:subordinateEntity [ "
		// + "a msw:Method; "
		// + "top:name/luc:ftsIndexShort \"pop\"]. "
		// + "?class top:subordinateEntity [ "
		// + "a msw:Method; "
		// + "top:name/luc:ftsIndexShort \"push\"]. "
		// + "}");

		try {

			Client client = Client.create();
			client.setConnectTimeout(1000000);
			client.setReadTimeout(1000000);
			WebResource webResource = client
					.resource("http://demo.markosproject.eu/data/sparql");

			MultivaluedMap<String, String> formData = new MultivaluedMapImpl();

			String option = "1";
			switch (option) {
			case "1":
				formData.add(
						"query",
						"PREFIX luc: <http://www.ontotext.com/owlim/lucene#> "
								+ "PREFIX mtop:<http://www.markosproject.eu/ontologies/top#> "
								+ "PREFIX msw:<http://www.markosproject.eu/ontologies/software#> "
								+ "PREFIX foaf:<http://xmlns.com/foaf/0.1/> "
								+ "SELECT * WHERE {"
								+ "?proj mtop:name/luc:ftsIndexShort \"\\\"apache\\\"~0\". "
								+ "?proj a msw:SoftwareProject; "
								+ "mtop:name ?p_name; "
								+ "msw:softwareRepository ?repo; "
								+ "msw:hostingForge ?p_forge. "
								+ " OPTIONAL { ?proj msw:mantainer/foaf:name ?owner_name. } "
								+ "OPTIONAL { " + "?repo a msw:GitBranch; "
								+ "msw:webInterfaceURL ?branch_url. " + "}"
								+ "OPTIONAL { ?p_name luc:score ?score } "
								+ " }");
				break;
			case "2":
				formData.add(
						"query",
						"PREFIX luc: <http://www.ontotext.com/owlim/lucene#>"
								+ "PREFIX mtop:<http://www.markosproject.eu/ontologies/top#>"
								+ "PREFIX msw:<http://www.markosproject.eu/ontologies/software#>"
								+ "SELECT * WHERE {"
								+ "?class (mtop:name|mtop:fullyQualifiedName)/luc:ftsIndexShort \"\\\"Stack\\\"~0\". "
								+ "?class a msw:SoftwareClass. "
								+ "?c_name ^mtop:fullyQualifiedName ?class. "
								+ "?class msw:provenanceRelease ?release. "
								+ "OPTIONAL { ?class msw:manifestation/mtop:webSiteURL ?url. } "
								+ "OPTIONAL { ?c_name luc:score ?score } "
								+ " ?release msw:provenance [ "
								+ "msw:hostingForge ?p_forge; "
								+ "mtop:name ?p_name] " + "}");
				break;

			case "3":
				formData.add(
						"query",
						"PREFIX luc: <http://www.ontotext.com/owlim/lucene#>"
								+ "PREFIX mtop:<http://www.markosproject.eu/ontologies/top#>"
								+ "PREFIX msw:<http://www.markosproject.eu/ontologies/software#>"
								+ "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#> "
								+ "SELECT * WHERE {"
								+ "?class (mtop:name|mtop:fullyQualifiedName)/luc:ftsIndexShort \"\\\"Stack\\\"~0\". "
								+ "?class a msw:SoftwareClass. "
								+ "?class msw:ownedMethod/mtop:name \"popElement\"^^xsd:string . "
								+ "?class msw:ownedMethod/mtop:name \"pushElement\"^^xsd:string . "
								+ "?c_name ^mtop:fullyQualifiedName ?class. "
								+ "?class msw:provenanceRelease ?release. "
								+ "OPTIONAL { ?class msw:manifestation/mtop:webSiteURL ?url. } "
								+ "OPTIONAL { ?c_name luc:score ?score } "
								+ " ?release msw:provenance [ "
								+ "msw:hostingForge ?p_forge; "
								+ "mtop:name ?p_name] " + "}");
				break;

			case "4":
				formData.add(
						"query",
						"PREFIX luc: <http://www.ontotext.com/owlim/lucene#> "
								+ "PREFIX top:<http://www.markosproject.eu/ontologies/top#> "
								+ "PREFIX msw:<http://www.markosproject.eu/ontologies/software#> "
								+ "SELECT * WHERE {"
								+ "?class a msw:SoftwareClass."
								+ "?class (top:name|top:fullyQualifiedName)/luc:ftsIndexShort \"\\\"Tree\\\"~0\"."
								+ "?impl_iface (top:name|top:fullyQualifiedName)/luc:ftsIndexShort \"\\\"TreeModel\\\"~0\"."
								+ "?class msw:directImplementedInterface ?ext_class. "
								+ "?c_name ^top:name ?class. "
								+ "?class msw:provenanceRelease ?release. "
								+ "OPTIONAL { ?class msw:manifestation/top:webSiteURL ?url. } "
								+ "OPTIONAL { ?c_name luc:score ?score } "
								+ " ?release msw:provenance [ "
								+ "msw:hostingForge ?p_forge; "
								+ "top:name ?p_name] " + "}");
				break;
			case "5":
				formData.add(
						"query",
						"PREFIX luc: <http://www.ontotext.com/owlim/lucene#> "
								+ "PREFIX top:<http://www.markosproject.eu/ontologies/top#> "
								+ "PREFIX msw:<http://www.markosproject.eu/ontologies/software#> "
								+ "SELECT * WHERE {"
								+ "?class a msw:SoftwareClass."
								+ "?class (top:name|top:fullyQualifiedName)/luc:ftsIndexShort \"\\\"Export\\\"~0\"."
								+ "?ext_class (top:name|top:fullyQualifiedName)/luc:ftsIndexShort \"\\\"WizardPage\\\"~0\"."
								+ "?class msw:directExtendedType ?ext_class."
								+ "?c_name ^top:name ?class. "
								+ "?class msw:provenanceRelease ?release. "
								+ "OPTIONAL { ?class msw:manifestation/top:webSiteURL ?url. } "
								+ "OPTIONAL { ?c_name luc:score ?score } "
								+ " ?release msw:provenance [ "
								+ "msw:hostingForge ?p_forge; "
								+ "top:name ?p_name] " + "}");

				break;
			}

			ClientResponse response = webResource
					.accept("application/sparql-results+xml")
					.entity(formData, MediaType.APPLICATION_FORM_URLENCODED)
					.post(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			String output = response.getEntity(String.class);
			System.out.println("Output from Server");
			System.out.println(output);

			// JAXBContext context = JAXBContext.newInstance(Result.class);
			// Unmarshaller un = context.createUnmarshaller();
			// // InputStream is = new ByteArrayInputStream(output.getBytes());
			// Result emp = (Result) un.unmarshal(new File("C:\test.xml"));
			// System.out.println();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
