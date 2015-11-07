package org.sweatyink.com;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import org.sweatyink.com.core.GameStateManager;

public class GameMain extends Canvas implements Runnable{
	private static final long serialVersionUID = 3325571184092106015L;

	public static final String NAME = "Exit Strategy"; 
	public static final int WIDTH = 1400; 
	public static final int HEIGHT = 800; 
	
	private boolean running = false;
	private Thread t;
	private GameStateManager m;
	
	public GameMain(){
		m = new GameStateManager();
	}
	
	private void tick(){
		m.tick();
	}
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		m.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public synchronized void start(){
		if(!running)
			running = true;
		t = new Thread(this);
		t.start();
	}
	
	public synchronized void stop(){
		if(running){
			try{
				running = false;
				t.join();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return;
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double delta = 0;
		double amountOfTicks = 60.0;
		double ns = 1000000000.0 / amountOfTicks;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running){
				render();
				frames++;
				
				if(System.currentTimeMillis() - timer > 1000){
					timer += 1000;
					frames = 0;
				}
			}
		}
		stop();
	}

	public static void main(String args[]){
		JFrame window = new JFrame(NAME);
		GameMain game = new GameMain();
		
		window.setSize(WIDTH, HEIGHT);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
		window.add(game);
		
		game.start();
	}
}
