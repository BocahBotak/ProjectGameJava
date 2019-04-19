package cobaKonsepOOP;

import javax.swing.JFrame;

public class MainGame extends JFrame {
	
	public MainGame() {		
		add(new GamePanel());
		setTitle("Boomtastic Planet Plane of Galaxiest Monster in Super Fantastic Stadium");
		setSize(400, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainGame();
	}

}
