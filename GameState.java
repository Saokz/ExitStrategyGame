package org.sweatyink.com.states;

import java.awt.Graphics;

import org.sweatyink.com.InputHandler;
import org.sweatyink.com.core.GameStateManager;

public abstract class GameState {
	protected int ID;
	protected String name;
	protected InputHandler i;
	protected GameStateManager m;
	
	public GameState(String name, int ID, InputHandler i, GameStateManager m){
		this.ID = ID;
		this.name = name;
		this.i = i;
		this.m = m;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
