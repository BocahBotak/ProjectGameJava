package cobaKonsepOOP2;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Enemy extends Characters{

	private Point point;
	private Vector<Bullet> bullets = new Vector<Bullet>();
	private int count = +10;
	private int nembak= 0;
	private int col = 3;
	private int row = 8;
	private BufferedImage[][] sprites = new BufferedImage[row][col];
	private int index;
	private int direction;
	

	public Enemy(/*BufferedImage image,*/ Point point) {
		super();
//		this.image = image;
		this.point = point;
		index = 0;
		direction = 7;
		
		try {
			BufferedImage image = ImageIO.read(new File("assets/pesawat.png"));
			int width = image.getWidth(); // 192
			int height = image.getHeight(); // 512
			
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					sprites[i][j] = image.getSubimage(
							j*width/col, i*height/row,
							width/col, height/row);
				}
			}
			
//			System.out.println(width + ", " + height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Image getImage() {
		return sprites[direction][index%3].getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLength(int length) {
		// TODO Auto-generated method stub
		
	}

	public int getNembak() {
		return nembak;
	}
	
	public void setNembak(int nembak) {
		this.nembak = nembak;
	}
	
	public Vector<Bullet> getBullets() {
		return bullets;
	}
	
	public void setBullets(Vector<Bullet> bullets) {
		this.bullets = bullets;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getLength() {
		return length;
	}
	
	public Point getPoint() {
		return point;
	}
}
