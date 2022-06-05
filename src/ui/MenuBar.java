package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ListIterator;

public class MenuBar extends JMenuBar {
	
	public MenuBar(List<MenuOption> menuOptions) {
		this.setBounds(0,0,1200,50);
		this.setBackground(Color.GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		ListIterator<MenuOption> it = menuOptions.listIterator();
		while (it.hasNext()) {
			MenuOption item = it.next();
			this.add(item);
		}
	}
	
}
