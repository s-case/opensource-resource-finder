package eu.scasefp7.markos.response;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SparqlParser {

	static public ArrayList<MarkosAsset> parseSparql(String xml) throws SAXException {
		ArrayList<MarkosAsset> results = new ArrayList<MarkosAsset>();
		DOMParser parser = new DOMParser();

		try {
			parser.parse(new InputSource(new ByteArrayInputStream(xml
					.getBytes("utf-8"))));

			Document document = parser.getDocument();
			document.normalizeDocument();
			NodeList resultNodes = document.getElementsByTagName("result");
			System.out.println("There are " + resultNodes.getLength()
					+ "  elements.");
			for (int i = 0; i < resultNodes.getLength(); i++) {
				Node node = resultNodes.item(i);
				MarkosAsset result = new MarkosAsset();
				NodeList bindingNodes = node.getChildNodes();
				for (int j = 0; j < bindingNodes.getLength(); j++) {
					Node cNode = bindingNodes.item(j);

					if (cNode.getAttributes() != null)
						switch (cNode.getAttributes().getNamedItem("name")
								.getNodeValue()) {

						case "p_name":
							NodeList childNodes2 = cNode.getChildNodes();
							for (int k = 0; k < childNodes2.getLength(); k++) {
								Node cNode2 = childNodes2.item(k);
								if (cNode2.getNodeName().equals("literal"))
									result.setProjectName(cNode2
											.getTextContent());

							}

							break;

						case "proj":
							// childNodes2 = cNode.getChildNodes();
							// for (int k = 0; k < childNodes2.getLength(); k++)
							// {
							// Node cNode2 = childNodes2.item(k);
							// if (cNode2.getNodeName().equals("uri"))
							//
							// }
							break;

						case "repo":
							childNodes2 = cNode.getChildNodes();
							for (int k = 0; k < childNodes2.getLength(); k++) {
								Node cNode2 = childNodes2.item(k);
								if (cNode2.getNodeName().equals("uri"))
									result.setRepository(cNode2
											.getTextContent());
							}
							break;
						case "p_forge":
							childNodes2 = cNode.getChildNodes();
							for (int k = 0; k < childNodes2.getLength(); k++) {
								Node cNode2 = childNodes2.item(k);
								if (cNode2.getNodeName().equals("uri"))
									result.setForge(cNode2.getTextContent());
							}
							break;
						case "score":
							childNodes2 = cNode.getChildNodes();
							for (int k = 0; k < childNodes2.getLength(); k++) {
								Node cNode2 = childNodes2.item(k);
								if (cNode2.getNodeName().equals("literal"))
									result.setScore(cNode2.getTextContent());
							}
							break;
						case "c_name":
							childNodes2 = cNode.getChildNodes();
							for (int k = 0; k < childNodes2.getLength(); k++) {
								Node cNode2 = childNodes2.item(k);
								if (cNode2.getNodeName().equals("literal"))
									result.setClassName(cNode2.getTextContent());
							}
							break;
						case "release":
							childNodes2 = cNode.getChildNodes();
							for (int k = 0; k < childNodes2.getLength(); k++) {
								Node cNode2 = childNodes2.item(k);
								if (cNode2.getNodeName().equals("literal"))
									result.setRelease(cNode2.getTextContent());
							}
							break;
						case "branch_url":
							childNodes2 = cNode.getChildNodes();
							for (int k = 0; k < childNodes2.getLength(); k++) {
								Node cNode2 = childNodes2.item(k);
								if (cNode2.getNodeName().equals("literal"))
									result.setUrl(cNode2.getTextContent());
							}
							break;
						default:
							break;
						}

				}
				results.add(result);
			}

		} catch (IOException e) {
			System.err.println(e);
		}
		return results;
	}

	public static void main(String[] args) {
		String content;
		try {
			content = readFile("C:/test.xml", Charset.defaultCharset());
			parseSparql(content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}
