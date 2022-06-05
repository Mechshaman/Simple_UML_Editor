package mode;

import java.awt.event.MouseEvent;
import objects.ObjectController;

public abstract class BaseMode {
	
	protected ObjectController objectController;
	
	public BaseMode(ObjectController objectController) {
		this.objectController = objectController;
	}
	
    public void mousePressed(MouseEvent e) { objectController.cancelSelected(); }
    public void mouseReleased(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    
}
