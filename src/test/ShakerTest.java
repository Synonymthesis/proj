package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Shaker;

/* Stephanie Carpintero */
public class ShakerTest {
	
	private Shaker shaker;
	
	@Before
	public void setUp() {
		shaker = new Shaker(null);
	}

	@Test
	public void testCheckReverse() {
		TranslateTransition t = shaker.getTt();
		assertTrue(t.isAutoReverse());
	}
	
	

}
