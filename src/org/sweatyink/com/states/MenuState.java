package org.sweatyink.com.states;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.sweatyink.com.GameMain;
import org.sweatyink.com.InputHandler;
import org.sweatyink.com.core.GameStateManager;

public class MenuState extends GameState {
	
	JFrame frame = new JFrame();
	JButton startButton = new JButton();
	JButton exitButton = new JButton();
	
	class Mouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getComponent() == startButton){
				m.setState(1);
			}else if (e.getComponent() == exitButton){
				System.exit(0);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}
	}
	
	Mouse mouse = new Mouse();
	
	public MenuState(String name, int ID, InputHandler i, GameStateManager m)
	{
		super("Menu Screen", 3, i, m);
		frame.setSize(GameMain.WIDTH, GameMain.HEIGHT);
		frame.setBackground(Color.black);
		frame.setVisible(true);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		startButton.setText("Start Game");
		startButton.setBounds(GameMain.WIDTH / 2, GameMain.HEIGHT / 2, 200, 100);
		startButton.setBackground(Color.white);
		startButton.addMouseListener(mouse);
		frame.add(startButton);
		
		exitButton.setText("Exit Game");
		exitButton.setBounds( (GameMain.WIDTH / 2) - 100, (GameMain.HEIGHT / 2) - 100, 200, 100 );
		exitButton.setBackground(Color.white);
		startButton.addMouseListener(mouse);
		frame.add(exitButton);
	}

}
