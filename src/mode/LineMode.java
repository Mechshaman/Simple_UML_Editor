package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import objects.ConnectionLine;
import objects.ObjectController;

public abstract class LineMode extends BaseMode {
	
	protected Point startPoint;
	
	public LineMode(ObjectController objectController) {
		super(objectController);
		startPoint = null;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		startPoint = objectController.findPointToCreateLine(e.getPoint());
    }
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(startPoint != null) {
			Point endPoint = objectController.findPointToCreateLine(e.getPoint());
			if(endPoint != null && startPoint != endPoint) {
				objectController.addObjectList(createLine(objectController.getObjectListSize(), startPoint, endPoint));
			}
		}
		startPoint = null;
    }
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(startPoint != null) {
			objectController.setTempLine(startPoint, e.getPoint());
		}
    }
	
	protected abstract ConnectionLine createLine(int depth, Point start, Point end);
	
}
