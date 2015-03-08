
package eu.scase.agora.response;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlElement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Hit {

    @SerializedName("_index")
    @Expose
    private String Index;
    @SerializedName("_type")
    @Expose
    private String Type;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("_score")
    @Expose
    private Double Score;
    @SerializedName("_source")
    @Expose
    private eu.scase.agora.response.Source Source;

    /**
     * 
     * @return
     *     The Index
     */
    @XmlElement
    public String getIndex() {
        return Index;
    }

    /**
     * 
     * @param Index
     *     The _index
     */
    public void setIndex(String Index) {
        this.Index = Index;
    }

    /**
     * 
     * @return
     *     The Type
     */
    @XmlElement
    public String getType() {
        return Type;
    }

    /**
     * 
     * @param Type
     *     The _type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * 
     * @return
     *     The Id
     */
    @XmlElement
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The Score
     */
    @XmlElement
    public Double getScore() {
        return Score;
    }

    /**
     * 
     * @param Score
     *     The _score
     */
    public void setScore(Double Score) {
        this.Score = Score;
    }

    /**
     * 
     * @return
     *     The Source
     */
    @XmlElement
    public eu.scase.agora.response.Source getSource() {
        return Source;
    }

    /**
     * 
     * @param Source
     *     The _source
     */
    public void setSource(eu.scase.agora.response.Source Source) {
        this.Source = Source;
    }

}
