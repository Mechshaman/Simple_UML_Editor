package objects;

import java.awt.Graphics;
import java.awt.Point;
import java.util.*;

public class ObjectController {
	
	private List<BaseObject> objectList;
	private List<BaseObject> selectedList;
	private boolean selectZoneExisted, tempLineExisted;
	private Point selectZonePoint;
	private int selectZoneWidth, selectZoneHeight;
	private Point tempLineStartPoint, tempLineEndPoint;
	
	public ObjectController(){
		objectList = new ArrayList<BaseObject>();
		selectedList = new ArrayList<BaseObject>();
		selectZoneExisted = false;
		tempLineExisted = false;
		selectZonePoint = null;
		selectZoneWidth = 0;
		selectZoneHeight = 0;
		tempLineStartPoint = null;
		tempLineEndPoint = null;
	}
	
	public void updateObjects(Graphics graphics) {
		ListIterator<BaseObject> it = objectList.listIterator();
		while (it.hasNext()) {
			BaseObject object = it.next();
			object.draw(graphics);
		}
		
		if(selectZoneExisted) {
			graphics.drawRect(selectZonePoint.x, selectZonePoint.y, selectZoneWidth, selectZoneHeight);
		}
		
		if(tempLineExisted) {
			graphics.drawLine(tempLineStartPoint.x, tempLineStartPoint.y, tempLineEndPoint.x, tempLineEndPoint.y);
		}
	}
	
	public void addObjectList(BaseObject object) {
		objectList.add(object);
	}
	
	public int getObjectListSize() {
		return objectList.size();
	}
	
	public BaseObject selectOneObject(Point point) {
		ListIterator<BaseObject> it = objectList.listIterator(objectList.size());
		while (it.hasPrevious()) {
			BaseObject object = it.previous();
			if(object.pointOnObject(point)) { 
				object.setSelected();
				selectedList.add(object);
				return object;
			}
		}
		return null;
	}
	
	public void selectAreaObjects() {
		ListIterator<BaseObject> it = objectList.listIterator();
		while (it.hasNext()) {
			BaseObject object = it.next();
			if(object.objectInZone(selectZonePoint, new Point(selectZonePoint.x + selectZoneWidth, selectZonePoint.y + selectZoneHeight))) { 
				object.setSelected();
				selectedList.add(object);
			}
		}
		selectZoneExisted = false;
	}
	
	public void cancelSelected() {
		ListIterator<BaseObject> it = selectedList.listIterator();
		while (it.hasNext()) {
			BaseObject object = it.next();
			object.cancelSelected();
			it.remove();
		}
	}
	
	public void setSelectZone(Point point1, Point point2) {
		Point point = new Point(point1.x, point1.y);
		if(point1.x > point2.x) {
			point.x = point2.x;
		}
		if(point1.y > point2.y) {
			point.y = point2.y;
		}
		
		selectZonePoint = point;
		selectZoneWidth = Math.abs(point1.x - point2.x);
		selectZoneHeight = Math.abs(point1.y - point2.y);
		selectZoneExisted = true;
	}
	
	public int checkSelectedCount() {
		return selectedList.size();
	}
	
	public void moveObjects(Point moveVector) {
		ListIterator<BaseObject> it = selectedList.listIterator();
		while (it.hasNext()) {
			BaseObject object = it.next();
			object.move(moveVector);
		}
	}
	
	public Point findPointToCreateLine(Point point) {
		tempLineExisted = false;
		Point connectPoint;
		ListIterator<BaseObject> it = objectList.listIterator(objectList.size());
		while (it.hasPrevious()) {
			BaseObject object = it.previous();
			connectPoint = object.connectPort(point);
			if(connectPoint != null) {
				return connectPoint;
			}
		}
		return null;
	}
	
	public void setTempLine(Point tempLineStart, Point tempLineEnd) {
		tempLineExisted = true;
		this.tempLineStartPoint = tempLineStart;
		this.tempLineEndPoint = tempLineEnd;
	}

	public void renameObjects(String newName) {
		assert checkSelectedCount() > 0;
		ListIterator<BaseObject> it = selectedList.listIterator();
		while (it.hasNext()) {
			BaseObject object = it.next();
			object.rename(newName);
		}
	}
	
	public void createGroup() {
		assert checkSelectedCount() >= 2;
		List<BaseObject> groupObjectList = new ArrayList<BaseObject>();
		ListIterator<BaseObject> it = selectedList.listIterator();
		while(it.hasNext()){
			BaseObject object = it.next();
			it.remove();
			objectList.remove(object);
			groupObjectList.add(object);
		}
		GroupObject groupObject = new GroupObject(getObjectListSize(),groupObjectList);
		objectList.add(groupObject);
	}
	
	public void unGroup() {
		assert checkSelectedCount() == 1;
		BaseObject object = selectedList.get(0);
		cancelSelected();
		List<BaseObject> groupObjectList = object.getObjectList();
		if(groupObjectList != null) {
			addObjectsToObjectList(groupObjectList);
		}
		
	}
	
	private void addObjectsToObjectList(List<BaseObject> groupObjectList) {
		ListIterator<BaseObject> it = groupObjectList.listIterator();
		while(it.hasNext()){
			BaseObject object = it.next();
			objectList.add(object);
		}
	}
	
}
