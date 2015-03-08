package eu.scasefp7.agora.query;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filter {
	@Expose
	private Type type;

	@SerializedName("has_parent")
	@Expose
	private HasParent hasParent;
	@SerializedName("query")
	@Expose
	private Query_ query;
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public HasParent getHasParent() {
		return hasParent;
	}

	public void setHasParent(HasParent hasParent) {
		this.hasParent = hasParent;
	}

	public Query_ getQuery() {
		return query;
	}

	public void setQuery(Query_ query) {
		this.query = query;
	}

}
