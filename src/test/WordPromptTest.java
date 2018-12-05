package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.SynonymAPI;
import model.WordPrompt;

/* Kaysha Chandran */
public class WordPromptTest {

	private WordPrompt prompt;

	@Before
	public void setUp() {
		prompt = new WordPrompt();
	}
	
	@Test
	public void testConstructor() {
		assertTrue(prompt.getEasyWords().size() >0 &&
				 prompt.getMedWords().size()>0 &&
				 prompt.getHardWords().size()>0);
	}

	@Test
	public void testGetWordsEasy() {
		List<String> words = prompt.getEasyWords();
		assertTrue(words.size() > 1);
	}

	@Test
	public void testGetWordsMedium() {
		List<String> words = prompt.getMedWords();
		assertTrue(words.size() > 1);
	}

	@Test
	public void testGetWordsHard() {
		List<String> words = prompt.getHardWords();
		assertTrue(words.size() > 1);
	}

}
