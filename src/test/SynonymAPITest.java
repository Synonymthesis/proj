package test;

import static org.junit.Assert.assertFalse;
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
		
		List<String> synonyms = api.getSynonyms("test");
		assertFalse(synonyms.isEmpty());
		assertTrue(synonyms.contains("trial"));
	}
	
	@Test
	public void testCheckSynonym() {
		boolean b = api.checkSynonym("test", "trial");
		assertTrue(b);
	}

}
