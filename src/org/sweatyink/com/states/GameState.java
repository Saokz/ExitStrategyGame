package org.sweatyink.com.states;

import java.awt.Graphics;

import org.sweatyink.com.InputHandler;

public abstract class GameState {
	protected int ID;
	protected String name;
	protected InputHandler i;
	
	public GameState(InputHandler i){
		this.i = i;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
