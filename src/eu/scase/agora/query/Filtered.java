package eu.scase.agora.query;

import com.google.gson.annotations.Expose;

public class Filtered {
	@Expose
	private Filter filter;
	@Expose
	private Query_ query;

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public Query_ getQuery() {
		return query;
	}

	public void setQuery(Query_ query) {
		this.query = query;
	}

}
