package org.sweatyink.com.states;

import java.awt.Graphics;

import org.sweatyink.com.GameMain;
import org.sweatyink.com.InputHandler;
import org.sweatyink.com.core.GameStateManager;
import org.sweatyink.com.core.HUD;
import org.sweatyink.com.core.Handler;
import org.sweatyink.com.entity.GameObject;
import org.sweatyink.com.entity.Player;
import org.sweatyink.com.entity.Walls;

public class PlayState extends GameState{
	private Handler h;
	private HUD hud;

	public PlayState(String name, int ID, InputHandler i, GameStateManager m, GameMain g) {
		super(name, ID, i, m);
		
		h = new Handler();
		hud = new HUD();
		
		int randomNum = generateRectNumber();
		
		if(randomNum == 0){
		// Left Rectangle Object
		h.objects.add(new Walls(0, 0, 800, 100, 0));
		}
		else if(randomNum == 1){
		// Right Rectangle Object
		h.objects.add(new Walls(1263, 0, 800, 100, 1));
		}
		
		else if (randomNum == 2){
		// Top Rectangle Object
		h.objects.add(new Walls(0, 0, 100, 1400, 2));
		}
		
		else if (randomNum == 3){
		// Bottom Rectangle Object
		h.objects.add(new Walls(0, 663 , 100, 1400, 3));
		}
		
		h.objects.add(new Player(700, 400, 50, 50, g, h, this));
	}

	public void tick() {
		h.tick();
		hud.tick();
	}
	
	public void reset(GameMain g){
		for(int i = 0; i< h.objects.size(); i++){
			h.objects.remove(i);
		}
		
		int randomNum = generateRectNumber();
		
		if(randomNum == 0){
		// Left Rectangle Object
		h.objects.add(new Walls(0, 0, 800, 100, 0));
		}
		else if(randomNum == 1){
		// Right Rectangle Object
		h.objects.add(new Walls(1263, 0, 800, 100, 1));
		}
		
		else if (randomNum == 2){
		// Top Rectangle Object
		h.objects.add(new Walls(0, 0, 100, 1400, 2));
		}
		
		else if (randomNum == 3){
		// Bottom Rectangle Object
		h.objects.add(new Walls(0, 663 , 100, 1400, 3));
		}
		
		h.objects.add(new Player(700, 400, 50, 50, g, h, this));
	}

	public void render(Graphics g) {
		h.render(g);
		hud.render(g);
	}

	public int generateRectNumber(){
	
	int numRam = 0;	
		
	numRam = (int)(Math.random() * 4);
	
	return numRam;
	}

}
