package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.*;

import model.SynonymAPI;

public class SynonymAPITest {

	@Test
	public void testGetSynonymsTest() {
		List<String> synonyms = SynonymAPI.getSynonyms("test");
		assertFalse(synonyms.isEmpty());
		assertTrue(synonyms.contains("trial"));
	}
	
	@Test
	public void testCheckSynonym() {
		boolean b = SynonymAPI.checkSynonym("test", "trial");
		assertTrue(b);
	}

}
