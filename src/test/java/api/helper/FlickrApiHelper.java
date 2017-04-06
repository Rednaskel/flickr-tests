package api.helper;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.ResponseBody;

import java.util.List;

public class FlickrApiHelper {
	
	public FlickrApiHelper(){
		RestAssured.baseURI = "https://api.flickr.com";
		RestAssured.basePath = "/services/feeds/photos_public.gne";
	}
	
	public List<String> getTitlesFromJsonResponse(String query) {		
		JsonPath response = getJsonFromQuery(query);
		return response.get("items.title");
	}
	
	public List<String>getTitlesFromXmlResponse(String query) {
		XmlPath response = getXmlFromQuery(query);
		response.setRoot("feed");
		return response.getList("entry.title");
	}
	
	private JsonPath getJsonFromQuery(String query) {
		return this.getResponseFromQuery("json", query).jsonPath();
	}
	
	private XmlPath getXmlFromQuery(String query) {
		return this.getResponseFromQuery("xml", query).xmlPath();
	}
	
	@SuppressWarnings("rawtypes")
	private ResponseBody getResponseFromQuery(String format, String query) {
			return RestAssured.get("?format=" + format + 
					"&nojsoncallback=1&tags=" + query).getBody();
	}
}
