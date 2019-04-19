package cobaKonsepOOP2;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plane extends Characters{

	private int x, y;
	private int col = 3;
	private int row = 8;
	private BufferedImage[][] sprites = new BufferedImage[row][col];
	private int index;
	private int direction;

	public Plane(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		index = 0;
		direction = 0;
		
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

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 80;
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 80;
	}

	@Override
	public void setLength(int length) {
		// TODO Auto-generated method stub
		
	}
}
