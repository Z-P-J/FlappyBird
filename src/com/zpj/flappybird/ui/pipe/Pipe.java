package com.zpj.flappybird.ui.pipe;

import com.zpj.flappybird.utils.ImgLoader;
import com.zpj.flappybird.utils.Log;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Pipe {

    private static final String TAG = "Pipe";
    private BufferedImage image;
    private int x, y;
    private int width, height;
    /** 柱子中间的缝隙 */
    private int gap;
    private int distance;//距离，两个柱子之间的距离
    private Random random = new Random();

    /** 构造器：初始化数据，n代表第几个柱子 */
    public Pipe(int n) {
        image = ImgLoader.loadImg("pipe.png");
        width = image.getWidth();
        height = image.getHeight();
        gap = 144;
        distance = 245;
        x = 550 + (n - 1) * distance;
        y = random.nextInt(218) + 132;
        Log.d(TAG, "width:" + width + " height:" + height + " x:" + x + " y:" + y);
    }

    //在Column中添加方法 step，在action调用此方法
    public void move(){
        x --;
        if(x == - width / 2){
            x = distance * 2 - width / 2;
            y = random.nextInt(218) + 132;
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

    public int getGap() {
        return gap;
    }
}
