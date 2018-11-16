package model;


public class WordsAPI {
	
	public List<> getSynonyms(String word) {
		HttpResponse<JsonNode> response = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/test/synonyms")
				.header("X-Mashape-Key", "342CVBnz3wmshi4XxeGsUAnChRexp12I3Gljsn4Ksp4qdPbyab")
				.header("X-Mashape-Host", "wordsapiv1.p.rapidapi.com")
				.asJson();
	}

}
