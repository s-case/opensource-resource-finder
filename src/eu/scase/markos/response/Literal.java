package eu.scase.markos.response;

import javax.xml.bind.annotation.XmlAttribute;

public class Literal
{
    private String content;
    @XmlAttribute
    private String datatype;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

//    public String getDatatype ()
//    {
//        return datatype;
//    }

    public void setDatatype (String datatype)
    {
        this.datatype = datatype;
    }
}
