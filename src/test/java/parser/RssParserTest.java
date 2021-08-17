package parser;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import kh.rssparser.RssParser;
import kh.rssparser.model.Rss;

public class RssParserTest {

	@Test
	public void testLoadRssUrl() throws JsonParseException, JsonMappingException, URISyntaxException, IOException {
		RssParser parser = new RssParser();
		
		Rss rss = parser.parseRss("http://url.to.rss/here");
		assertNotNull(rss);
		assertNotNull(rss.getChannel());
		assertNotNull(rss.getChannel().getItem());
	}
	
}
