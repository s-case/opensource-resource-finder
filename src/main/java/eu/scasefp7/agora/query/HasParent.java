package eu.scasefp7.agora.query;

import com.google.gson.annotations.Expose;

public class HasParent {
	@Expose
	private String parent_type;

	@Expose
	private Query_ query;

	public String getParent_type() {
		return parent_type;
	}

	public void setParent_type(String parent_type) {
		this.parent_type = parent_type;
	}

	public Query_ getQuery() {
		return query;
	}

	public void setQuery(Query_ query) {
		this.query = query;
	}

}
