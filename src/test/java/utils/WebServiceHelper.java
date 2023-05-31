package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;


public class WebServiceHelper {
	
	private JSONObject doRequest(String method, String baseUrl, String endpoint) {
		try {
			URL url = new URL(baseUrl+endpoint);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod(method);
			
			Logger.log("Se ejecuta request:");
			Logger.log("URL: " + baseUrl);
			Logger.log("ENDPOINT: " + endpoint);
			Logger.log("METHOD: " + endpoint);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder content = new StringBuilder();
			while ((inputLine = reader.readLine()) != null) {
				content.append(inputLine);
			}
			reader.close();
			
			JSONObject jsonResponse = new JSONObject(content.toString());
			
			con.disconnect();
			
			return jsonResponse;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public JSONObject doGetRequest(String baseUrl, String endpoint) {
		return this.doRequest("GET", baseUrl, endpoint);
	}
}
