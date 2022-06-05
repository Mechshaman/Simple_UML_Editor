package mode;

import java.awt.event.MouseEvent;
import objects.ObjectController;
import objects.UseCaseObject;

public class UseCaseMode extends BaseMode{
	
	public UseCaseMode(ObjectController objectController) {
		super(objectController);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		objectController.addObjectList(new UseCaseObject(objectController.getObjectListSize(),e.getPoint()));
    }

}
