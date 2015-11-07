package org.sweatyink.com.entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Player extends GameObject implements KeyListener{
	public Player(int playerX, int playerY, int playerHeight, int playerWidth)
	{
		super(playerX, playerY, playerHeight, playerWidth);
		x = playerX;
		y = playerY;
		height = playerHeight;
		width = playerWidth;
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
		
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			moveUp();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moveDown();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	};
	
	private void moveLeft(){x--;}
	private void moveRight(){x++;}
	private void moveUp(){y++;}
	private void moveDown(){y--;}
	
}
