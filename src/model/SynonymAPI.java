package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SynonymAPI {
	private static final Logger LOGGER = Logger.getLogger(WordPrompt.class.getName());
	
	public List<String> getSynonyms(String word) {
		URL datamuse;
        URLConnection dc;
        StringBuilder str = new StringBuilder();
        
        try {
            datamuse = new URL("http://api.datamuse.com/words?rel_syn=" + word);
            dc = datamuse.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(dc.getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                str.append(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.length() > 0 ? synonymArray(str.toString()) : null;
	}
	
	public List<String> synonymArray(String synStr) {
		List<String> synonyms = new ArrayList<>();
		
        JSONParser parser = new JSONParser();
        JSONArray jsonData;
		try {
			jsonData = (JSONArray)(parser.parse(synStr));
	        for (Object element : jsonData) {
	        	synonyms.add((String) ((JSONObject)element).get("word"));
	        }
		} catch (ParseException e) {
            LOGGER.log(Level.WARNING, e.toString());
		}
        return synonyms;
	}
	
	public boolean checkSynonym(String prompt, String answer) {
		List<String> arr = this.getSynonyms(prompt);
		return (arr.contains(answer));
	}

}
