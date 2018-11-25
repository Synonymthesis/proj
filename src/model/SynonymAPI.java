package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.lang.StringBuilder;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codesnippets4all.json.parsers.JSONParser;
import com.codesnippets4all.json.parsers.JsonParserFactory;

public class SynonymAPI {
	
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
		
		JsonParserFactory factory=JsonParserFactory.getInstance();
        JSONParser parser=factory.newJsonParser();
        Map jsonData=parser.parseJson(synStr);
        List al= (List) jsonData.get("root");
        for (int i = 0; i < al.size(); i++) {
        	synonyms.add((String) ((Map)al.get(i)).get("word"));
        }
        return synonyms;
	}
	
	public boolean checkSynonym(String prompt, String answer) {
		List<String> arr = this.getSynonyms(prompt);
		System.out.println(arr);
		return (arr.contains(answer));
	}

}
