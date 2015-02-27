
package eu.scase.agora.response;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
@XmlType(name="method2")
public class Method {

    @Expose
    private String returntype;
    @Expose
    private String name;
    @Expose
    private List<String> modifiers = new ArrayList<String>();
    @Expose
    private List<Object> parameters = new ArrayList<Object>();
    @SerializedName("throws")
    @Expose
    private List<Object> _throws = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The returntype
     */
    @XmlElement
    public String getReturntype() {
        return returntype;
    }

    /**
     * 
     * @param returntype
     *     The returntype
     */
    public void setReturntype(String returntype) {
        this.returntype = returntype;
    }

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
     *     The parameters
     */
    @XmlElement
    public List<Object> getParameters() {
        return parameters;
    }

    /**
     * 
     * @param parameters
     *     The parameters
     */
    public void setParameters(List<Object> parameters) {
        this.parameters = parameters;
    }

    /**
     * 
     * @return
     *     The _throws
     */
    @XmlElement
    public List<Object> getThrows() {
        return _throws;
    }

    /**
     * 
     * @param _throws
     *     The throws
     */
    public void setThrows(List<Object> _throws) {
        this._throws = _throws;
    }

}
