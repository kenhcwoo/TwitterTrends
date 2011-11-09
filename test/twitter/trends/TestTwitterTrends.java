package twitter.trends;

import java.net.URL;
import java.util.ArrayList;

import twitter.trends.TrendResponse;
import twitter.trends.TwitterTrends;

import junit.framework.*;

public class TestTwitterTrends extends TestCase {
	TwitterTrends trends;
	
	public TestTwitterTrends(String name) {
		super(name);
	}

	public void setUp() {
		trends = new TwitterTrends();
    }

	public void testAPI() throws Exception {	
		String api = trends.getAPICall();
		
		// will throw malformed URL exception if api is incorrect format
		URL apiCall = new URL(api);
		
		// will throw exception if the response code is an error
		apiCall.openStream();
	}
	
	public void testResponse() throws Exception {
		ArrayList<String> responseString = trends.makeAPICall();
		
		// The response should only have one line
		assertEquals(1, responseString.size());
		
		// now parse the response string, any parsing errors will be exceptions
		TrendResponse trends = new TrendResponse(responseString.get(0));
		
		// There should only be one location
		assertEquals(1, trends.getLocations().length);
		
		// There should be 10 trends
		assertEquals(10, trends.getTrends().length);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestTwitterTrends.class);
	}
}
