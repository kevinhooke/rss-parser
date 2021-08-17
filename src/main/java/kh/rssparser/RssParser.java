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
		URL uri = new URL(rssUri);
		XmlMapper mapper = new XmlMapper();
		Rss rss = mapper.readValue(uri, Rss.class);
		
		return rss;
	}
}
