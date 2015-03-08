package eu.scase.agora.query;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Match {

	@Expose
	private String name;
	
	@Expose
	private String analyzedcontent;

	@SerializedName("code.class.name")
	@Expose
	private String codeClassName;

	@SerializedName("code.class.extends")
	@Expose
	private String codeClassExtends;

	@SerializedName("code.class.implements")
	@Expose
	private String codeClassImplements;

	/**
	 * 
	 * @return The codeClassName
	 */
	public String getCodeClassName() {
		return codeClassName;
	}

	/**
	 * 
	 * @param codeClassName
	 *            The code.class.name
	 */
	public void setCodeClassName(String codeClassName) {
		this.codeClassName = codeClassName;
	}

	public String getCodeClassExtends() {
		return codeClassExtends;
	}

	public void setCodeClassExtends(String codeClassExtends) {
		this.codeClassExtends = codeClassExtends;
	}

	public String getCodeClassImplements() {
		return codeClassImplements;
	}

	public void setCodeClassImplements(String codeClassImplements) {
		this.codeClassImplements = codeClassImplements;
	}

	public String getAnalyzedcontent() {
		return analyzedcontent;
	}

	public void setAnalyzedcontent(String analyzedcontent) {
		this.analyzedcontent = analyzedcontent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
