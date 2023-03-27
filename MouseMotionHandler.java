import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class MouseMotionHandler implements MouseMotionListener{
	
	GamePanel Gp;
	
	public MouseMotionHandler(GamePanel x){
		Gp = x;
	}
	
	public void mouseMoved(MouseEvent e){
		int xPos = e.getX();
		int yPos = e.getY();
		
		if (Gp.playbutton.contains(xPos,yPos)){
			
			Gp.playbutton.setSelected();
			
		} else{
			Gp.playbutton.setUnselected();
		}
		
		if (Gp.helpbutton.contains(xPos,yPos)){
			Gp.helpbutton.setSelected();
			
		} else{
			Gp.helpbutton.setUnselected();
		}
		
		if (Gp.quitbutton.contains(xPos,yPos)){
			Gp.quitbutton.setSelected();
			
		} else{
			Gp.quitbutton.setUnselected();
		}
		
		if (Gp.leftArrow.contains(xPos,yPos)){
			Gp.leftArrow.setSelected();
			
		} else{
			Gp.leftArrow.setUnselected();
		}
		if (Gp.rightArrow.contains(xPos,yPos)){
			Gp.rightArrow.setSelected();
			
		} else{
			Gp.rightArrow.setUnselected();
		}
		
		
	}
	
	public void mouseDragged(MouseEvent e){}
	
	
	
	
	
	
}