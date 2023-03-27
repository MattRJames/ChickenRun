import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics2D;

class Obstacle{
	double Xpos = 2000;
	
	double speed = 2;
	int width = 50;
	int height = 100;
	double Ypos = 655;
	BufferedImage rosebush;

	public Obstacle(){}
	
	public Obstacle(int x){
		Xpos = x;
		try{
			System.out.println("loading image");
	rosebush = ImageIO.read(getClass().getResourceAsStream("/obstacles/rosebush.png"));
	}catch (Exception e){
		System.out.println("file error");
		e.getStackTrace();
}
	}
	public int getX(){
		return (int)Xpos;
	}
	
	public int getY(){
		return (int)Ypos;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public boolean move(double gameSpeed){
		Xpos -= speed * gameSpeed;
		
		if (Xpos < -width){
			
			return false;
		}
		
		return true;
	}
	
	
	public void draw(Graphics2D g2){
		
	g2.drawImage(rosebush,getX(),getY(),width,height,null);
	}
	
}