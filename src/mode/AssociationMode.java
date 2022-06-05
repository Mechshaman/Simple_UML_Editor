package mode;

import java.awt.Point;
import objects.AssociationLine;
import objects.ConnectionLine;
import objects.ObjectController;

public class AssociationMode extends LineMode {
	
	public AssociationMode(ObjectController objectController) {
		super(objectController);
	}

	@Override
	protected ConnectionLine createLine(int depth, Point start, Point end) {
		AssociationLine associationLine = new AssociationLine(depth, start, end);
		return associationLine;
	}
	
}
