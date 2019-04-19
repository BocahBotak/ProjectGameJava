package cobaKonsepOOP2;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Bullet {

	private int x, y;
	private int width = 7;
	private int height = 7;
	private BufferedImage[] bullet = new BufferedImage[1];

	public Bullet(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		try {
			bullet[0] = ImageIO.read(new File("assets/shot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Image getImage() {
		return bullet[0].getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
