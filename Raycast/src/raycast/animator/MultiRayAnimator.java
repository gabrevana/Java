package raycast.animator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import raycast.entity.geometry.PolyShape;
import utility.IntersectUtil;

/**
 * this class handles the job of drawing on the canvas.
 * 
 * @author Gabriel Araujo
 * @version Jan 13, 2019
 */

public class MultiRayAnimator extends AbstractAnimator {

	private static final Color BACKGROUND = Color.BISQUE;
	private Color lightColor = Color.GREENYELLOW;

	protected double[] intersectPoint = new double[4];
	protected double[] intersectResult = new double[4];

	double endX, endY, rayIncrementer;

	@Override
	public void handle(long now, GraphicsContext gc) {
		clearAndFill(gc, BACKGROUND);
		for (PolyShape s : map.shapes()) {
			s.getDrawable().draw(gc);
		}
		drawRays(gc, mouse.x(), mouse.y(), lightColor);
	}

	public void drawLine(GraphicsContext gc, Color color, double sx, double sy, double ex, double ey) {
		gc.setLineWidth(1);
		gc.setStroke(color);
		gc.setFill(Color.MAGENTA);
		gc.strokeLine(sx, sy, ex, ey);
		if (map.getDrawIntersectPoint()) {
			gc.fillOval(ex - 5, ey - 5, 10, 10);
		}
	}

	public void drawRays(GraphicsContext gc, double startX, double startY, Color lightColor) {
		double endX, endY, rayIncrementer;
		rayIncrementer = 360d / map.getRayCount();

		for (double rayAngel = 0; rayAngel < 360; rayAngel += rayIncrementer) {

			endX = Math.cos(Math.toRadians(rayAngel));
			endY = Math.sin(Math.toRadians(rayAngel));

			for (PolyShape s : map.shapes()) {

				for (int i = 0, j = s.pointCount() - 1; i < s.pointCount(); i++, j = i - 1) {
					boolean doesIntersect = IntersectUtil.getIntersection(intersectResult, startX, startY,
							startX + endX, startY + endY, s.pX(i), s.pY(i), s.pX(j), s.pY(j));

					if (doesIntersect && intersectPoint[2] > intersectResult[2])
						System.arraycopy(intersectResult, 0, intersectPoint, 0, intersectPoint.length);
				}
			}

			drawLine(gc, lightColor, startX, startY, intersectPoint[0], intersectPoint[1]);
			intersectPoint[2] = Double.MAX_VALUE;
		}

	}

	@Override
	public String toString() {
		return "Multi Ray Animator";
	}
}
