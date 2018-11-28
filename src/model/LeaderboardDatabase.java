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
	private static final String FILENAME = "leaderboard.json";
	private Map<String, Integer> scores;
	
	public LeaderboardDatabase() {
		scores = new HashMap<>();
		JSONParser parser = new JSONParser();
        JSONArray jsonData;
		try {
            jsonData = (JSONArray) (parser.parse(new FileReader(FILENAME)));
	        for (Object element : jsonData) {
	        	scores.put((String) ((JSONObject)element).get("word"), (Integer) ((JSONObject)element).get("score"));
	        }
        } catch (IOException|ParseException e) {
            LOGGER.log(Level.WARNING, e.toString());
        }
	}
	
	public Map<String, Integer> getScores() {
		return scores;
	}
	
	public void saveScore(String word, int score) {
		scores.put(word, score);
		
		JSONObject obj = new JSONObject();
        obj.put("word", word);
        obj.put("score", score);

        try (FileWriter file = new FileWriter(FILENAME)) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.toString());
        }
	}

}
