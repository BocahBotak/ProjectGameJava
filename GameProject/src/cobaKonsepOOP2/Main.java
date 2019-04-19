package cobaKonsepOOP2;

import javax.swing.JFrame;

public class Main {
	
	public static JFrame frame;
	
	public Main() {
		frame = new JFrame("Boomtastic Planet Plane of Galaxiest Monster in Super Fantastic Stadium");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// full screen
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setSize(1000, 800);
		
		frame.add(new MainMenuPanel());
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
