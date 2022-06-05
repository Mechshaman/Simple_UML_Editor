package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import mode.ModeController;

public class CanvasMouseAdapter extends MouseAdapter{
	
	private ModeController modecontroller;
	private Canvas canvas;
	
	CanvasMouseAdapter(ModeController modecontroller, Canvas canvas){
		this.modecontroller = modecontroller;
		this.canvas = canvas;
	}
	
	// from MouseListener
    public void mousePressed(MouseEvent e) {
    	modecontroller.getCurrentMode().mousePressed(e);
    	canvas.repaint();
    }
     
    public void mouseReleased(MouseEvent e) {
    	modecontroller.getCurrentMode().mouseReleased(e);
    	canvas.repaint();
    }
    
    // from MouseMotionListener
    public void mouseDragged(MouseEvent e) {
    	modecontroller.getCurrentMode().mouseDragged(e);
    	canvas.repaint();
    }
    
}
