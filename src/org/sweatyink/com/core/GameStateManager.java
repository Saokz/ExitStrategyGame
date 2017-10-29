package org.sweatyink.com.core;

import java.awt.Graphics;

import org.sweatyink.com.InputHandler;
import org.sweatyink.com.states.GameState;
import org.sweatyink.com.states.MenuState;
import org.sweatyink.com.states.PlayState;
import org.sweatyink.com.states.StartState;

public class GameStateManager {
	public static final int StartID = 0;
	public static final int MainID = 1;
	public static final int GameID = 2;
	public static final int MenuID = 3;
	public static final int PauseID = 4;
	
	private GameMain gm;
	private int numStates = 5;
	private GameState[] states = new GameState[numStates];
	private GameState currentState;
	private InputHandler i;
	
	public GameStateManager(InputHandler i, GameMain gm){
		this.i = i;
		
		this.gm = gm;
		
		initStates();
		
		currentState = states[StartID];
	}
	
	private void initStates(){
		states[0] = new StartState("Start State", StartID, i, this);
		states[1] = new PlayState("Play State", MainID,i, this, gm);
		states[2] = new MenuState("Menu State", MenuID,i, this);
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
