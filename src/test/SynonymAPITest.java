package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.SynonymAPI;

public class SynonymAPITest {
	
	private SynonymAPI api;

	@Before
	public void setUp() throws Exception {
		api = new SynonymAPI();
	}

	@Test
	public void testGetSynonymsTest() {
		List<String> synonyms = api.getSynonyms("test");
		assertTrue(synonyms.size() > 4);
		assertTrue(synonyms.contains("trial"));
	}

}
