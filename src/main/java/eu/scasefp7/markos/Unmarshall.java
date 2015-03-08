package eu.scasefp7.markos;

import javax.xml.bind.JAXBContext;

import eu.scasefp7.markos.response.Sparql;

public class Unmarshall {

	public static void main(String[] args) {
		
		try {
			JAXBContext context;
			context = JAXBContext.newInstance(Sparql.class);

			context.createUnmarshaller();
			// InputStream is = new ByteArrayInputStream(output.getBytes());
//			Sparql emp = (Sparql) un.unmarshal(new File("C:/test.xml"));
//			System.out.println();
		
			
			
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
