
package eu.scasefp7.agora.query;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Must {

    @Expose
    private Match match;

    public Must() {
    	match=new Match();
	}

	/**
     * 
     * @return
     *     The match
     */
    public Match getMatch() {
        return match;
    }

    /**
     * 
     * @param match
     *     The match
     */
    public void setMatch(Match match) {
        this.match = match;
    }

}
