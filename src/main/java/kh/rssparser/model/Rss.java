package kh.rssparser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rss {

	//@JacksonXmlProperty(isAttribute = true)
    //private String version;
	
	private Channel channel;
	
	public Rss() {
		
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
}
