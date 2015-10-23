package stuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Button {
	public float x, y;
	int width, height;
	int task;
	public String text;
	public boolean pressed;
	public Color color;
	public boolean passed;
	public BufferedImage image;
	
	public Button(float x, float y, int width, int height,int task, String text,Color color, boolean passed,
			BufferedImage image) {
		// TODO Auto-generated constructor stub
		this.passed = passed;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.task = task;
		this.text = text;
		pressed = false;
		this.color = color;
	}
	
	public void draw(Graphics2D dbg,float X, float Y){
		x+=X;
		y+=Y;
		
		if(image!=null){
			//desenha a fodendo imagem
		} else {
			//quadrado dos barato doido memo
			dbg.setColor(color);
			dbg.fillRect((int)x, (int)y, width, height);
		}
		
		dbg.setColor(Color.BLACK);
		dbg.drawString(text, x+5, 5+y+height/2);
	}
	
	public boolean press(float x2, float y2){
		if(x2>x && x2<(x+width)){
			if(y2>y && y2<(y+height)){
				return true;
			}
		}
		return false;
	}
}
