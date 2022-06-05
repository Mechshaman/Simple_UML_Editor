package mode;

import java.awt.Point;

import objects.ConnectionLine;
import objects.GeneralizationLine;
import objects.ObjectController;

public class GeneralizationMode extends LineMode{

	public GeneralizationMode(ObjectController objectController) {
		super(objectController);
	}
	
	@Override
	protected ConnectionLine createLine(int depth, Point start, Point end) {
		GeneralizationLine generalizationLine = new GeneralizationLine(depth, start, end);
		return generalizationLine;
	}

}
