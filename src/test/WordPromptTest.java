package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.WordPrompt;

public class WordPromptTest {

	private WordPrompt prompt;

	@Before
	public void setUp() {
		prompt = new WordPrompt();
	}
	
	@Test
	public void testConstructor() {
		assertTrue(prompt.easyWords.size() >0 &&
				 prompt.medWords.size()>0 &&
				 prompt.hardWords.size()>0);
	}

	@Test
	public void testGetWordsTest() {
		//easy,bad,fun,fat,test,say
		//medium,describe,famous,important,beautiful
		//hard, Mischievous, lucky, angry
		int level = 1;
		String word = prompt.getWord(level);
		System.out.println(word);
		assertTrue(word.length() <= 4);
		//assertTrue(synonyms.contains("trial"));
	}

}
