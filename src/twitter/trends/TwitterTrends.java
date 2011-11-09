package twitter.trends;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class TwitterTrends {
	// documentation: https://dev.twitter.com/docs/api/1/get/trends/%3Awoeid
	private static String TRENDS_API = "https://api.twitter.com/1/trends/1.json";

	public String getAPICall() {
		return TRENDS_API;
	}

	public ArrayList<String> makeAPICall() throws Exception {
		// create a URL from the API call
		URL apiCall = new URL(TRENDS_API);

		// create a reader from the call
		BufferedReader in = new BufferedReader(new InputStreamReader(
				apiCall.openStream()));

		// make a list of strings to store the response
		ArrayList<String> response = new ArrayList<String>();

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			response.add(inputLine);

		// close the reader
		in.close();

		return response;
	}

	public static void main(String[] args) throws Exception {
		TwitterTrends trends = new TwitterTrends();

		// make the api call and store the response
		ArrayList<String> responseString = trends.makeAPICall();

		// check the response string. The API call should just return one line 
		// in JSON format representing the data.
		if (responseString.size() == 1) {
			String json = responseString.get(0);
			// Create the response object from the JSON string representation
			TrendResponse response = new TrendResponse(json);
			response.printTrends();
		} else {
			// something is wrong with the response
			throw new Exception("Unexpected response from API call.");
		}
	}
}
