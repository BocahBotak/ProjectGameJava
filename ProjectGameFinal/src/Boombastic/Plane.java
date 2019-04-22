package Boombastic;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plane extends Characters{

	public Plane(Point point) {
		super(point, 0);
		index = 0;
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return super.width;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return super.length;
	}

	@Override
	public int getCol() {
		// TODO Auto-generated method stub
		return super.col;
	}

	@Override
	public int getRow() {
		// TODO Auto-generated method stub
		return super.row;
	}

	@Override
	public Point getPoint() {
		// TODO Auto-generated method stub
		return super.point;
	}
	
	@Override
	public void setPoint(Point point) {
		// TODO Auto-generated method stub
		this.point = point;
	}

	@Override
	public void setIndex(int index) {
		// TODO Auto-generated method stub
		this.index = index;
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return super.index;
	}
}
