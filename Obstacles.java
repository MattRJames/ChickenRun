

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class Obstacles{
	
	Random rand = new Random();
	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	int screenWidth;
	
	
	
	
public Obstacles(int x){
	screenWidth =x;
	
}

public void start(){
	
	Obstacle first = new Snake(screenWidth/4 * 3);
	Obstacle second = new Obstacle(screenWidth/4 * 3 + 500);
	Obstacle third = new Obstacle(screenWidth/4 * 3 + 900);
	Obstacle forth = new Obstacle(screenWidth/4 * 3 + 1300);
	Obstacle fifth = new Obstacle(screenWidth/4 * 3 + 1700);
	Obstacle sixth = new Obstacle(screenWidth/4 * 3 + 2000);
	
	obstacles.add(first);
	obstacles.add(second);
	obstacles.add(third);
	obstacles.add(forth);
	obstacles.add(fifth);
	obstacles.add(sixth);
	
	
	
	
	
	
	spawner();
	
	
}
public Obstacle getLast(){
	return obstacles.get(obstacles.size() -1 );
	
}

public void move(double gameSpeed){
	int index = 0;
	
		boolean onScreen;
		while (index < obstacles.size()){
			Obstacle o = obstacles.get(index);
			onScreen = o.move(gameSpeed);
			if (onScreen == false){
				obstacles.remove(o);
				spawner();
				
			} else{ index += 1;
		}
			
		}
	
}

public void draw(Graphics2D g2){
	for (Obstacle o: obstacles){
		o.draw(g2);
	}
}

public void spawner(){
	int number = rand.nextInt(12);
	int position;

	Obstacle lastObstacle = getLast();
	int furthestPos = lastObstacle.getWidth() + lastObstacle.getX();
	
	
	
	if ( number <3){
		position =  furthestPos+ 600;
		
	} else if(number < 6) {
		position =  furthestPos + 900;
	} else if (number < 9){
		position = furthestPos + 350;
	} else {
		position = furthestPos + 450;
	}
	
	number = rand.nextInt(6);
	Obstacle o;
	if (number <= 3){
		 o = new Fence(position);
		
		
	}else if (number == 4){
		o = new Snake(position);
		
	
	}
	else{
		o = new Obstacle(position);
	}
	obstacles.add(o);
}
public boolean isColliding(Character c){
	
	
	
	for (Obstacle obs : obstacles){
		if ((c.getX() > obs.getX() && c.getX() < obs.getX() + obs.getWidth()) || (c.getX() + c.getWidth() > obs.getX() && c.getX() +obs.getWidth() < obs.getX() + obs.getWidth() ) ){
			if ((c.getY() > obs.getY() && c.getY() < obs.getY() + obs.getHeight()) || (c.getY() + c.getHeight() > obs.getY() && c.getY() +obs.getHeight() < obs.getY() + obs.getHeight() ) ){
				return true;
			}
		}
		}
		return false;
	


}
public void clear(){
	
	obstacles.clear();
}


	
	
	
}