
package eu.scase.agora.response;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlElement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Code {

    @Expose
    private List<String> imports = new ArrayList<String>();
    @SerializedName("package")
    @Expose
    private String _package;
    @SerializedName("class")
    @Expose
    private Class _class;
    @Expose
    private List<Object> otherclasses = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The imports
     */
    @XmlElement
    public List<String> getImports() {
        return imports;
    }

    /**
     * 
     * @param imports
     *     The imports
     */
    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    /**
     * 
     * @return
     *     The _package
     */
    @XmlElement
    public String getPackage() {
        return _package;
    }

    /**
     * 
     * @param _package
     *     The package
     */
    public void setPackage(String _package) {
        this._package = _package;
    }

    /**
     * 
     * @return
     *     The _class
     */
    @XmlElement
    public Class getClass_() {
        return _class;
    }

    /**
     * 
     * @param _class
     *     The class
     */
    public void setClass_(Class _class) {
        this._class = _class;
    }

    /**
     * 
     * @return
     *     The otherclasses
     */
    @XmlElement
    public List<Object> getOtherclasses() {
        return otherclasses;
    }

    /**
     * 
     * @param otherclasses
     *     The otherclasses
     */
    public void setOtherclasses(List<Object> otherclasses) {
        this.otherclasses = otherclasses;
    }

}
