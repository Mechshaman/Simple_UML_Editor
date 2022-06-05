package ui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import mode.ModeController;

public class ModeOptionButton extends JButton {
	
	public ModeOptionButton(Point p, String imgName, ModeController modeController, String mode) {
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		Icon icon = new ImageIcon("src/img/" + imgName);
		this.setIcon(icon);
		this.setBounds(p.x,p.y,80,80);
		
		this.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	modeController.setMode(mode);
	        }
	    });
	}
	
}
