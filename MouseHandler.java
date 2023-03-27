import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


class MouseHandler implements MouseListener{
	GamePanel Gp;
	
	public MouseHandler(GamePanel x){
		Gp = x;
		
	}
	
	
	
	
	
	public void mouseClicked(MouseEvent e){
		int xPos = e.getX();
		int yPos = e.getY();
		
		if (Gp.gameState == 0){
		if (Gp.playbutton.contains(xPos,yPos)){
			Gp.gameState = 1;
			
		}
		if (Gp.helpbutton.contains(xPos,yPos)){
			Gp.gameState = 2;
			
		}
		
		if (Gp.quitbutton.contains(xPos,yPos)){
			System.exit(0);
			
		}
		
		if (Gp.leftArrow.contains(xPos,yPos)){
			
			if (Gp.character.selectedIndex == 0){
				Gp.character.selectedIndex = Gp.character.hats.size() - 1;
			} else{
				Gp.character.selectedIndex--;
			}
			Gp.character.setHat();
			
		}
		
		if (Gp.rightArrow.contains(xPos,yPos)){
			if (Gp.character.selectedIndex == Gp.character.hats.size() - 1 ){
				Gp.character.selectedIndex = 0;
			}else{
				Gp.character.selectedIndex++;
			}
			Gp.character.setHat();
		}
		
		
	}}
	
	public void mouseEntered(MouseEvent e){
		
	}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	
	
	
}