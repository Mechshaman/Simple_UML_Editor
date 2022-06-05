package mode;

import java.awt.event.MouseEvent;
import objects.ClassObject;
import objects.ObjectController;

public class ClassMode extends BaseMode{
	
	public ClassMode(ObjectController objectController) {
		super(objectController);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		objectController.addObjectList(new ClassObject(objectController.getObjectListSize(),e.getPoint()));
    }

}
