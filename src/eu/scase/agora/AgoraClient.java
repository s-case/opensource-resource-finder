package eu.scase.agora;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

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
import eu.scase.agora.response.Hit;
import eu.scase.osrf.Forges;
import eu.scase.osrf.response.OSRF;
import eu.scase.osrf.response.Response;

public class AgoraClient {

	static public String formAgoraInput(String className, String implements_,
			String extends_, String projectName, String code) {

		Query query = new Query();

		if (className != null && !className.equals("")) {
			Must must = new Must();
			must.getMatch().setCodeClassName(className);
			Query_ q1 = new Query_();
			query.setQuery(q1);
			if (query.getQuery().getBool() == null) {
				query.getQuery().setBool(new Bool());
			}
			query.getQuery().getBool().getMust().add(must);
		}
		if (implements_ != null && !implements_.equals("")) {
			Must must = new Must();
			must.getMatch().setCodeClassImplements(implements_);
			Query_ q1 = new Query_();
			query.setQuery(q1);
			if (query.getQuery().getBool() == null) {
				query.getQuery().setBool(new Bool());
			}
			query.getQuery().getBool().getMust().add(must);
		}
		if (extends_ != null && !extends_.equals("")) {
			Must must = new Must();
			must.getMatch().setCodeClassExtends(extends_);
			Query_ q1 = new Query_();
			query.setQuery(q1);
			if (query.getQuery().getBool() == null) {
				query.getQuery().setBool(new Bool());
			}
			query.getQuery().getBool().getMust().add(must);
		}

		else

		if (projectName != null && !projectName.equals("")) {
			Query_ q1 = new Query_();
			Filtered filtered = new Filtered();
			Filter filter = new Filter();
			Type type = new Type();
			type.setValue("projects");
			filter.setType(type);
			filtered.setFilter(filter);
			query.setQuery(q1);
			q1.setFiltered(filtered);
			Query_ q = new Query_();
			Match match = new Match();
			match.setName(projectName);
			q.setMatch(match);
			filtered.setQuery(q);
			// query.setFiltered(filtered);
		} else if (code != null && !code.equals("")) {
			Query_ q1 = new Query_();
			query.setQuery(q1);
			if (query.getQuery().getMatch() == null) {
				Match match = new Match();
				query.getQuery().setMatch(match);
			}
			query.getQuery().getMatch().setAnalyzedcontent(code);
		}
		Gson gson = new Gson();
		String json = gson.toJson(query);

		return json;
	}

	public static Agora queryAgora(String query) {
		Agora response = null;
		HttpURLConnection conn = null;
		try {

			URL url = new URL("http://155.207.19.236:9200/_search");
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			OutputStream os = conn.getOutputStream();
			os.write(query.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String thisLine = null;
			String json = "";
			while ((thisLine = br.readLine()) != null) {
				System.out.println(thisLine);
				json = json + thisLine;
			}

			conn.disconnect();
			String jsonResponse = json;
			Gson gson = new Gson();
			response = gson.fromJson(jsonResponse, Agora.class);
		} catch (Exception e) {

			e.printStackTrace();
			conn.disconnect();
		}

		return response;
	}

	static public ArrayList<OSRF> parseResponse(Agora agora) {
		ArrayList<OSRF> response = new ArrayList<OSRF>();
		for (int i = 0; i < agora.getHits().getHits().size(); i++) {
			OSRF res = new OSRF();
			Hit hit = agora.getHits().getHits().get(i);
			res.setSimilarityScore(hit.getScore().toString());
			res.setUrl(hit.getSource().getUrl());
			res.setClassName(hit.getSource().getName());
			res.setForge(Forges.GITHUB);
			res.setProjectName(hit.getSource().getProject());
			if ((res.getProjectName() == null || res.getProjectName()
					.equals("")) && !res.getClassName().equals("")) {
				res.setProjectName(res.getClassName());
				res.setClassName(null);
			}
			res.setSourceCode(hit.getSource().getAnalyzedcontent());
			response.add(res);
		}
		return response;
	}

	public static void main(String[] args) {

		try {

			URL url = new URL("http://155.207.19.236:9200/_search");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"filtered\":{\"query\":{\"match\":{\"analyzedcontent\":\"DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();\"}}}}";
			// String
			// input="{\"query\":{\"match\":{\"analyzedcontent\":\"DocumentBuilderFactory\"}}}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			os.close();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String thisLine = null;
			String json = "";
			while ((thisLine = br.readLine()) != null) {
				System.out.println(thisLine);
				json = json + thisLine;
			}

			conn.disconnect();
			Gson gson = new Gson();

			// convert the json string back to object
			Agora obj = gson.fromJson(json, Agora.class);

			System.out.println(obj);
			br.close();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
