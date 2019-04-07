package cobaKonsepOOP;

import javax.swing.JFrame;

public class MainGame extends JFrame {
	
	public MainGame() {		
		new GamePanel();
	}

	public static void main(String[] args) {
		new MainGame();
	}

}
