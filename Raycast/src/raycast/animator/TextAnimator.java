package raycast.animator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * this class handles the job of drawing on the canvas.
 * 
 * @author Gabriel Araujo
 * @version Jan 13, 2019
 */
public class TextAnimator extends AbstractAnimator {

	@Override
	void handle(long now, GraphicsContext gc) {
		gc.save();
		Font f = Font.font(gc.getFont().getFamily(), FontWeight.BLACK, 50);
		gc.setFont(f);
		gc.setFill(Color.BLACK);
		gc.fillText("Gabriel Araujo", mouse.x(), mouse.y());
		gc.setStroke(Color.WHITE);
		gc.strokeText("Gabriel Araujo", mouse.x(), mouse.y());
		gc.restore();
	}

	@Override
	public String toString() {
		return "Text animator";
	}
}
