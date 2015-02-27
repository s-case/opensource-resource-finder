package eu.scase.markos.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
public class Result
{
    private ArrayList<Binding> binding;
    @XmlElement(name = "binding")
    public ArrayList<Binding> getBinding ()
    {
        return binding;
    }

    public void setBinding (ArrayList<Binding> binding)
    {
        this.binding = binding;
    }
}
