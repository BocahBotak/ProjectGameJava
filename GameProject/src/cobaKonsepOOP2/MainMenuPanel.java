package cobaKonsepOOP2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {

	private JLabel title;
	private JLabel play;
	private JLabel exit;
	private Plane player;
	
	public MainMenuPanel() {
		setLayout(null);
		setBackground(Color.BLACK);
		
		player = new Plane(600, 175);
		
		title = new JLabel("Boomtastic Planet Plane of Galaxiest Monster in"
				+ " Super Fantastic Stadium", JLabel.CENTER);
		title.setBounds(350, 100, 700, 50);
		title.setFont(new Font("Arial", Font.BOLD, 16));
		title.setForeground(Color.WHITE);
		add(title);
		
		play = new JLabel("Play", JLabel.CENTER);
		play.setBounds(675, 400, 50, 50);
		play.setFont(new Font("Arial", Font.BOLD, 16));
		play.setForeground(Color.WHITE);
		play.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				play.setForeground(Color.white);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				play.setForeground(Color.cyan);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// ubah scene
				Main.frame.remove(MainMenuPanel.this);
				JPanel panel = new GamePanel();
				Main.frame.add(panel);
				panel.requestFocus();
				Main.frame.validate();
			}
		});
		add(play);
		
		exit = new JLabel("Exit", JLabel.CENTER);
		exit.setBounds(675, 500, 50, 50);
		exit.setFont(new Font("Arial", Font.BOLD, 16));
		exit.setForeground(Color.WHITE);
		exit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setForeground(Color.white);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setForeground(Color.cyan);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exit);
	}
}
