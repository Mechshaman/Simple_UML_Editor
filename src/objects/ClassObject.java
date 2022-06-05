package objects;

import java.awt.*;

public class ClassObject extends BasicObject {
	
	public ClassObject(int depth, Point position) {
		super(depth, position, 100, 150, "Class");
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(new Color(200,200,200));
		graphics.fillRect(position.x, position.y, width, height);
		graphics.setColor(Color.BLACK);
		graphics.drawRect(position.x, position.y, width, height/3);
		graphics.drawRect(position.x, position.y + height/3, width, height/3);
		graphics.drawRect(position.x, position.y + (height/3)*2, width, height/3);
		graphics.setFont(new Font("sans-serif", Font.PLAIN, 16));
		graphics.drawChars(name.toCharArray(), 0, name.length(), position.x, position.y + height/6);
		
		if(selected) {
			drawPort(graphics);
		}
	}

}
