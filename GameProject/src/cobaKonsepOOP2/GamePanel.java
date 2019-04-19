package cobaKonsepOOP2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import java2d.GamePanel;
//import java2d.Main;
//import java2d.MainMenuPanel;

public class GamePanel extends JPanel {

	private Image background;
	private Plane player;
	private int skill = 1;
	private Vector<Bullet> bullet = new Vector<Bullet>();
	private Vector<Bullet> bullet2 = new Vector<Bullet>();
	private Vector<Bullet> bullet3 = new Vector<Bullet>();
	private Vector<Bullet> bullet4 = new Vector<Bullet>();
	private Vector<Bullet> bullet5 = new Vector<Bullet>();
	private Vector<Bullet> bullet6 = new Vector<Bullet>();
	private Vector<Bullet> bullet7 = new Vector<Bullet>();
	private Vector<Bullet> bullet8 = new Vector<Bullet>();
	private Vector<Enemy> enemies = new Vector<Enemy>();
	private boolean isInGame = true;

	Thread playerControl = new Thread(new Runnable() {

		@Override
		public void run() {
			while (isInGame) {
				player.setIndex(player.getIndex()+1);;
				try {
					Iterator<Bullet> it1 = bullet.iterator();
//					Iterator<Rectangle> it2 = peluru2.iterator();
//					Iterator<Rectangle> it3 = peluru3.iterator();
//					System.out.println("a");
//					while (it1.hasNext()) {
//						System.out.println("11");
//						Bullet tembak1 = (Bullet) it1.next();
//						tembak1.y -= 20;
//						System.out.println(tembak1.y);
//						if (tembak1.y <= 0) {
////							peluru1.remove(tembak1);
//						}
//					}
					for (int i = bullet.size() - 1; i >= 0; i--) {
//						System.out.println("11");
						Bullet tembak1 = bullet.get(i);
						tembak1.setY(tembak1.getY()-20);
						for (Enemy f : enemies) {
//							idx = -1;
							if (tembak1.getX() + tembak1.getHeight() >= f.getPoint().y
									&& tembak1.getX() <= f.getPoint().x + f.getWidth()
									&& tembak1.getX() + tembak1.getWidth() >= f.getPoint().x
									&& tembak1.getY() <= f.getPoint().y + f.getLength()) {
								bullet.remove(tembak1);
								enemies.remove(f);
								break;
							}
						}
//						System.out.println(tembak1.y);
						if (tembak1.getY() <= 0) {
//					        peluru1.remove(tembak1);
						}
					}
//					while (it2.hasNext()) {
//						Rectangle tembak2 = (Rectangle) it2.next();
//						tembak2.x -= 20;
//						tembak2.y -= 80;
//						if (tembak2.y <= 0 || tembak2.x <= 0) {
////							peluru2.remove(tembak2);
//						}
//					}
//					while (it3.hasNext()) {
//						Rectangle tembak3 = (Rectangle) it3.next();
//						tembak3.x += 20;
//						tembak3.y -= 80;
//						if (tembak3.y <= 0 || tembak3.x >= 400) {
////							peluru3.remove(tembak3);
//						}
//					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
//					Thread.sleep(1000 / 60);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
			}
		}
	});

	Thread generateEnemy = new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 7; i++) {
				Enemy a1 = new Enemy(new Point(new Random().nextInt(1000), 50));
				enemies.add(a1);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 7; i++) {
				try {
					Enemy a1 = new Enemy(new Point(new Random().nextInt(1000), 150));
					enemies.add(a1);
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 7; i++) {
				try {
					Enemy a1 = new Enemy(new Point(new Random().nextInt(1000), 250));
					enemies.add(a1);
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			for (int i = 0; i < 7; i++) {
//				try {
//					Enemy a1 = new Enemy(new Point(new Random().nextInt(1000), 350));
//					enemies.add(a1);
//					Thread.sleep(300);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			for (int i = 0; i < 7; i++) {
//				try {
//					Enemy a1 = new Enemy(new Point(new Random().nextInt(1000), 450));
//					enemies.add(a1);
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
	});

	Thread enemyThread = new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isInGame) {
				int idx = -1;
				int idxEnemy = -1;
//				System.out.println(System.currentTimeMillis());
				for (Enemy f : enemies) {
					f.setIndex(f.getIndex() + 1);
//					System.out.println(2);
					if (f.getPoint().x > 1300)
						f.setCount(-10);
					else if (f.getPoint().x < 10)
						f.setCount(+10);

					f.getPoint().x += f.getCount();

					int rand = (int) (Math.random() * 1000);

					if (rand % 30 == 0) {
						f.getBullets().add(new Bullet(f.getPoint().x + f.getWidth()/2, f.getPoint().y + f.getLength()));
					}

					for (Bullet bullet2 : f.getBullets()) {
//						try {
////							Thread.sleep(500);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						bullet2.setY(bullet2.getY() + 20);

						if (bullet2.getY() + bullet2.getHeight() >= player.getY() && bullet2.getX() <= player.getX() + player.getWidth()
								&& bullet2.getX() + bullet2.getWidth() >= player.getX() && bullet2.getY() <= player.getY() + player.getLength()) {
							isInGame = false;
						}

					}

//					for (Bullet peluru : bullet) {
////						idx = -1;
//						if (peluru.y + peluru.height >= f.getPoint().y && peluru.x <= f.getPoint().x + f.getWidth()
//								&& peluru.x + peluru.width >= f.getPoint().x
//								&& peluru.y <= f.getPoint().y + f.getLength()) {
//							idx = bullet.indexOf(peluru);
//							System.out.println("kena " + idx);
//							idxEnemy = enemies.indexOf(f);
//							break;
//						} 
//					}
				}
//				if(idx != -1)
//					bullet.remove(idx);
//				if(idxEnemy != -1)
//					enemies.remove(idxEnemy);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
			}
		}
	});

	public GamePanel() {
		try {
			BufferedImage bgBuffer = ImageIO.read(new File("assets/background.jpg"));
			background = bgBuffer.getScaledInstance(bgBuffer.getWidth(), bgBuffer.getHeight(), Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player = new Plane(700, 600);
		addKeyListener(new KeyListener() {

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
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_LEFT) {
//					player.direction = 5;
					if (player.getX() - 20 >= 0) {
						player.setX(player.getX()-20);
						player.setIndex(player.getIndex()+1);
						player.setIndex(player.getIndex()%3);
					}
				} else if (key == KeyEvent.VK_RIGHT) {
//					player.direction = 2;
					if (player.getX() + 20 <= 1306) {
						player.setX(player.getX()+20);
						player.setIndex(player.getIndex()+1);
						player.setIndex(player.getIndex()%3);
					}
//				} else if (key == KeyEvent.VK_UP) {
//					player.direction = 0;
//					if (player.y - 20 >= 0) {
//						player.y -= 20;
//						player.index++;
//						player.index %= 3;
//					}
//				} else if (key == KeyEvent.VK_DOWN) {
//					player.direction = 7;
//					if (player.y + 20 <= 688) {
//						player.y += 20;
//						player.index++;
//						player.index %= 3;
//					}
				} else if (key == KeyEvent.VK_1) {
					skill = 1;
				} else if (key == KeyEvent.VK_2) {
					skill = 2;
				} else if (key == KeyEvent.VK_3) {
					skill = 3;
				}
//				else if(key == KeyEvent.VK_SPACE) {
//					int x = player.getX() + player.width/2 - 4;
//					int y = player.getY();
//					bullet.add(new Bullet(x, y));
//					if (skill == 1) {
//						bullet.add(new Bullet(x, y));
//					} else if (skill == 2) {
//						bullet.add(new Bullet(x, y));
//						bullet2.add(new Bullet(x, y));
//						bullet3.add(new Bullet(x, y));
//					} else if (skill == 3) {
//						bullet8.add(new Bullet(x, y));
//					}
				repaint();
//				}
			}
		});

		addKeyListener(new KeyListener() {

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
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_SPACE) {
					int x = player.getX() + player.width / 2 - 4;
					int y = player.getY();
					bullet.add(new Bullet(x, y));
					if (skill == 1) {
						bullet.add(new Bullet(x, y));
					} else if (skill == 2) {
						bullet.add(new Bullet(x, y));
						bullet2.add(new Bullet(x, y));
						bullet3.add(new Bullet(x, y));
					} else if (skill == 3) {
						bullet8.add(new Bullet(x, y));
					}
				}
			}
		});

		playerControl.start();
		
		BufferedImage ss = null;
		try {
			ss = ImageIO.read(new File("assets/pesawat.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		Enemy a1 = new Enemy(ss, new Point(400, 50));

		generateEnemy.start();

		enemyThread.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		g.drawImage(player.getImage(), player.getX(), player.getY(), null);
		try {
			for (Bullet b : bullet) {
				g.drawImage(b.getImage(), b.getX(), b.getY(), null);
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			for (Enemy f : enemies) {
				g.drawImage(f.getImage(), f.getPoint().x, f.getPoint().y, null);
				for (Bullet bullet2 : f.getBullets()) {
					g.drawImage(bullet2.getImage(), bullet2.getX(), bullet2.getY(), Color.RED, null);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
