package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import objects.ObjectController;

public class SelectMode extends BaseMode{
	
	private boolean selectArea;
	private Point startPoint;
	
	public SelectMode(ObjectController objectController) {
		super(objectController);
		selectArea = false;
		startPoint = null;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		startPoint = e.getPoint();
		if(objectController.selectOneObject(e.getPoint()) == null) {
			objectController.setSelectZone(startPoint, e.getPoint());
			selectArea = true;
		}
    }
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(selectArea) {
			objectController.selectAreaObjects();
		}
		selectArea = false;
    }
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(selectArea) {
			objectController.setSelectZone(startPoint, e.getPoint());
		}
		else {
			Point now = e.getPoint();
			Point moveVector = new Point(now.x - startPoint.x, now.y - startPoint.y);
			objectController.moveObjects(moveVector);
			startPoint = now;
		}
    }

}
