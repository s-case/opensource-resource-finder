package eu.scase.osrf.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "results")
public class Response {

	private ArrayList<OSRF> result;
	@XmlElement
	public ArrayList<OSRF> getResult() {
		return result;
	}

	public void setResult(ArrayList<OSRF> result) {
		this.result = result;
	}
	
	
}
