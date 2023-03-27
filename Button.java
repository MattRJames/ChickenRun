import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;

class Button extends Rectangle{
	boolean selected = false;
	 
	public Button(int x,int y, int width, int height){
		super(x,y,width,height);
	}
	
	
	public void draw(Graphics2D g2){
		g2.setColor(new Color(1f,1f,1f,0.2f));
		if (selected == true){
			
			g2.fillRect(x,y,width,height);
			
			
		}
	g2.setColor(Color.white);
	
	
}
public void setSelected(){
	
	selected = true;



}

public void setUnselected(){
	selected =false;
}
}