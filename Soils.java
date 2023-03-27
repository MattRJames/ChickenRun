import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.util.ArrayList;

class Soils{
	ArrayList<Soil> soils = new ArrayList<Soil>();
	BufferedImage soil0,soil1;
	int type =0;
	
	
	
	public Soils(){
		getImages();
		start();
	}
	
	public void start(){
		soils.add(new Soil(0,soil0));
		soils.add(new Soil(1200,soil1));
		soils.add(new Soil(2400,soil0));
		soils.add(new Soil(3600,soil1));
	}
	
	public void getImages(){
		try{
			soil0 = ImageIO.read(getClass().getResourceAsStream("/enviroment/soil1.png"));
			soil1 = ImageIO.read(getClass().getResourceAsStream("/enviroment/soil2.png"));
			
			
			
		}catch(Exception e){
			System.out.println("file error");
		e.getStackTrace();
	}
		
	}
	
	public void move(double gameSpeed){
	int index = 0;
	
		boolean onScreen;
		while (index < soils.size()){
			Soil soil = soils.get(index);
			onScreen = soil.move(gameSpeed);
			if (onScreen == false){
				soils.remove(0);
				if (type == 0 || type == 1){
				soils.add(new Soil(getLastX(), soil0));
				} else {
					soils.add(new Soil(getLastX(),soil1));
				}
				type = (type+1) %2;
					
				
				
			} else{ 
			index += 1;
		}
			
		}

}
public int getLastX(){
	return (int)soils.get(2).Xpos + soils.get(2).width;
}

public void draw(Graphics2D g2){
	for (Soil s: soils){
		s.draw(g2);
		
	}
}

public void clear(){
	soils.clear();
}
	
	
	
	
	
	
}