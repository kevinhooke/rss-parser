package kh.rssparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import kh.rssparser.model.Item;
import kh.rssparser.model.Rss;

public class RssParserTest {

	@Test
	public void testLoadRssUrl1() throws JsonParseException, JsonMappingException, URISyntaxException, IOException {
		RssParser parser = new RssParser();
		
		URL url = new File("src/test/resources/example1-sarc.rss").toURI().toURL();
		
		Rss rss = parser.parseRssFromUrl(url);
		assertNotNull(rss);
		assertNotNull(rss.getChannel());
		assertNotNull(rss.getChannel().getItem());
		List<Item> titles = rss.getChannel().getItem();
		
		assertEquals(2, titles.size());
		assertEquals("This is title 1", titles.get(0).getTitle());
		assertEquals("This is title 2", titles.get(1).getTitle());
	}

	@Test
	public void testLoadRssUrl2() throws JsonParseException, JsonMappingException, URISyntaxException, IOException {
		RssParser parser = new RssParser();
		
		URL url = new File("src/test/resources/example2-arn.rss").toURI().toURL();
		
		Rss rss = parser.parseRssFromUrl(url);
		assertNotNull(rss);
		assertNotNull(rss.getChannel());
		assertNotNull(rss.getChannel().getItem());
		List<Item> titles = rss.getChannel().getItem();
		
		assertEquals(3, titles.size());
		assertEquals("News for Friday August 13, 2021", titles.get(0).getTitle());
		assertEquals("News for Friday August 6, 2021", titles.get(1).getTitle());
		assertEquals("News for Friday July 30, 2021", titles.get(2).getTitle());
		
		
		
	}

	
}
