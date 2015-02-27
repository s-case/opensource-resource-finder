package eu.scase.osrf;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import eu.scase.agora.AgoraClient;
import eu.scase.agora.response.Agora;
import eu.scase.markos.MarkosClient;
import eu.scase.markos.response.MarkosAsset;
import eu.scase.osrf.response.OSRF;

@Path("/project")
public class SearchProject {
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public eu.scase.osrf.response.Response search(		
			@QueryParam("name") String projectName) {


		//call agora api		
		Agora agora=AgoraClient.queryAgora(AgoraClient.formAgoraInput(null,  null,
				null,  projectName,null));
		//call markos api
		ArrayList<MarkosAsset> markos=MarkosClient.queryMarkos(MarkosClient.formMarkosInput(null,  null,
				null,  projectName));
		eu.scase.osrf.response.Response response=new eu.scase.osrf.response.Response();
		response.setResult(new ArrayList<OSRF>());
		if(agora!=null)
		response.getResult().addAll(AgoraClient.parseResponse(agora));
		response.getResult().addAll(MarkosClient.parseResponse(markos));
		return response;		

	}
}
