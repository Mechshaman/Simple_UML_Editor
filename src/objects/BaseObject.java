package objects;

import java.awt.*;
import java.util.List;

public abstract class BaseObject {
	
	protected int depth;
	protected boolean selected;
	
	BaseObject(int depth) {
		this.depth = depth;
		selected = false;
	}
	
	public abstract void draw(Graphics graphics);
	public boolean pointOnObject(Point point) { return false; };
	public boolean objectInZone(Point point1, Point point2) { return false; };
	public void setSelected() { selected = true; }
	public void cancelSelected() { selected = false; }
	public boolean getSelected() { return selected; }
	public void move(Point moveVector) {};
	public void rename(String newName) {};
	public int getDepth() { return depth; }
	public void resetDepth(int depth) { this.depth = depth; }
	public Point connectPort(Point point) { return null; }
	public List<BaseObject> getObjectList() { return null; };
	
}
