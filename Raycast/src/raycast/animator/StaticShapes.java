package raycast.animator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import raycast.entity.geometry.PolyShape;

/**
 * this class handles the job of drawing on the canvas.
 * 
 * @author Gabriel Araujo
 * @version Jan 13, 2019
 */

public class StaticShapes extends AbstractAnimator {

	private static final Color BACKGROUND = Color.BISQUE;

	@Override
	public void handle(long now, GraphicsContext gc) {
		clearAndFill(gc, BACKGROUND);
		for (PolyShape s : map.shapes()) {
			s.getDrawable().draw(gc);
		}
	}

	@Override
	public String toString() {
		return "Single Source Mouse Rays";
	}
}
