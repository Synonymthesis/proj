package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordPrompt {
	
	private int EASYLENGTH = 4;
	private int MEDLENGTH = 7;
	
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
        try {
        	File f = new File(fileName);
        	//System.out.println(f.getAbsolutePath());
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(f.getAbsolutePath() );
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
            	if (line.length() <= EASYLENGTH){
            		easyWords.add(line);
            	}
            	else if (line.length() <= MEDLENGTH)
            		medWords.add(line);
            	else
            		hardWords.add(line);
            }   
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to find file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'"); 
        }
    }

	public String getWord(int level) {
		if (level==1) {
			try {
				return easyWords.remove(0);
			}catch(IndexOutOfBoundsException ex) {
				System.err.println("No more words left in the easy level");
			}
		}
		else if (level ==2) {
			try {
				return medWords.remove(0);
			}catch(IndexOutOfBoundsException ex) {
				System.err.println("No more words left in the med level");
			}
		}
		try {
			return hardWords.remove(0);
		}catch(IndexOutOfBoundsException ex) {
			System.err.println("No more words left in the hard level");
		}
		return "default";
	}
}
