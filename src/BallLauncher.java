import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class BallLauncher extends GraphicsProgram{
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int SIZE = 25;
	
	public static final int S = 50;
	public static final int SPEED = 2;
	
	private ArrayList<GOval> balls;
	private Timer timer;
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
		
		balls = new ArrayList<>();
	}
	
	public void run() {
		addMouseListeners();
		
		timer = new Timer(S, this);
		timer.start();
	}
	
	public void mousePressed(MouseEvent e) {
		GOval ball = makeBall(SIZE/2, e.getY());
		add(ball);
		
		balls.add(ball);
	}
	
	public GOval makeBall(double x, double y) {
		GOval temp = new GOval(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
		temp.setColor(Color.RED);
		temp.setFilled(true);
		return temp;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		for (GOval ball : balls) {
			ball.move(SPEED, 0);
		}
	}
	
	public static void main(String[] args) {
		new BallLauncher().start();
	}
}

