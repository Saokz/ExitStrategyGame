package org.sweatyink.com.states;

import java.awt.Graphics;

public abstract class GameState {
	protected int ID;
	protected String name;
	
	public GameState(){
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
