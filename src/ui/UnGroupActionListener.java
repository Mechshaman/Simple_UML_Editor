package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import objects.ObjectController;

public class UnGroupActionListener implements ActionListener {
	
	private ObjectController objectController;
	private Canvas canvas;
	
	public UnGroupActionListener(ObjectController objectController, Canvas canvas){
		this.objectController = objectController;
		this.canvas = canvas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(objectController.checkSelectedCount() == 1) {
			objectController.unGroup();
			canvas.repaint();
		}
	}
	
}
