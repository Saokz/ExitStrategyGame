package org.sweatyink.com.entity;

import javax.swing.*;

import java.awt.*;


public class GameRectangle extends GameObject{
	
	public GameRectangle(int x, int y, int height, int width) {
		super(x, y, height, width);
		// TODO Auto-generated constructor stub
	}

	public int generateRectNumber(){
	
	int numRam = 0;	
		
	numRam = (int)(Math.random() * 4);
	
	return numRam;
	
	}

}
