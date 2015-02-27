
package eu.scase.agora.response;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlElement;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Parameter {

    @Expose
    private String name;
    @Expose
    private String type;

    /**
     * 
     * @return
     *     The name
     */
    @XmlElement
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The type
     */
    @XmlElement
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

}
