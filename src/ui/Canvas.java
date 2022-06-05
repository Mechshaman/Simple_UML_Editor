package ui;

import javax.swing.*;
import java.awt.*;

import mode.ModeController;
import objects.ObjectController;

public class Canvas extends JPanel {
	
	private ObjectController objectController;
	
	public Canvas(ModeController modeController, ObjectController objectController) {
		this.setBounds(110,60,1090,690);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		CanvasMouseAdapter adapter = new CanvasMouseAdapter(modeController, this);
		this.addMouseListener(adapter);
		this.addMouseMotionListener(adapter);
		
		this.objectController = objectController;
	}
	
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		objectController.updateObjects(graphics);
	}
	
}