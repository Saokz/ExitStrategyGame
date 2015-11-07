package org.sweatyink.com.core;

import java.awt.Graphics;

import org.sweatyink.com.states.GameState;

public class GameStateManager {
	public static final int StartID = 0;
	public static final int MainID = 1;
	public static final int GameID = 2;
	public static final int MenuID = 3;
	public static final int PauseID = 4;
	
	private int numStates = 5;
	private GameState[] states = new GameState[numStates];
	private GameState currentState;
	
	public GameStateManager(){
		currentState = states[StartID];
	}
	
	public void setState(int id){
		if(currentState != null)
			currentState = null;
		
		currentState = states[id];
	}
	
	public void tick(){
		currentState.tick();
	}
	
	public void render(Graphics g){
		currentState.render(g);
	}
}
