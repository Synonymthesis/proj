package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codesnippets4all.json.parsers.JSONParser;
import com.codesnippets4all.json.parsers.JsonParserFactory;

public class SynonymAPI {
	
	public List<String> getSynonyms(String word) {
		URL datamuse;
        URLConnection dc;
        StringBuilder s = null;
        
        try {
            datamuse = new URL("http://api.datamuse.com/words?rel_syn=" + word);
            dc = datamuse.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(dc.getInputStream(), "UTF-8"));
            String inputLine;
            s = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                s.append(inputLine);
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s != null ? synonymArray(s.toString()) : null;
	}
	
	public List<String> synonymArray(String synStr) {
		List<String> synonyms = new ArrayList<String>();
		
		JsonParserFactory factory=JsonParserFactory.getInstance();
        JSONParser parser=factory.newJsonParser();
        Map jsonData=parser.parseJson(synStr);
        List al= (List) jsonData.get("root");
        for (int i = 0; i < al.size(); i++) {
        	synonyms.add((String) ((Map)al.get(i)).get("word"));
        }
        return synonyms;
	}

}
