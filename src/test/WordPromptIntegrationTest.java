package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.SynonymAPI;
import model.WordPrompt;

/* Calantha Tu */
public class WordPromptIntegrationTest {

	private WordPrompt prompt;

	@Before
	public void setUp() {
		prompt = new WordPrompt();
	}

	@Test
	public void testGetWordsEasy() {
		int level = 1;
		String word = prompt.getWord(level);
		List<String> synonyms = SynonymAPI.getSynonyms("test");
		assertTrue(word.length() <= 4);
		assertTrue(synonyms.contains("trial"));
	}
	
	@Test
	public void testGetWordsMedium() {
		int level = 2;
		String word = prompt.getWord(level);
		
		List<String> synonyms = SynonymAPI.getSynonyms("beautiful");
		assertTrue(word.length() > 4);
		assertTrue(word.length() <= 7);
		assertTrue(synonyms.contains("pretty"));
	}
	
	@Test
	public void testGetWordsHard() {
		int level = 3;
		String word = prompt.getWord(level);
		
		List<String> synonyms = SynonymAPI.getSynonyms("mischievous");
		assertTrue(word.length() > 7);
		assertTrue(synonyms.contains("bad"));
	}

}
