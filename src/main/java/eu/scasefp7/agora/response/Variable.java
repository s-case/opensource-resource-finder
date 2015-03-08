
package eu.scasefp7.agora.response;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
@XmlType(name="variable2")
public class Variable {

    @Expose
    private String name;
    @Expose
    private List<String> modifiers = new ArrayList<String>();
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
     *     The modifiers
     */
    @XmlElement
    public List<String> getModifiers() {
        return modifiers;
    }

    /**
     * 
     * @param modifiers
     *     The modifiers
     */
    public void setModifiers(List<String> modifiers) {
        this.modifiers = modifiers;
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
