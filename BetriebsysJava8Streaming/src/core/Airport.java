package core;

import java.util.List;

import visualisation.Visualisation;

public class Airport {
	private Check CheckIn, Security, Gate;
	private int delay;
	private Visualisation v;
	
	public Airport(int delay, Visualisation v){
		this.delay = delay;
		this.v = v;
		
		CheckIn = new Check(2,2);
		Security = new Check(2,2);
		Gate = new Check(1,2);
	}
	
	public void move(Person p){
		while(true){
			System.out.println("in move "+p.getName());
			p.y += 5;
			v.repaint();
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
	}
}
