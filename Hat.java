import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

class Hat {
	BufferedImage hatLeft,hatRight;
	int xRight = 40;
	int xLeft = 4;
		int yOffset = 3;
	
	public Hat(BufferedImage right,BufferedImage left){
		hatLeft = left;
		hatRight = right;
		
		
	}
	
	public void drawHat(Graphics2D g2, String direction,int x,int y){
		g2.translate(x,y);
		
		if (direction == "right"){
			
			g2.drawImage(hatRight,xRight,yOffset,hatRight.getWidth(),hatRight.getHeight(),null);
		}else{
			g2.drawImage(hatLeft,xLeft,yOffset,hatRight.getWidth(),hatRight.getHeight(),null);
		
			
		}
		g2.translate(-x,-y);
		}
	
}