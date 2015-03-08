
package eu.scasefp7.agora.query;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Query {

    
    @Expose
    private Filtered filtered;  
    
    @Expose
    private Query_ query;
    
    public Query() {
    //	query=new Query_();
	}
    
    

	/**
     * 
     * @return
     *     The query
     */
    public Query_ getQuery() {
        return query;
    }

    /**
     * 
     * @param query
     *     The query
     */
    public void setQuery(Query_ query) {
        this.query = query;
    }



	public Filtered getFiltered() {
		return filtered;
	}



	public void setFiltered(Filtered filtered) {
		this.filtered = filtered;
	}

}
