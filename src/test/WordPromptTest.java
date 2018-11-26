package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.SynonymAPI;
import model.WordPrompt;

public class WordPromptTest {

	private WordPrompt prompt;
	private SynonymAPI api;

	@Before
	public void setUp() {
		prompt = new WordPrompt();
		api = new SynonymAPI();
	}
	
	@Test
	public void testConstructor() {
		assertTrue(prompt.easyWords.size() >0 &&
				 prompt.medWords.size()>0 &&
				 prompt.hardWords.size()>0);
	}

	@Test
	public void testGetWordsEasy() {
		//easy,bad,fun,fat,test,say
		//medium,describe,famous,important,beautiful
		//hard, Mischievous, lucky, angry
		int level = 1;
		String word = prompt.getWord(level);
		
		List<String> synonyms = api.getSynonyms("test");
		assertTrue(word.length() <= 4);
		assertTrue(synonyms.contains("trial"));
	}
	
	@Test
	public void testGetWordsMedium() {
		//easy,bad,fun,fat,test,say
		//medium,describe,famous,important,beautiful
		//hard, Mischievous, lucky, angry
		int level = 1;
		String word = prompt.getWord(level);
		
		List<String> synonyms = api.getSynonyms("beautiful");
		assertTrue(word.length() <= 4);
		assertTrue(synonyms.contains("pretty"));
	}

}
