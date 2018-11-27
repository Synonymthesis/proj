package model;

import java.io.FileNotFoundException;
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
	private static final String filename = "leaderboard.json";
	private static Map<String, Integer> scores;
	
	public Map<String, Integer> getScores() {
		if (scores == null) {
			JSONParser parser = new JSONParser();
	        JSONArray jsonData;
			try {
	            jsonData = (JSONArray) (parser.parse(new FileReader(filename)));
		        for (Object element : jsonData) {
		        	scores.put((String) ((JSONObject)element).get("word"), (Integer) ((JSONObject)element).get("score"));
		        }
	        } catch (FileNotFoundException e) {
	            LOGGER.log(Level.WARNING, e.toString());
	        } catch (IOException e) {
	            LOGGER.log(Level.WARNING, e.toString());
			} catch (ParseException e) {
	            LOGGER.log(Level.WARNING, e.toString());
			}
		}
		return scores;
	}
	
	public void saveScore(String word, int score) {
		JSONObject obj = new JSONObject();
        obj.put("word", word);
        obj.put("score", score);

        try (FileWriter file = new FileWriter(filename)) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.toString());
        }
	}

}
