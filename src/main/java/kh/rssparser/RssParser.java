package kh.rssparser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	/**
	 * Extracts a list of String titles from RSS feeds where the titles are summarized in a single
	 * RSS description element. For example:
	 * <pre>
	 * <title><description><p class=""> - BREAKING NEWS: item1<br> - item2 aaa bbb ccc ddd<br> - item3 aaa bbb ccc ddd<br> - item3 aaa bbb ccc ddd</p><p class=""><a href="https://example.link">SCRIPT</a></p><p class=""><a href="https://example.com/example.mp3">AUDIO</a></p></description></title> 
	 * </pre>
	 * @param text
	 * @return
	 */
	public List<String> extractStringsFromDescription(String text){
		List<String> titles = new ArrayList<>();
		text = text.trim();

		//remove leading 
		text = text.replaceAll("<p class=\\\"\\\">", "");
		
		//remove everything after the last <a> link
		text = text.replaceAll("<a href=.*", "");
		
		//remove <br> on each item
		text = text.replaceAll("<br>", "");
		
		//remove remaining </p>
		text = text.replaceAll("</p>", "");
		
		//remove first token to avoid getting an empty string s first item on left of token
		text = text.replaceFirst(" \\- ", "");
		
		String[] titlesToParse = text.split(" - ");
		
		titles = Arrays.asList(titlesToParse);
				
		return titles;
	}
	
}
