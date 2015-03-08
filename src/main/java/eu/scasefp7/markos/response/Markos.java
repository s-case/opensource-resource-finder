
package eu.scasefp7.markos.response;

import javax.xml.bind.annotation.XmlElement;


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
