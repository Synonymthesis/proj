package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import model.Shaker;
import model.WordPrompt;

public class ShakerTest {
	
	private Shaker shaker;
	@FXML
    private TextField t1;
	
	@Before
	public void setUp() {
		shaker = new Shaker(t1);
	}

	@Test
	public void testCheckReverse() {
		TranslateTransition t = shaker.getTt();
		assertTrue(t.isAutoReverse());
	}
	
	

}
