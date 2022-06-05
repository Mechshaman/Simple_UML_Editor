package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ListIterator;

public class MenuOption extends JMenu {
	
	public MenuOption(String name, List<MenuItem> items) {
		this.setText(name);
		this.setFont(new Font("sans-serif", Font.PLAIN, 24));
		
		ListIterator<MenuItem> it = items.listIterator();
		while (it.hasNext()) {
			MenuItem item = it.next();
			this.add(item);
		}
	}
	
}
