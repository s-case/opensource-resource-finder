package eu.scase.markos.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "results")
public class Results
{
    private ArrayList<Result> result;
    @XmlElement(name = "result")
    public ArrayList<Result> getResult ()
    {
        return result;
    }
    
    public void setResult (ArrayList<Result> result)
    {
        this.result = result;
    }
}