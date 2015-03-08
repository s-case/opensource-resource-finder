package eu.scase.osrf;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import eu.scase.agora.AgoraClient;
import eu.scase.agora.response.Agora;
import eu.scase.osrf.response.OSRF;

@Path("/snippet")
public class SearchSnippet {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public eu.scase.osrf.response.Response search(
			@QueryParam("code") String code) {
		if (code == null)
			return new eu.scase.osrf.response.Response();

		// call agora api
		Agora agora = AgoraClient.queryAgora(AgoraClient.formAgoraInput(null,
				null, null, null, code));
		// markos api does not support this functionality
		eu.scase.osrf.response.Response response = new eu.scase.osrf.response.Response();
		response.setResult(new ArrayList<OSRF>());
		if(agora!=null)
		response.getResult().addAll(AgoraClient.parseResponse(agora));

		return response;

	}

}
