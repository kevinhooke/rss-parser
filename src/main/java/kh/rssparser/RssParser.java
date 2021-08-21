package kh.rssparser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import kh.rssparser.model.Rss;

public class RssParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Rss parseRss(String rssUri) throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
		URL url = new URL(rssUri);
		Rss rss = this.parseRssFromUrl(url);
		return rss;
	}
	
	Rss parseRssFromUrl(URL url) throws JsonParseException, JsonMappingException, IOException {
		XmlMapper mapper = new XmlMapper();
		Rss rss = mapper.readValue(url, Rss.class);
		
		return rss;
	}
}
