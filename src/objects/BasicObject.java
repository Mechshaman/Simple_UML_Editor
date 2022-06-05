package objects;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class BasicObject extends BaseObject {
	
	protected Point position;
	protected int width, height;
	protected Point leftPort,rightPort,upPort,downPort;
	protected int portWidth, portHeight;
	protected String name;
	protected List<ConnectionLine> outConnectionLineList;
	protected List<ConnectionLine> inConnectionLineList;
	
	BasicObject(int depth, Point position, int width, int height, String name) {
		super(depth);
		this.position = position;
		this.width = width;
		this.height = height;
		this.name = name;
		portWidth = 10;
		portHeight = 10;
		leftPort = new Point(position.x, position.y + height/2);
		rightPort = new Point(position.x + width, position.y + height/2);
		upPort = new Point(position.x + width/2, position.y);
		downPort = new Point(position.x + width/2, position.y + height);
		outConnectionLineList = new ArrayList<ConnectionLine>();
		inConnectionLineList = new ArrayList<ConnectionLine>();
		selected = false;
	}
	
	@Override
	public boolean pointOnObject(Point point) {
		if(point.x < position.x) { return false; }
		if(point.x > (position.x + width)) { return false; }
		if(point.y < position.y) { return false; }
		if(point.y > (position.y + height)) { return false; }
		return true;
	}
	
	@Override
	public boolean objectInZone(Point point1, Point point2) {
		assert (point1.x <= point2.x) ; 
		if(point1.x > position.x) { return false; }
		if(point1.y > position.y) { return false; }
		if(point2.x < (position.x + width)) { return false; }
		if(point2.y < (position.y + height)) { return false; }
		return true;
	}
	
	@Override
	public void move(Point moveVector) {
		movePoint(position, moveVector);
		movePoint(leftPort, moveVector);
		movePoint(rightPort, moveVector);
		movePoint(upPort, moveVector);
		movePoint(downPort, moveVector);
		
		ListIterator<ConnectionLine> it = outConnectionLineList.listIterator();
		while (it.hasNext()) {
			ConnectionLine line = it.next();
			line.moveStartPoint(moveVector);
		} 
		
		it = inConnectionLineList.listIterator();
		while (it.hasNext()) {
			ConnectionLine line = it.next();
			line.moveEndPoint(moveVector);
		} 
	}
	
	@Override
	public void rename(String newName) {
		name = newName;
	}
	
	@Override
	public Point connectPort(Point point) {
		if(pointOnObject(point)) {
			return findClosestPort(point);
		};
		return null;
	}
	
	protected void drawPort(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(leftPort.x - portWidth/2, leftPort.y - portHeight/2, portWidth, portHeight);
		graphics.fillRect(rightPort.x - portWidth/2, rightPort.y - portHeight/2, portWidth, portHeight);
		graphics.fillRect(upPort.x - portWidth/2, upPort.y - portHeight/2, portWidth, portHeight);
		graphics.fillRect(downPort.x - portWidth/2, downPort.y - portHeight/2, portWidth, portHeight);
	}
	
	private Point findClosestPort(Point point) {
		Point closestPort = leftPort;
		double distance = Point2D.distance(point.x, point.y, leftPort.x, leftPort.y);
		
		if(Point2D.distance(point.x, point.y, rightPort.x, rightPort.y) < distance) {
			closestPort = rightPort;
			distance = Point2D.distance(point.x, point.y, rightPort.x, rightPort.y);
		}
		if(Point2D.distance(point.x, point.y, upPort.x, upPort.y) < distance) {
			closestPort = upPort;
			distance = Point2D.distance(point.x, point.y, upPort.x, upPort.y);
		}
		if(Point2D.distance(point.x, point.y, downPort.x, downPort.y) < distance) {
			closestPort = downPort;
			distance = Point2D.distance(point.x, point.y, downPort.x, downPort.y);
		}
		
		return closestPort;
	}
	
	private void movePoint(Point point, Point moveVector) {
		point.x += moveVector.x;
		point.y += moveVector.y;
	}
	
}
