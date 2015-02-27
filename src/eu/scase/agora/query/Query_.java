package eu.scase.agora.query;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Query_ {
	@Expose
	private Match match;

	@Expose
	private Bool bool;

	
	@Expose
	private Filtered filtered;
	
	public Query_() {

	}

	public Filtered getFiltered() {
		return filtered;
	}

	public void setFiltered(Filtered filtered) {
		this.filtered = filtered;
	}

	/**
	 * 
	 * @return The bool
	 */
	public Bool getBool() {
		return bool;
	}

	/**
	 * 
	 * @param bool
	 *            The bool
	 */
	public void setBool(Bool bool) {
		this.bool = bool;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}
