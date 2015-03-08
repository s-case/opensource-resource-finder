
package eu.scasefp7.agora.response;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlElement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Hits {

    @Expose
    private Integer total;
    @SerializedName("max_score")
    @Expose
    private Double maxScore;
    @Expose
    private List<Hit> hits = new ArrayList<Hit>();

    /**
     * 
     * @return
     *     The total
     */
    @XmlElement
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The maxScore
     */
    @XmlElement
    public Double getMaxScore() {
        return maxScore;
    }

    /**
     * 
     * @param maxScore
     *     The max_score
     */
    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    /**
     * 
     * @return
     *     The hits
     */
    @XmlElement
    public List<Hit> getHits() {
        return hits;
    }

    /**
     * 
     * @param hits
     *     The hits
     */
    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
