package objects;

import java.awt.Graphics;
import java.awt.Point;

public class AssociationLine extends ConnectionLine {

	public AssociationLine(int depth, Point startPoint, Point endPoint) {
		super(depth, startPoint, endPoint);
	}

	@Override
	public void draw(Graphics graphics) {
		int x1 = startPoint.x;
		int y1 = startPoint.y;
		int x2 = endPoint.x;
		int y2 = endPoint.y;
		
		graphics.drawLine(x1, y1, x2, y2);
		
		double h = 20; //arrow height
		int dx = x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx*dx + dy*dy);
		double px = x2-h*dx/D;
		double py = y2-h*dy/D;
		
		
		double sin = Math.sin(Math.PI/5), cos = Math.cos(Math.PI/5);
		double a1x = x2 + (cos*(px-x2) - sin*(py-y2));
		double a1y = y2 + (sin*(px-x2) + cos*(py-y2));
		
		sin = Math.sin(-1*Math.PI/5);
		cos = Math.cos(-1*Math.PI/5);
		double a2x = x2 + (cos*(px-x2) - sin*(py-y2));
		double a2y = y2 + (sin*(px-x2) + cos*(py-y2));
		
		graphics.drawLine(x2, y2, (int)a1x, (int)a1y);
		graphics.drawLine(x2, y2, (int)a2x, (int)a2y);
	}

}
