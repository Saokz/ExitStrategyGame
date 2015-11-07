package org.sweatyink.com.states;

import java.awt.Color;
import java.awt.Graphics;

import org.sweatyink.com.GameMain;
import org.sweatyink.com.InputHandler;

public class StartState extends GameState{
	private String[] options = {
			"Start",
			"Exit"
	};
	private int currentOption = 0;

	public StartState(InputHandler i){
		super(i);
	}
	
	public void tick() {
		if(i.down.clicked){
			currentOption++;
			
			if(currentOption >= options.length){
				currentOption = 0;
			}
		}
		if(i.up.clicked){
			currentOption--;
			
			if(currentOption < 0){
				currentOption = options.length - 1;
			}
		}
		
		System.out.println(currentOption);
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.drawString(GameMain.NAME, GameMain.WIDTH/2, GameMain.HEIGHT/2);
		
		for(int i = 0; i < options.length; i++){
			if(currentOption == i){
				g.setColor(Color.green);
			}else{
				g.setColor(Color.red);
			}
			
			g.drawString(options[i], GameMain.WIDTH/2, GameMain.HEIGHT/4 + 15 * i);
		}
	}
	
}
