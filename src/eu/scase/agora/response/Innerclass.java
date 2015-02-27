
package eu.scase.agora.response;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlElement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Innerclass {

    @Expose
    private List<Method> methods = new ArrayList<Method>();
    @Expose
    private List<Variable> variables = new ArrayList<Variable>();
    @Expose
    private String type;
    @Expose
    private String name;
    @SerializedName("implements")
    @Expose
    private List<String> _implements = new ArrayList<String>();
    @Expose
    private List<String> modifiers = new ArrayList<String>();

    /**
     * 
     * @return
     *     The methods
     */
    @XmlElement
    public List<Method> getMethods() {
        return methods;
    }

    /**
     * 
     * @param methods
     *     The methods
     */
    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    /**
     * 
     * @return
     *     The variables
     */
    @XmlElement
    public List<Variable> getVariables() {
        return variables;
    }

    /**
     * 
     * @param variables
     *     The variables
     */
    public void setVariables(List<Variable> variables) {
        this.variables = variables;
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
     *     The _implements
     */
    @XmlElement
    public List<String> getImplements() {
        return _implements;
    }

    /**
     * 
     * @param _implements
     *     The implements
     */
    public void setImplements(List<String> _implements) {
        this._implements = _implements;
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

}
