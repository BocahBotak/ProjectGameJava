package cobaLatihan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Coba2 extends JFrame {

	Rectangle player = new Rectangle();
	ImageIcon img = new ImageIcon("pesawat.png");
	ImageIcon bg = new ImageIcon("background.jpg");
	int w, h;
	int x = 0;
	int skill = 1;
	Vector<Rectangle> peluru1 = new Vector<Rectangle>();
	Vector<Rectangle> peluru2 = new Vector<Rectangle>();
	Vector<Rectangle> peluru3 = new Vector<Rectangle>();
	Vector<Rectangle> peluru4 = new Vector<Rectangle>();
	Vector<Rectangle> peluru5 = new Vector<Rectangle>();
	Vector<Rectangle> peluru6 = new Vector<Rectangle>();
	Vector<Rectangle> peluru7 = new Vector<Rectangle>();

	KeyListener control = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				if (player.y - 20 > 350) {
					player.y -= 20;
				}
				break;
			case KeyEvent.VK_A:
				if (player.x - 20 >= 0) {
					player.x -= 20;
				}
				break;
			case KeyEvent.VK_S:
				if (player.y + h + 20 <= 700) {
					player.y += 20;
				}
				break;
			case KeyEvent.VK_D:
				if (player.x + w + 20 <= 400) {
					player.x += 20;
				}
				break;
			case KeyEvent.VK_1:
				skill = 1;
				break;
			case KeyEvent.VK_2:
				skill = 2;
				break;
			case KeyEvent.VK_3:
				skill = 3;
				break;
			case KeyEvent.VK_SPACE:
				if (skill == 1) {
					peluru1.add(new Rectangle((int) player.getCenterX(), player.y - 5, 2, 5));
				} else if (skill == 2) {
					peluru1.add(new Rectangle((int) player.getCenterX(), player.y - 5, 2, 5));
					peluru2.add(new Rectangle((int) player.getCenterX(), player.y - 5, 2, 5));
					peluru3.add(new Rectangle((int) player.getCenterX(), player.y - 5, 2, 5));
				} else if (skill == 3) {
					peluru1.add(new Rectangle((int) player.getCenterX(), player.y - 5, 2, 5));
				}
				break;
			default:
				break;
			}
			repaint();
		}
	};

	Thread AI = new Thread(() -> {
		while (true) {
			x++;
			x %= 3;
			try {
				Iterator<Rectangle> it1 = peluru1.iterator();
				Iterator<Rectangle> it2 = peluru2.iterator();
				Iterator<Rectangle> it3 = peluru3.iterator();
				while (it1.hasNext()) {
					Rectangle tembak1 = (Rectangle) it1.next();
					tembak1.y -= 80;
					if (tembak1.y <= 0) {
//						peluru1.remove(tembak1);
					}
				}
				while (it2.hasNext()) {
					Rectangle tembak2 = (Rectangle) it2.next();
					tembak2.x -= 20;
					tembak2.y -= 80;
					if (tembak2.y <= 0 || tembak2.x <= 0) {
//						peluru2.remove(tembak2);
					}
				}
				while (it3.hasNext()) {
					Rectangle tembak3 = (Rectangle) it3.next();
					tembak3.x += 20;
					tembak3.y -= 80;
					if (tembak3.y <= 0 || tembak3.x >= 400) {
//						peluru3.remove(tembak3);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});

	@Override
	public void paint(Graphics g) {
//		super.paint(g);
		g.clearRect(0, 0, 1000, 1000);
		g.drawImage(bg.getImage(), 0, 0, 400, 700, 0, 0, bg.getIconWidth()/400 + 400, bg.getIconHeight()/700 + 700, null);
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, 400, 700);
		g.drawImage(img.getImage(), player.x, player.y, player.x + w, player.y + h, x * w, 0, (x * w) + w, h, null);
		for (Rectangle r1 : peluru1) {
			if (r1.y >= 0) {
				g.setColor(Color.MAGENTA);
				g.fillOval(r1.x, r1.y, r1.width, r1.height);
			}
		}
		for (Rectangle r2 : peluru2) {
			if (r2.y >= 0 && r2.x >= 0) {
				g.setColor(Color.MAGENTA);
				g.fillOval(r2.x, r2.y, r2.width, r2.height);
			}
		}
		for (Rectangle r3 : peluru3) {
			if (r3.y >= 0 && r3.x <= 400) {
				g.setColor(Color.MAGENTA);
				g.fillOval(r3.x, r3.y, r3.width, r3.height);
			}
		}
	}

	public Coba2() {
		setTitle("Boomtastic Planet Plane of Galaxiest Monster in Super Fantastic Stadium");
		setSize(400, 700);
		setLocationRelativeTo(null);
		w = img.getIconWidth() / 3;
		h = img.getIconHeight() / 8;
		player.x = 200 - w / 2;
		player.y = 600;
		player.height = h;
		player.width = w;
		addKeyListener(control);
		AI.start();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Coba2();
	}

}
