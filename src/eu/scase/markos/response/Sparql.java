package eu.scase.markos.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "sparql",namespace="http://www.w3.org/2005/sparql-results#")
public class Sparql
{
  //  private Results results;

 //   private String xmlns;
	
    private Head head;
//    @XmlElement(name = "results")
//    public Results getResults ()
//    {
//        return results;
//    }
//
//    public void setResults (Results results)
//    {
//        this.results = results;
//    }
//    @XmlElement(name = "Document")
//    public String getXmlns ()
//    {
//        return xmlns;
//    }

//    public void setXmlns (String xmlns)
//    {
//        this.xmlns = xmlns;
//    }
    @XmlElement(name = "head")
    public Head getHead ()
    {
        return head;
    }

    public void setHead (Head head)
    {
        this.head = head;
    }
}
