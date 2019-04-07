package cobaKonsepOOP;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JFrame {

	private ImageIcon bg = new ImageIcon("background.jpg");
	private ImageIcon img = new ImageIcon("pesawat.png");
	private Plane player = new Plane(1000, 100, 200, 600);
	private Bullet peluru1 = new Bullet(peluru1);
	private int w = img.getIconWidth()/3;
	private int h = img.getIconHeight()/8;
	private int xgambar = 0;

	public int getXgambar() {
		return xgambar;
	}
	
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
			System.out.println(player.x + " " + player.y);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				if (player.y - 20 > 350) {
					player.y -= 20;
				}
				break;
			case KeyEvent.VK_A:
				if (player.x - 20 - w/2 >= 0) {
					player.x -= 20;
				}
				break;
			case KeyEvent.VK_S:
				if (player.y + h + 20 <= 700) {
					player.y += 20;
				}
				break;
			case KeyEvent.VK_D:
				if (player.x + w/2+ 20 <= 400) {
					player.x += 20;
				}
				break;
			case KeyEvent.VK_1:
//				skill = 1;
				break;
			case KeyEvent.VK_2:
//				skill = 2;
				break;
			case KeyEvent.VK_3:
//				skill = 3;
				break;
			case KeyEvent.VK_SPACE:
//				if (skill == 1) {
					peluru1.add(new Rectangle((int) player.getCenterX(), player.y - 5, 2, 5));
//				} else if (skill == 2) {
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
		setTitle("Boomtastic Planet Plane of Galaxiest Monster in Super Fantastic Stadium");
		setSize(400, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		addKeyListener(control);
		move.start();
	}
	
	Thread move = new Thread(()->{
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

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.clearRect(0, 0, 1000, 1000);
//		System.out.println(player.x + " " + player.y);
//		g.drawImage(bg.getImage(), 0, 0, 400, 700, 750, 210, 1200, 1000, null);
		g.drawImage(bg.getImage(), 0, 0, 400, 700, (bg.getIconWidth()-400)/2,
				(bg.getIconHeight()-700)/2, ((bg.getIconWidth()-400)/2)+400,
				((bg.getIconHeight()-700)/2)+700, null);
		g.drawImage(img.getImage(), player.getX() - w/2, player.getY(),
				player.getX() + w/2, player.getY() + h,
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