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

public class LeaderboardDatabase {

	private static final Logger LOGGER = Logger.getLogger(WordPrompt.class.getName());
	private static final String DEFAULT_FILENAME = "src/model/leaderboard.json";
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
	
	public Map<String, Integer> getScores() {
		return scores;
	}
	
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
