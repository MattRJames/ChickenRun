import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

class Soil{
	double Xpos;
	int width = 1200;
	int height =450;
	int Ypos = 450;
	double speed = 2;
	BufferedImage soil;
	
	public Soil(int x,BufferedImage image){
	Xpos = x;
	soil = image;
	}
	
	public boolean move(double gameSpeed){
		Xpos -= speed * gameSpeed;
		
		if (Xpos < -width){
			
			return false;
		}
		
		return true;
	}
	
	public void draw(Graphics2D g2){
		
		g2.drawImage(soil,(int)Xpos,Ypos,width,height,null);
	}
	
	
	
	
	
}