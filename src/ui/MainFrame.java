package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{
	
	public MainFrame(){
		this.setTitle("UML Editor");
		this.addWindowListener(new FrameAdapter());
		this.setLayout(null);
		this.setBounds(0,0,1220,790);
		this.getContentPane().setBackground(Color.WHITE);
		this.setResizable(false);
	}
	
}

class FrameAdapter extends WindowAdapter {
	
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    
}
