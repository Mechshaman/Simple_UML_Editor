package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import objects.ObjectController;

public class RenameActionListener implements ActionListener {
	
	private ObjectController objectController;
	private Canvas canvas;
	
	public RenameActionListener(ObjectController objectController, Canvas canvas){
		this.objectController = objectController;
		this.canvas = canvas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(objectController.checkSelectedCount() > 0) {
			JFrame jFrame = new JFrame();
			String newName = JOptionPane.showInputDialog(jFrame, "Enter new name :");
			objectController.renameObjects(newName);
			canvas.repaint();
		}
	}
	
}