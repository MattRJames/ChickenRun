

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;
import java.awt.Rectangle;



public class GamePanel extends JPanel implements Runnable{
	
	//Screen settings
	public int score = 0;
	public int highScore = 0;
	public int screenWidth = 1600;
	public int screenHeight = 900;
	public int groundHeight = 250;
	public int gameState = 0;
	final public int menuState = 0;
	final public int playState = 1;
	public int commandNum = 0;
	public double gameSpeed;
	public double gameSpeedIncrease = 0.2;
	public Button playbutton = new Button(170,245,200,44);
	public Button helpbutton = new Button(170,295,200,44);
	public Button quitbutton = new Button(170,345,200,44);
	public Button leftArrow = new Button(675,680,75,75);
	public Button rightArrow = new Button(850,680,75,75);
	
	KeyHandler keyH = new KeyHandler(this);
	MouseHandler mouseH = new MouseHandler(this);
	MouseMotionHandler mouseMotionH = new MouseMotionHandler(this);
	Thread gameThread;
	Character character = new Character();
	
	Obstacles obstacles = new Obstacles(screenWidth);
	Enviroment enviroment = new Enviroment();
    
	
	
	public GamePanel(){
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		
		
		this.addKeyListener(keyH);
		this.addMouseListener(mouseH);
		this.addMouseMotionListener(mouseMotionH);
		this.setFocusable(true);
	}
	
	@Override
	public void run(){
		
		while(gameThread != null){
			
			
			
		if (gameState == 0 || gameState == 2){
			repaint();
		} else if (gameState == 1){
			gameSpeed = 1;
		obstacles.clear();
		obstacles.start();
		while(gameThread != null){
			
			
			
			update();
			repaint();
			
		if (obstacles.isColliding(character) == true){
			break;
		}else {
			score++;
			if (score %1000 ==0){
				gameSpeed += gameSpeedIncrease;
			}
		
		}
		
		synchronized (this){
			try{
			this.wait(8);
			
			} catch (InterruptedException ex){
				System.out.println("error with thread wait");
			}
			
		}
		}
		
		storehighscore(score);
		obstacles.clear();
		score = 0;
		gameState = 0;
		character.reset();
		enviroment.reset();
		gameSpeed = 1;
		}
	
	
		}}
	
	
	
	public void startGameThread(){
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	
	public void update(){
		character.move(keyH);
		
		obstacles.move(gameSpeed);
		enviroment.move(gameSpeed);
		
		
	}
	
	public void storehighscore(int score){
		if (score > highScore){
			highScore = score;
		}
	}
	
	
	
	
	
	
	
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;
	if (gameState ==0){
		enviroment.draw(g2,gameSpeed);
		drawMenuScreen(g2);
		
	}
	
	
	else if (gameState == 1){
	enviroment.draw(g2,gameSpeed);
	
	obstacles.draw(g2);
	
	character.draw(g2);
	
	drawScore(g2);
	
	g2.dispose();
	} else if (gameState == 2){
		enviroment.draw(g2,gameSpeed);
		
		drawHelp(g2);
	}
	}
	
public void drawScore(Graphics2D g2){
	g2.setColor(Color.white);
	g2.setFont(g2.getFont().deriveFont(30f));
	
	int intScore = (int)score;
	String stringScore = Integer.toString(intScore);
	g2.drawString("Score: " + stringScore, screenWidth/8, 30);
	
	if (score > highScore){
		intScore = (int)score;
	} else {
		intScore = (int)highScore;
	}
	
	String stringHighScore = Integer.toString(intScore);
	g2.drawString("HighScore: " + stringHighScore, screenWidth/8 * 6, 30);
}

public void drawMenuScreen(Graphics2D g2){
	

	
	g2.setColor(Color.white);
	g2.setFont(g2.getFont().deriveFont(80f));
	String text = "Chicken Run";
	
	int x = 100;
	int y = 200;
	
	g2.drawString(text,x,y);
	
	g2.setFont(g2.getFont().deriveFont(40f));
	
	text = "Play";
	g2.drawString(text,x + 70,y + 80);
	playbutton.draw(g2);
	
	
	
	text = "Help";
	g2.drawString(text,x + 70,y + 130);
	helpbutton.draw(g2);
	
	text = "Quit";
	g2.drawString(text,x + 70,y + 180);
	quitbutton.draw(g2);
	
	character.drawModel(g2);
	
	g2.setFont(g2.getFont().deriveFont(100f));
	text = "<";
	g2.drawString(text,680,750);
	leftArrow.draw(g2);
	text = ">";
	g2.drawString(text,860,750);
	rightArrow.draw(g2);
}
	
	public void drawHelp(Graphics2D g2){
		int x = 100;
	int y = 200;
		enviroment.draw(g2,gameSpeed);
		
		g2.setColor(Color.white);
	g2.setFont(g2.getFont().deriveFont(60f));
	String text = "Help";
	g2.drawString(text,900,280);
	
	g2.setFont(g2.getFont().deriveFont(40f));
	text = "W - Jump";
	g2.drawString(text,900,340);
	text = "A - Move Left";
	g2.drawString(text,900,380);
	text = "S - Move Down";
	g2.drawString(text,900,420);
	text = "D - Move Right";
	g2.drawString(text,900,460);
	text = "Use the W, A, S, D keys to control";
	g2.drawString(text,900,500);
	text = "the chicken.The objective is to get";
	g2.drawString(text,900,540);
	text = "as far as possible while dodging fences, snakes and rose bushes.";
	g2.drawString(text,900,580);
	text = "fences, snakes and rose bushes.";
	g2.drawString(text,900,620);
	
	
		drawMenuScreen(g2);
	}
	
	
	
	
}