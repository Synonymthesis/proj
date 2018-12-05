package model;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shaker {
    private TranslateTransition tt;

    public TranslateTransition getTt() {
		return tt;
	}

	public Shaker(Node node) {
        tt = new TranslateTransition(Duration.millis(50), node);
        tt.setFromX(0f);
        tt.setByX(20f);
        tt.setCycleCount(4);
        tt.setAutoReverse(true);
    }

    public void shake() {
        tt.playFromStart();
    }

}
