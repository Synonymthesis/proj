package model;

public class Player {
	private String name;
	private int totalScore = 0;
	private int level = 1;
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

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
