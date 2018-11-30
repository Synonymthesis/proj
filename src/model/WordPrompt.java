package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

public class WordPrompt {
	
	private static final Logger LOGGER = Logger.getLogger(WordPrompt.class.getName());
	private static int easyLength = 4;
	private static int medLength = 7;
	
	//public for tests. not sure if this is any good
	public  List<String> easyWords = new ArrayList<>();
	public  List<String> medWords = new ArrayList<>();
	public  List<String> hardWords = new ArrayList<>();
	
	public WordPrompt() {
		this.readWordsFile();
	}
	
	public void readWordsFile() {
        String fileName = "src/model/words.txt";
        String line = null;
        BufferedReader bufferedReader = null;
        try {
        	File f = new File(fileName);
            // Always wrap FileReader in BufferedReader.
            bufferedReader = 
                new BufferedReader(new FileReader(f.getAbsolutePath()));
            while((line = bufferedReader.readLine()) != null) {
            	if (line.length() <= easyLength){
            		easyWords.add(line);
            	}
            	else if (line.length() <= medLength)
            		medWords.add(line);
            	else
            		hardWords.add(line);
            }      
        }
        catch(FileNotFoundException ex) {
            LOGGER.log(Level.WARNING, "Unable to find file '" + fileName + "'");                
        }
        catch(IOException ex) {
        	LOGGER.log(Level.WARNING, "Error reading file '" + fileName + "'"); 
        }
        finally {
        	try {
				bufferedReader.close();
			} catch (IOException e) {
				LOGGER.log(Level.WARNING, "Error closing file '" + fileName + "'");
			}
        }
    }

	public String getWord(int level) {
		if (level==1) {
			try {
				int index = new Random().nextInt(easyWords.size());
				return easyWords.remove(index);
			}catch(IndexOutOfBoundsException ex) {
				LOGGER.log(Level.WARNING, "No more words left in the easy level");
			}
		}
		else if (level ==2) {
			try {
				int index = new Random().nextInt(medWords.size());
				return medWords.remove(index);
			}catch(IndexOutOfBoundsException ex) {
				LOGGER.log(Level.WARNING, "No more words left in the med level");
			}
		}
		try {
			int index = new Random().nextInt(hardWords.size());
			return hardWords.remove(index);
		}catch(IndexOutOfBoundsException ex) {
			LOGGER.log(Level.WARNING, "No more words left in the hard level");
		}
		return "default";
	}
}
