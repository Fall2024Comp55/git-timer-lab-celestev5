import acm.graphics.*;
import acm.program.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFirstTimer extends GraphicsProgram implements ActionListener {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int MAX_STEPS = 20;
	private GLabel myLabel;
	private Timer someTimerVar;
	private int numTimes;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		myLabel = new GLabel("# of times called?", 0, 100);
		add(myLabel);
		
		numTimes = 0;
		
		Timer someTimerVar = new Timer(1000, this);
		
		someTimerVar.setInitialDelay(3000);
		
		someTimerVar.start();
		
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		numTimes++;
		
		myLabel.setLabel("times called? " + numTimes);
		
		myLabel.move(5, 0);
		
		if(numTimes >= 10)
			someTimerVar.stop();
		
	}
	
	public static void main(String[] args) {
		new MyFirstTimer().start();
	}
}