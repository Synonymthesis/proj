package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Player;

/* Daniel Wong */
public class PlayerTest {
	
	@Test
	public void testLevel() {
		Player p = new Player();
		assertEquals(p.getLevel(), 1);
	}
	
	@Test
	public void testScore() {
		Player p = new Player();
		assertEquals(p.getScore(), 0);
	}
	
	@Test
	public void testName() {
		Player p = new Player();
		p.setName("Frodo");
		assertEquals(p.getName(), "Frodo");
	}
	
	@Test
	public void testSetLevel() {
		Player p = new Player();
		p.setLevel(3);
		assertEquals(p.getLevel(), 3);
	}
	
	@Test
	public void testIncScore() {
		Player p = new Player();
		p.incrementScore(1);
		assertEquals(p.getScore(), 1);
	}
	
	
}
