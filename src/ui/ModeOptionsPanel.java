package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ListIterator;


public class ModeOptionsPanel extends JPanel {
	
	public ModeOptionsPanel(List<ModeOptionButton> modeOptionButtons) {
		this.setBounds(0,60,100,690);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		ListIterator<ModeOptionButton> it = modeOptionButtons.listIterator();
		while (it.hasNext()) {
			ModeOptionButton item = it.next();
			this.add(item);
		}
	}
	
}