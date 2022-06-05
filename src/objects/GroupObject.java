package objects;

import java.awt.*;
import java.util.List;
import java.util.ListIterator;

public class GroupObject extends BaseObject {
	
	private List<BaseObject> objectList;
	
	public GroupObject(int depth, List<BaseObject> objectList) {
		super(depth);
		this.objectList = objectList;
	}
	
	@Override
	public void draw(Graphics graphics) {
		ListIterator<BaseObject> it = objectList.listIterator();
		while (it.hasNext()) {
			BaseObject object = it.next();
			object.draw(graphics);
		}
	}

	@Override
	public boolean pointOnObject(Point point) {
		ListIterator<BaseObject> it = objectList.listIterator();
		while (it.hasNext()) {
			BaseObject object = it.next();
			if(object.pointOnObject(point)) {
				return true; 
			}
		} 
		
		return false;
	}
	
	@Override
	public boolean objectInZone(Point p1, Point p2) { 
		ListIterator<BaseObject> it = objectList.listIterator();
		while (it.hasNext()) {
			BaseObject object = it.next();
			if(object.objectInZone(p1, p2) == false) { return false; }
		} 
		
		return true; 
	}
	
	@Override
	public void setSelected() { 
		ListIterator<BaseObject> it = objectList.listIterator();
		while (it.hasNext()) {
			BaseObject object = it.next();
			object.setSelected();
		} 
		selected = true;
	}
	
	@Override
	public void cancelSelected() { 
		ListIterator<BaseObject> it = objectList.listIterator();
		while (it.hasNext()) {
			BaseObject object = it.next();
			object.cancelSelected();
		} 
		selected = false;
	}
	
	@Override
	public void move(Point moveVector) {
		ListIterator<BaseObject> it = objectList.listIterator();
		while (it.hasNext()) {
			BaseObject object = it.next();
			object.move(moveVector);
		} 
	}
	
	@Override
	public List<BaseObject> getObjectList() {
		return objectList;
	}

}
