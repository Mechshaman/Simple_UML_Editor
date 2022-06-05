package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import objects.ObjectController;

public class GroupActionListener implements ActionListener {
	
	private ObjectController objectController;
	private Canvas canvas;
	
	public GroupActionListener(ObjectController objectController, Canvas canvas){
		this.objectController = objectController;
		this.canvas = canvas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(objectController.checkSelectedCount() >= 2) {
			objectController.createGroup();
			canvas.repaint();
		}
	}
	
}