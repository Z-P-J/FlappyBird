package com.zpj.flappybird.ui.ground;

import com.zpj.flappybird.utils.ImgLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/** 地面类 */
public class Ground{

	BufferedImage image;
	private int x, y;
	private int width;
	private int height;

	public Ground() {
		image = ImgLoader.loadImg("ground.png");
		width = image.getWidth();
		height = image.getHeight();
		x = 0;
		y = 500;
	}

	//地面移动一步
	public void move(){
		x--;
		if(x==-109){
			x = 0;
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
