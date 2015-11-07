package org.sweatyink.com.states;

import java.awt.Graphics;

import org.sweatyink.com.InputHandler;
import org.sweatyink.com.core.GameStateManager;
import org.sweatyink.com.core.HUD;
import org.sweatyink.com.core.Handler;

public class PlayState extends GameState{
	private Handler h;
	private HUD hud;

	public PlayState(String name, int ID, InputHandler i, GameStateManager m) {
		super(name, ID, i, m);
		
		h = new Handler();
		hud = new HUD();
	}

	public void tick() {
		h.tick();
		hud.tick();
	}

	public void render(Graphics g) {
		h.render(g);
		hud.render(g);
	}

}
