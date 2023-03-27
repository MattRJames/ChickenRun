

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class Character{
	double Xpos = 0;
	double Ypos = 600;
	int height = 64;
	int width = 64;
	boolean onGround =true;
	int speed = 1;
	double speedY = 0;
	public int floorHeight = 685;
	
	int tick = 0;
	int pos = 1;
	public BufferedImage idleRight,idleLeft,walkRight,walkLeft,flappingLeft,flappingRight;
	public String direction  = "right";
	public Hats hats = new Hats();
	public int selectedIndex = 0;
	public Hat selectedHat = hats.get(0);
	
	
	
	public Character(){
		getPlayerImage();
		
	}
	
	public void setHats(Hats x){
		hats = x;
	}
	
	public void setHat(){
		selectedHat = hats.get(selectedIndex);
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
		
	
	public void move(KeyHandler keyH){
		if (keyH.upPressed == true){
			 if (onGround == true){
				 
			 speedY = -15 ;
			 onGround = false;
		}}
	
	if (keyH.rightPressed ==true && Xpos + width < (1600- 5 * speed)){
		Xpos += 5 * speed;
		direction = "right";
	}
	
	if (keyH.leftPressed ==true && Xpos > ( 5 * speed)){
		Xpos -= 5 * speed;
		direction = "left";
	}
	
	if (keyH.downPressed == true){
		
		if (speedY < 0){
			speedY = 0;
		}
		
	}
	
	
	if (speedY< 5 * speed){
	speedY += 0.5 * speed;
	}
	
	if (Ypos + speedY >= floorHeight){
		Ypos = floorHeight;
		onGround = true;
		speedY = 0;
	}else{
		Ypos = Ypos + speedY * speed;
	}

	
}	
	
	public void draw(Graphics2D g2){
		BufferedImage image = null;
		
		if (pos == 1){
		switch(direction){
			
			case "right":
			image = idleRight;
			break;
			case "left":
			image = idleLeft;
			break;
		}}else {
			switch(direction){
			case "right":
			if (onGround){
			image = walkRight;
			} else{
				image = flappingRight;
			}
			break;
			case "left":
			if (onGround){
			image = walkLeft;
			} else{
				image = flappingLeft;
			}
			break;
		}
			}
			
			g2.drawImage(image,getX(),getY(),width,height,null);
			selectedHat.drawHat(g2,direction,getX(),getY());
			tick++;
			if (tick > 10){
				
				pos = (pos + 1) % 2;
				tick = 0;
			}
	}
	
	public void reset(){
		Xpos = 0;
		Ypos = 0;
		speedY = 0;
	}
	
	public void getPlayerImage(){
		try{
			idleRight = ImageIO.read(getClass().getResourceAsStream("/playerSprites/idle-right.png"));
			idleLeft = ImageIO.read(getClass().getResourceAsStream("/playerSprites/idle-left.png"));
			walkRight = ImageIO.read(getClass().getResourceAsStream("/playerSprites/walk-right.png"));
			walkLeft = ImageIO.read(getClass().getResourceAsStream("/playerSprites/walk-left.png"));
			flappingRight = ImageIO.read(getClass().getResourceAsStream("/playerSprites/flapping-right.png"));
			flappingLeft = ImageIO.read(getClass().getResourceAsStream("/playerSprites/flapping-left.png"));
			
		}catch(Exception e){
			
		e.getStackTrace();
	}
		
		
	}
	
	public void drawModel(Graphics2D g2){
		g2.drawImage(idleRight,768,685,width,height,null);
		selectedHat.drawHat(g2,"right",768,685);
		
	}
}
	