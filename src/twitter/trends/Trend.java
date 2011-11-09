package twitter.trends;

public class Trend {
	private String events;
	private String url;
	private String query;
	private String name;
	private String promoted_content;
	
	public String getEvents(){
		return events;
	}
	
	public String getURL(){
		return url;
	}
	
	public String getQuery(){
		return query;
	}
	
	public String getTrend(){
		return name;
	}
	
	public String getPromotedContent(){
		return promoted_content;
	}
}
