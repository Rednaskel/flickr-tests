package api.helper;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import java.util.List;

public class FlickrApiHelper {
	
	public FlickrApiHelper(){
		RestAssured.baseURI = "https://api.flickr.com";
		RestAssured.basePath = "/services/feeds/photos_public.gne";
	}
	
	public List<String> getTitlesFromJsonResponse(String query) throws Exception {		
		JsonPath response = getJsonFromQuery(query);
		return response.get("items.title");
	}
	
	public List<String>getTitlesFromXmlResponse(String query) throws Exception {
		XmlPath response = getXmlFromQuery(query);
		response.setRoot("feed");
		return response.getList("entry.title");
	}
	
	private JsonPath getJsonFromQuery(String query) throws Exception {
		return this.getResponseFromQuery("json", query).jsonPath();
	}
	
	private XmlPath getXmlFromQuery(String query) throws Exception {
		return this.getResponseFromQuery("xml", query).xmlPath();
	}
	
	@SuppressWarnings("rawtypes")
	private ResponseBody getResponseFromQuery(String format, String query) throws Exception {
			Response response = RestAssured.get("?format=" + format + 
					"&nojsoncallback=1&tags=" + query);
			if(response.getStatusCode()!= 200) {
				throw new Exception("Query failed with code " + response.getStatusCode());
			}
			return response.getBody();
			
	}
}
