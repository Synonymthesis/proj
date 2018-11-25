package test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.*;

import model.SynonymAPI;

public class SynonymAPITest {
	
	private SynonymAPI api;

	@Before
	public void setUp() {
		api = new SynonymAPI();
	}

	@Test
	public void testGetSynonymsTest() {
		//easy,bad,fun,fat,test,say
		//medium,describe,famous,important,beautiful
		//hard, Mischievous, lucky, angry
		
		List<String> synonyms = api.getSynonyms("fast");
		System.out.println(synonyms);
		assertTrue(synonyms.size() > 0);
		//assertTrue(synonyms.contains("trial"));
	}

}
