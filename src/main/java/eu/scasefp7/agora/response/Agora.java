
package eu.scasefp7.agora.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "result")
public class Agora {

    @Expose
  
    private Integer took;
    @SerializedName("timed_out")
    @Expose
  
    private Boolean timedOut;
    @SerializedName("_shards")
    @Expose
   
    private eu.scasefp7.agora.response.Shards Shards;
    @Expose
  
    private Hits hits;

    public Agora() {
		
	}

	/**
     * 
     * @return
     *     The took
     */
    @XmlElement
    public Integer getTook() {
        return took;
    }

    /**
     * 
     * @param took
     *     The took
     */
    public void setTook(Integer took) {
        this.took = took;
    }

    /**
     * 
     * @return
     *     The timedOut
     */
    @XmlElement
    public Boolean getTimedOut() {
        return timedOut;
    }

    /**
     * 
     * @param timedOut
     *     The timed_out
     */
    public void setTimedOut(Boolean timedOut) {
        this.timedOut = timedOut;
    }

    /**
     * 
     * @return
     *     The Shards
     */
    @XmlElement
    public eu.scasefp7.agora.response.Shards getShards() {
        return Shards;
    }

    /**
     * 
     * @param Shards
     *     The _shards
     */
    public void setShards(eu.scasefp7.agora.response.Shards Shards) {
        this.Shards = Shards;
    }

    /**
     * 
     * @return
     *     The hits
     */
    @XmlElement
    public Hits getHits() {
        return hits;
    }

    /**
     * 
     * @param hits
     *     The hits
     */
    public void setHits(Hits hits) {
        this.hits = hits;
    }



}
