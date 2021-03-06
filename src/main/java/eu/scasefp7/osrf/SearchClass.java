package eu.scasefp7.osrf;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import eu.scasefp7.agora.AgoraClient;
import eu.scasefp7.agora.response.Agora;
import eu.scasefp7.markos.MarkosClient;
import eu.scasefp7.markos.response.MarkosAsset;
import eu.scasefp7.osrf.response.OSRF;

@Path("/class")
public class SearchClass {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public eu.scasefp7.osrf.response.Response search(
			@QueryParam("name") String className,
			@QueryParam("implements") String implements_,
			@QueryParam("extends") String extends_) {
		if (className == null && implements_ == null && extends_ == null)
			return new eu.scasefp7.osrf.response.Response();

		// call agora api
		Agora agora = AgoraClient.queryAgora(AgoraClient.formAgoraInput(
				className, implements_, extends_, null, null));
		// remove code snippet entries
		if(agora!=null)
		for (int i = 0; i < agora.getHits().getHits().size(); i++) {
			agora.getHits().getHits().get(i).getSource()
					.setAnalyzedcontent(null);
		}
		// call markos api
		ArrayList<MarkosAsset> markos = MarkosClient.queryMarkos(MarkosClient
				.formMarkosInput(className, implements_, extends_, null));
		eu.scasefp7.osrf.response.Response response = new eu.scasefp7.osrf.response.Response();
		response.setResult(new ArrayList<OSRF>());
		if(agora!=null)
		response.getResult().addAll(AgoraClient.parseResponse(agora));
		response.getResult().addAll(MarkosClient.parseResponse(markos));
		return response;

	}

}
