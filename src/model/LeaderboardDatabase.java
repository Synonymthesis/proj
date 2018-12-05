package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * This class is used for retaining leaderboard/history information for the current user/device.
 * The current leaderboard is stored in a json encoded file and each time a new leaderboard database object is created,
 * the file is updated.
 * 
 * Use:
 *    * create a new LeaderboardDatabase object for use throughout the app (as long as you only
 *      have one at a time there is no issue if you just create new ones)
 *    * the scores map is a map from String names to Integer scores
 */
public class LeaderboardDatabase {

	private static final Logger LOGGER = Logger.getLogger(WordPrompt.class.getName());
	private static final String DEFAULT_FILENAME = "src/model/leaderboard.json";
	
	private static LeaderboardDatabase instance;
	private Map<String, Integer> scores;
	
	private String filename;
	
	public LeaderboardDatabase() {
		this(DEFAULT_FILENAME);
	}
	
	/* This constructor should be only called directly for testing and debugging. */
	public LeaderboardDatabase(String filename) {
		this.filename = filename;
		scores = new HashMap<>();
		JSONParser parser = new JSONParser();
        JSONArray jsonData;
		try {
            jsonData = (JSONArray) (parser.parse(new FileReader(filename)));
	        for (Object element : jsonData) {
	        	Object name = ((JSONObject)element).get("name");
	        	Object score = ((JSONObject)element).get("score");
	        	if (name instanceof String && score instanceof Long) {
	        		scores.put((String)name, ((Long)score).intValue());
	        	}
	        }
        } catch (IOException|ParseException e) {
            LOGGER.log(Level.WARNING, e.toString());
        }
	}
	
	public static synchronized LeaderboardDatabase getInstance() {
		if (instance == null) {
			instance = new LeaderboardDatabase();
		}
		
		return instance;
	}

		
	public static synchronized LeaderboardDatabase getInstance(String filename) {
		if (instance == null) {
			instance = new LeaderboardDatabase(filename);
		}
		
		return instance;
	}
	public static synchronized LeaderboardDatabase newInstance() {
		instance = new LeaderboardDatabase();
		
		return instance;
	}

		
	public static synchronized LeaderboardDatabase newInstance(String filename) {
		instance = new LeaderboardDatabase(filename);
		
		return instance;
	}
	
	/* 
	 * Returns the map of names to scores.
	 */
	public Map<String, Integer> getScores() {
		return scores;
	}
	
	/*
	 * Saves a new score pair. 2 arguments are the String name/username and the int score that they earned.
	 */
	public void saveScore(String name, int score) {
		scores.put(name, score);
		
		JSONArray scoresList = scoresToJSON();

        try (FileWriter file = new FileWriter(filename)) {
            file.write(scoresList.toJSONString());
            file.flush();

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.toString());
        }
	}
	
	/*
	 * Helper method for saving scores to the database.
	 */
	private JSONArray scoresToJSON() {
		JSONArray scoresList = new JSONArray();
		
		for (Map.Entry<String,Integer> entry : scores.entrySet()) {
			JSONObject score = new JSONObject();
			score.put("name", entry.getKey());
			score.put("score", entry.getValue());
			scoresList.add(score);
		}
		
		return scoresList;
	}

}
