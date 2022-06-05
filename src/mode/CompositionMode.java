package mode;

import java.awt.Point;

import objects.CompositionLine;
import objects.ConnectionLine;
import objects.ObjectController;

public class CompositionMode extends LineMode{

	public CompositionMode(ObjectController objectController) {
		super(objectController);
	}
	
	@Override
	protected ConnectionLine createLine(int depth, Point start, Point end) {
		CompositionLine compositionLine = new CompositionLine(depth, start, end);
		return compositionLine;
	}

}
