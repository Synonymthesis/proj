package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.*;

import model.LeaderboardDatabase;
import model.WordPrompt;

public class LeaderboardDatabaseTest {
	
	private static final Logger LOGGER = Logger.getLogger(WordPrompt.class.getName());
	private static final String FILENAME = "src/model/test_leaderboard.json";
	
	private LeaderboardDatabase data;

	@Before
	public void setUp() {
		// Clear the database test file
		PrintWriter writer;
		try {
			writer = new PrintWriter(FILENAME);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
            LOGGER.log(Level.WARNING, e.toString());
		}
		data = new LeaderboardDatabase(FILENAME);
	}
	
	@After
	public void tearDown() {
		// Clear the database test file
		PrintWriter writer;
		try {
			writer = new PrintWriter(FILENAME);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
            LOGGER.log(Level.WARNING, e.toString());
		}
	}

	@Test
	public void testGetEmpty() {
		assertTrue(data.getScores().isEmpty());
	}
	
	@Test
	public void testAddScore() {
		Map<String, Integer> scores = new HashMap<>();
		String name = "Test1";
		int score = 123;
		
		data.saveScore(name, score);
		assertFalse(data.getScores().isEmpty());
		
		scores.put(name, score);
		assertEquals(scores, data.getScores());
	}
	
	@Test
	public void testAddDuplicateNameScore() {
		Map<String, Integer> scores = new HashMap<>();
		String name = "TestA";
		int score = 123;
		String name2 = "TestA";
		int score2 = 345;
		
		data.saveScore(name, score);
		data.saveScore(name2, score2);
		assertFalse(data.getScores().isEmpty());
		
		scores.put(name, score);
		scores.put(name2, score2);
		assertEquals(scores, data.getScores());
	}
	
	@Test
	public void testReadInScores() {
		Map<String, Integer> scores = new HashMap<>();
		String name = "Test2";
		int score = 123;
		
		data.saveScore(name, score);
		assertFalse(data.getScores().isEmpty());
		
		scores.put(name, score);
		assertEquals(scores, data.getScores());
		
		LeaderboardDatabase data2 = new LeaderboardDatabase(FILENAME);
		assertEquals(scores, data2.getScores());
	}
	
	@Test
	public void testWriteManyScores() {
		Map<String, Integer> scores = new HashMap<>();
		String name1 = "Test3";
		int score1 = 123;
		String name2 = "Test4";
		int score2 = 456;
		String name3 = "Test5";
		int score3 = 789;
		
		data.saveScore(name1, score1);
		assertFalse(data.getScores().isEmpty());
		
		scores.put(name1, score1);
		assertEquals(scores, data.getScores());
		
		data.saveScore(name2, score2);
		assertFalse(data.getScores().isEmpty());
		
		scores.put(name2, score2);
		assertEquals(scores, data.getScores());
		
		LeaderboardDatabase data2 = new LeaderboardDatabase(FILENAME);
		assertEquals(scores, data2.getScores());
		
		data2.saveScore(name3, score3);
		assertFalse(data2.getScores().isEmpty());
		
		scores.put(name3, score3);
		assertEquals(scores, data2.getScores());
	}

}
