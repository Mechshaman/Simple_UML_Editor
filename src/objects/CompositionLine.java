package objects;

import java.awt.Graphics;
import java.awt.Point;

public class CompositionLine extends ConnectionLine {
	
	public CompositionLine(int depth, Point startPoint, Point endPoint) {
		super(depth, startPoint, endPoint);
	}
	
	@Override
	public void draw(Graphics graphics) {
		int x1 = startPoint.x;
		int y1 = startPoint.y;
		int x2 = endPoint.x;
		int y2 = endPoint.y;
		
		double h = 15; //arrow height
		int dx = x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx*dx + dy*dy);
		double px = x2-h*dx/D;
		double py = y2-h*dy/D;
		double p2x = px-0.5*h*dx/D;
		double p2y = py-0.5*h*dy/D;
		
		double sin = Math.sin(Math.PI/4), cos = Math.cos(Math.PI/4);
		double a1x = x2 + (cos*(px-x2) - sin*(py-y2));
		double a1y = y2 + (sin*(px-x2) + cos*(py-y2));
		
		sin = Math.sin(-1*Math.PI/4);
		cos = Math.cos(-1*Math.PI/4);
		double a2x = x2 + (cos*(px-x2) - sin*(py-y2));
		double a2y = y2 + (sin*(px-x2) + cos*(py-y2));
		
		graphics.drawLine(x2, y2, (int)a1x, (int)a1y);
		graphics.drawLine(x2, y2, (int)a2x, (int)a2y);
		graphics.drawLine((int)p2x, (int)p2y, (int)a1x, (int)a1y);
		graphics.drawLine((int)p2x, (int)p2y, (int)a2x, (int)a2y);
		graphics.drawLine(x1, y1, (int)p2x, (int)p2y);
	}

}
