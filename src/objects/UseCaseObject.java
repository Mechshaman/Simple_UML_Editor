package objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public class UseCaseObject extends BasicObject {
	
	public UseCaseObject(int depth, Point position) {
		super(depth, position, 120, 60, "Use case");
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(new Color(200,200,200));
		graphics.fillOval(position.x, position.y, width, height);
		graphics.setColor(Color.BLACK);
		graphics.drawOval(position.x, position.y, width, height);
		graphics.setFont(new Font("sans-serif", Font.PLAIN, 16));
		graphics.drawChars(name.toCharArray(), 0, name.length(), position.x + width/8, position.y + height/2);
		
		if(selected) {
			drawPort(graphics);
		}
	}

}
