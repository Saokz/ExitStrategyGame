package org.sweatyink.com.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.sweatyink.com.GameMain;
import org.sweatyink.com.core.Handler;
import org.sweatyink.com.states.PlayState;

public class Player extends GameObject implements KeyListener{
	private GameMain gm;
	private Handler h;
	private PlayState ps;
	
	public Player(int playerX, int playerY, int playerHeight, int playerWidth, GameMain g, Handler h, PlayState ps)
	{
		super(playerX, playerY, playerHeight, playerWidth);
		x = playerX;
		y = playerY;
		height = playerHeight;
		width = playerWidth;
		gm = g;
		this.h = h;
		this.ps = ps;
		g.addKeyListener(this);
	}
	
	public int getX(){return x;}
	public int getY(){return y;}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moveLeft();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moveRight();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moveUp();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			moveDown();
		}
		
	}
	
	public void tick(){
		for(int i = 0; i < h.objects.size(); i++){
			GameObject o = h.objects.get(i);
			if(o instanceof Walls){
				if(o.getBounds().intersects(getBounds())){
					ps.reset(gm);
				}
			}
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	};
	
	private void moveLeft(){x -= 20;}
	private void moveRight(){x += 20;}
	private void moveUp(){y += 20;}
	private void moveDown(){y -= 20;}
	
}
