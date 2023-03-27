import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class Fence extends Obstacle{
	
	BufferedImage image;
	
	
	public Fence(int x){
		super(x);
		super.width = 175;
		super.height = 125;
		super.Ypos = 625;
		loadImages();
	}
	
	public void draw(Graphics2D g2){
		g2.drawImage(image,getX(),getY(),super.width,super.height,null);
	}
	
	public void loadImages(){
		try{
			
			image = ImageIO.read(getClass().getResourceAsStream("/obstacles/fence.png"));
			
			
		}catch(Exception e){
			System.out.println("file error");
		e.getStackTrace();
}
	}
	
	
	
	
	
	
}