package objects;

import java.awt.*;

public abstract class ConnectionLine extends BaseObject {
	
	protected Point startPoint,endPoint;
	
	ConnectionLine(int depth, Point startPoint, Point endPoint) {
		super(depth);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public void moveStartPoint(Point moveVector) {
		startPoint.x += moveVector.x;
		startPoint.y += moveVector.y;
	}
	
	public void moveEndPoint(Point moveVector) {
		endPoint.x += moveVector.x;
		endPoint.y += moveVector.y;
	}
	
}
