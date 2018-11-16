package model;

import java.util.ArrayList;
import java.util.List;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class WordsAPI {
	
	/*public WordsAPI() {
		Unirest.setObjectMapper(new ObjectMapper() {
		    private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
		                = new com.fasterxml.jackson.databind.ObjectMapper();

		    public <T> T readValue(String value, Class<T> valueType) {
		        try {
		            return jacksonObjectMapper.readValue(value, valueType);
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
		    }

		    public String writeValue(Object value) {
		        try {
		            return jacksonObjectMapper.writeValueAsString(value);
		        } catch (JsonProcessingException e) {
		            throw new RuntimeException(e);
		        }
		    }
		});
	}*/
	
	/* Be careful. This is my (Nicole) personal API key and I will be charged if it is used too much */
	public List<String> getSynonyms(String word) {
		HttpResponse<JsonNode> response = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/test/synonyms")
				.header("X-Mashape-Key", "342CVBnz3wmshi4XxeGsUAnChRexp12I3Gljsn4Ksp4qdPbyab")
				.header("X-Mashape-Host", "wordsapiv1.p.rapidapi.com")
				.asJson();
		
		JsonNode body = response.getBody();
		
		ArrayList<String> synonyms = new ArrayList<String>();
		if (body.isArray()) {
			
		}
		
		return new ;
	}

}
