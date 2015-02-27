package eu.scase.markos.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "binding")
public class Binding
{
	@XmlAttribute
    private String name;

    private String uri;
//    @XmlElement(name = "name")
//    public String getName ()
//    {
//        return name;
//    }

    public void setName (String name)
    {
        this.name = name;
    }
    @XmlElement(name = "uri")
    public String getUri ()
    {
        return uri;
    }

    public void setUri (String uri)
    {
        this.uri = uri;
    }
}