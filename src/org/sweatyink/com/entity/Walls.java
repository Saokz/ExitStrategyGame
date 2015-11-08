package org.sweatyink.com.entity;

import java.awt.Color;
import java.awt.Graphics;

public class Walls extends GameObject{
	private int flag;
	
	public Walls(int x, int y, int height, int width, int flag) {
		super(x, y, height, width);
		
		this.flag = flag;
	}
	
	public void render(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	public void tick(){
		x += velX;
		y += velY;
		
		System.out.println(flag+" "+velX+" "+velY);
		
			if(flag == 0){
				velX = 3;
				System.out.println(velY);
			}
			else if(flag == 1){
				velX = -3;
			}
			else if(flag == 2){
				velY = 2;
			}
			else if(flag == 3){
				velY = -2;
			}
		}
	}
