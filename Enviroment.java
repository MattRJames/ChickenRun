

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;

class Enviroment{
	public double soilPos = 0;
	public BufferedImage skyline;
	public int soilCount =0;
	public double offset = 0;
	public int floorHeight = 450;
	public int soilWidth = 1200;
	public int soilHeight = 450;
	public Soils soils = new Soils();
	
	public Enviroment(){
		getImages();
	}
	
	public void draw(Graphics2D g2,double gameSpeed){
		g2.drawImage(skyline,0,-50,1600,900,null);
		
		soils.draw(g2);
		
		
		
	}
	
	
	public void getImages(){
		try{
			skyline = ImageIO.read(getClass().getResourceAsStream("/enviroment/skylineHeart.png"));
			
			
			
			
		}catch(Exception e){
			System.out.println("file error");
		e.getStackTrace();
	}
		
	}
	
	
	public void move(double gameSpeed){
		soils.move(gameSpeed);
		
	}
	
	public void reset(){
		
		soils.clear();
		soils.start();
	}
	
	
	
	
	
	
}