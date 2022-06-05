package ui;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class MenuItem extends JMenuItem{
	
	MenuItem(String name, ActionListener listener){
		this.setFont(new Font("sans-serif", Font.PLAIN, 24));
		this.setText(name);
		this.addActionListener(listener);
	}
}
