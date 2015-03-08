
package eu.scasefp7.agora.response;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlElement;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Source {

    @Expose
    private String content;
    @Expose
    private String sha;
    @Expose
    private String project;
    @Expose
    private String name;
    @Expose
    private Code code;
    @Expose
    private String analyzedcontent;
    @Expose
    private String fullpathname;
    @Expose
    private String extension;
    @Expose
    private String url;
    @Expose
    private String type;
    @Expose
    private String path;
    @Expose
    private String mode;

    /**
     * 
     * @return
     *     The content
     */
    @XmlElement
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * @return
     *     The sha
     */
    @XmlElement
    public String getSha() {
        return sha;
    }

    /**
     * 
     * @param sha
     *     The sha
     */
    public void setSha(String sha) {
        this.sha = sha;
    }

    /**
     * 
     * @return
     *     The project
     */
    @XmlElement
    public String getProject() {
        return project;
    }

    /**
     * 
     * @param project
     *     The project
     */
    public void setProject(String project) {
        this.project = project;
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
     *     The code
     */
    @XmlElement
    public Code getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(Code code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The analyzedcontent
     */
    @XmlElement
    public String getAnalyzedcontent() {
        return analyzedcontent;
    }

    /**
     * 
     * @param analyzedcontent
     *     The analyzedcontent
     */
    public void setAnalyzedcontent(String analyzedcontent) {
        this.analyzedcontent = analyzedcontent;
    }

    /**
     * 
     * @return
     *     The fullpathname
     */
    @XmlElement
    public String getFullpathname() {
        return fullpathname;
    }

    /**
     * 
     * @param fullpathname
     *     The fullpathname
     */
    public void setFullpathname(String fullpathname) {
        this.fullpathname = fullpathname;
    }

    /**
     * 
     * @return
     *     The extension
     */
    @XmlElement
    public String getExtension() {
        return extension;
    }

    /**
     * 
     * @param extension
     *     The extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * 
     * @return
     *     The url
     */
    @XmlElement
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
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
     *     The path
     */
    @XmlElement
    public String getPath() {
        return path;
    }

    /**
     * 
     * @param path
     *     The path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 
     * @return
     *     The mode
     */
    @XmlElement
    public String getMode() {
        return mode;
    }

    /**
     * 
     * @param mode
     *     The mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

}
