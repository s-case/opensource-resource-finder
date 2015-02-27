package eu.scase.markos;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import eu.scase.markos.response.Binding;
import eu.scase.markos.response.Markos;
import eu.scase.markos.response.Result;
import eu.scase.markos.response.Results;
import eu.scase.markos.response.Sparql;

public class Unmarshall {

	public static void main(String[] args) {
		
		try {
			JAXBContext context;
			context = JAXBContext.newInstance(Sparql.class);

			Unmarshaller un = context.createUnmarshaller();
			// InputStream is = new ByteArrayInputStream(output.getBytes());
			Sparql emp = (Sparql) un.unmarshal(new File("C:/test.xml"));
			System.out.println();
		
			
			
			//marshall
//			Sparql sp=new Sparql();
//			Results res=new Results();
//			ArrayList<Result> results=new ArrayList<Result>();
//			Result r1=new Result();
//			r1.setBinding(new ArrayList<Binding>());
//			Binding b1=new Binding();
//			b1.setName("test1");
//			b1.setUri("test2");
//			Binding b2=new Binding();
//			b2.setName("test2");
//			b2.setUri("test2");
//			r1.getBinding().add(b1);
//			r1.getBinding().add(b2);
//			results.add(r1);
//			res.setResult(results);
//			sp.setResults(res);
//			JAXBContext context = JAXBContext.newInstance(Sparql.class);
//            Marshaller m = context.createMarshaller();
//          
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
// 
//           
//            m.marshal(sp, new File("C:/test2.xml"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
