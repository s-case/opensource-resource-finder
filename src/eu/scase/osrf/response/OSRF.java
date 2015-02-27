package eu.scase.osrf.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class OSRF {

	private String projectName;
	private String forge;
	private String className;
	private String url;
	private String release;
	private String similarityScore;
	private String sourceCode;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@XmlElement
	public String getForge() {
		return forge;
	}

	public void setForge(String forge) {
		this.forge = forge;
	}

	@XmlElement
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@XmlElement
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@XmlElement
	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	@XmlElement
	public String getSimilarityScore() {
		return similarityScore;
	}

	public void setSimilarityScore(String similarityScore) {
		this.similarityScore = similarityScore;
	}
	@XmlElement
	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

}
