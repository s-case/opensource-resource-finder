package eu.scase.osrf;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import eu.scase.agora.AgoraClient;
import eu.scase.agora.query.Bool;
import eu.scase.agora.query.Filter;
import eu.scase.agora.query.Filtered;
import eu.scase.agora.query.HasParent;
import eu.scase.agora.query.Match;
import eu.scase.agora.query.Must;
import eu.scase.agora.query.Query;
import eu.scase.agora.query.Query_;
import eu.scase.agora.query.Type;
import eu.scase.agora.response.Agora;
import eu.scase.markos.MarkosClient;
import eu.scase.markos.response.MarkosAsset;
import eu.scase.markos.response.Result;
import eu.scase.osrf.response.OSRF;

@Path("/class")
public class SearchClass {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public eu.scase.osrf.response.Response search(
			@QueryParam("name") String className,
			@QueryParam("implements") String implements_,
			@QueryParam("extends") String extends_) {
		if (className == null && implements_ == null && extends_ == null)
			return new eu.scase.osrf.response.Response();

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
		eu.scase.osrf.response.Response response = new eu.scase.osrf.response.Response();
		response.setResult(new ArrayList<OSRF>());
		if(agora!=null)
		response.getResult().addAll(AgoraClient.parseResponse(agora));
		response.getResult().addAll(MarkosClient.parseResponse(markos));
		return response;

	}

}
