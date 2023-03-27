import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

class Hats{

public ArrayList<Hat> hats = new ArrayList<Hat>();
public String[] filenames = {"mobster.png","mobster.png","sheriffR.png","sheriffL.png"};

public Hats(){
	loadHats();
}

public int size(){
	return hats.size();
}

public void loadHats(){
	
	try{
	BufferedImage left;
	BufferedImage right;
	int index = 0;
	
	while (index < filenames.length){
		
			left = ImageIO.read(getClass().getResourceAsStream("/playerSprites/Hats/"+ filenames[index]));
		right = ImageIO.read(getClass().getResourceAsStream("/playerSprites/Hats/" + filenames[index + 1]));
			Hat temp = new Hat(left,right);
	hats.add(temp);
	index += 2;
	}
	

			
		}catch(Exception e){
			System.out.println("file error");
		e.getStackTrace();
	}
		
	
}


public Hat get(int i){
	return hats.get(i);
}
	
	
}