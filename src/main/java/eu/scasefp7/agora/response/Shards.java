
package eu.scasefp7.agora.response;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlElement;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Shards {

    @Expose
    private Integer total;
    @Expose
    private Integer successful;
    @Expose
    private Integer failed;

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
     *     The successful
     */
    @XmlElement
    public Integer getSuccessful() {
        return successful;
    }

    /**
     * 
     * @param successful
     *     The successful
     */
    public void setSuccessful(Integer successful) {
        this.successful = successful;
    }

    /**
     * 
     * @return
     *     The failed
     */
    @XmlElement
    public Integer getFailed() {
        return failed;
    }

    /**
     * 
     * @param failed
     *     The failed
     */
    public void setFailed(Integer failed) {
        this.failed = failed;
    }

}
