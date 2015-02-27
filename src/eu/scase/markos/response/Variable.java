package eu.scase.markos.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Variable
{
	@XmlAttribute
    private String name;

    

    public void setName (String name)
    {
        this.name = name;
    }
}
		