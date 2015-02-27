package eu.scase.markos.response;

import javax.xml.bind.annotation.XmlElement;

public class Head
{
    private Variable[] variable;
    @XmlElement(name = "variable")
    public Variable[] getVariable ()
    {
        return variable;
    }

    public void setVariable (Variable[] variable)
    {
        this.variable = variable;
    }
}