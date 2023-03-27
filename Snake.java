import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;


class Snake extends Obstacle{
	BufferedImage snake0,snake1;
	int tick = 0;
	int state = 0;
	
	public Snake(int x){
		super(x);
		super.width=250;
		super.height=35;
		super.Ypos = 725;
		super.speed = 2.5;
		getImages();
		
		
	}
	
	public void draw(Graphics2D g2){
		
		if (state == 0){
			g2.drawImage(snake0,getX(),getY(),width,height,null);
			
		}else {
			g2.drawImage(snake1,getX(),getY(),width,height,null);
		}
		
		tick++;
			if (tick > 30){
				
				state = (state + 1) % 2;
				tick = 0;
			}
		
	}
	
	public void getImages(){
	try{
			
			snake0 = ImageIO.read(getClass().getResourceAsStream("/obstacles/Snake0.png"));
			snake1 = ImageIO.read(getClass().getResourceAsStream("/obstacles/Snake1.png"));
			
			
			
		}catch(Exception e){
			System.out.println("file error");
		e.getStackTrace();
	}
	
}
	
	
	
}