package model;

public class Player {
	private String name;
	private int totalScore = 0;
	
	public void incrementScore(int inc) {
		totalScore += inc;
	}
	
	public int getScore() {
		return totalScore;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
