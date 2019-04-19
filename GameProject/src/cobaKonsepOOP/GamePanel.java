package cobaKonsepOOP;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private Vector<Rectangle> peluru1 = new Vector<Rectangle>();
	private Vector<Rectangle> peluru2 = new Vector<Rectangle>();
	private Vector<Rectangle> peluru3 = new Vector<Rectangle>();
	private ImageIcon bg = new ImageIcon("background.jpg");
	private ImageIcon img = new ImageIcon("pesawat.png");
	private Plane player = new Plane(1000, 100, 200, 600);
	private int w = img.getIconWidth()/3;
	private int h = img.getIconHeight()/8;
	private int xgambar = 0;
	private int skill = 1;

	public int getXgambar() {
		return xgambar;
	}
	
	private KeyListener control = new KeyListener() {
		
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
			System.out.println(player.x + " " + player.y);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				if (player.x - 20 - w/2 >= 0) {
					player.x -= 20;
				}
				break;
			case KeyEvent.VK_D:
				if (player.x + w/2+ 20 <= 380) {
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
					peluru1.add(new Rectangle((int) player.x, player.y - 5, 2, 5));
				} 
//				else if (skill == 2) {
//					peluru1.add(new Rectangle((int) player.getCenterX(), player.y - 5, 2, 5));
//					peluru2.add(new Rectangle((int) player.getCenterX(), player.y - 5, 2, 5));
//					peluru3.add(new Rectangle((int) player.getCenterX(), player.y - 5, 2, 5));
//				} else if (skill == 3) {
//					peluru1.add(new Rectangle((int) player.getCenterX(), player.y - 5, 2, 5));
//				}
				break;
			default:
				break;
			}
			repaint();
		}
	};

	public GamePanel() {
		addKeyListener(control);
		setFocusable(true);
		move.start();
		shoot.start();
	}
	
	private Thread move = new Thread(()->{
		while(true) {
			xgambar++;
			xgambar %= 3;
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	
	private Thread shoot = new Thread(()->{
		while (true) {
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
		super.paint(g);
		g.clearRect(0, 0, 1000, 1000);
//		System.out.println(player.x + " " + player.y);
//		g.drawImage(bg.getImage(), 0, 0, 400, 700, 750, 210, 1200, 1000, null);
		g.drawImage(bg.getImage(), 0, 0, 400, 700, (bg.getIconWidth()-400)/2,
				(bg.getIconHeight()-700)/2, ((bg.getIconWidth()-400)/2)+400,
				((bg.getIconHeight()-700)/2)+700, null);
		g.drawImage(img.getImage(), player.getX() - w/2, player.getY() - h/2,
				player.getX() + w/2, player.getY() + h/2,
				xgambar * w, 0, xgambar * w + w, h, null);
	}

	public ImageIcon getBg() {
		return bg;
	}

	public ImageIcon getImg() {
		return img;
	}

	public Plane getPlayer() {
		return player;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}
}