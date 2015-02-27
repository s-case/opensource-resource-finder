
package eu.scase.markos.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Markos
{
	
    private Sparql sparql;
    @XmlElement(name = "sparql")
    public Sparql getSparql ()
    {
        return sparql;
    }

    public void setSparql (Sparql sparql)
    {
        this.sparql = sparql;
    }
}
