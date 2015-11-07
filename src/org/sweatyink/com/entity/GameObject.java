package org.sweatyink.com.entity;

import java.awt.Graphics;

public class GameObject {
	protected int x, y, velX, velY;
	protected int height, width;
	
	public GameObject(int x, int y, int height, int width){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void render(Graphics g) {
		
	}

	public void tick() {
		
	}
}
