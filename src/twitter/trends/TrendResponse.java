package twitter.trends;

import com.google.gson.Gson;

public class TrendResponse {
	private String as_of;
	private Location[] locations;
	private Trend[] trends;
	private String created_at;

	public TrendResponse(String json) throws Exception {
		// Use GSON parser to parse json into a java object
		Gson gson = new Gson();
		TrendResponse[] response = gson.fromJson(json, TrendResponse[].class);

		// the API returns an object inside a list which holds all the
		// information
		// so we grab the first item
		if (response.length == 1) {
			as_of = response[0].as_of;
			locations = response[0].locations;
			trends = response[0].trends;
			created_at = response[0].created_at;
		} else {
			throw new Exception(
					"JSON was returned in a different format than expected.");
		}
	}

	public Location[] getLocations() {
		return locations;
	}
	
	public Trend[] getTrends() {
		return trends;
	}

	public void printTrends() {
		// print out the location and trends associated with it.
		if (locations.length == 1) {
			System.out.println(String.format("Showing Top 10 Trends in: %s",
					locations[0].getLocation()));
			for (Trend trend : trends) {
				System.out.println(String.format("\t%s", trend.getTrend()));
			}
		}
	}
}
