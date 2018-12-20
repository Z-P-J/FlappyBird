package com.zpj.flappybird.ui.bird;

import com.zpj.flappybird.ui.ground.Ground;
import com.zpj.flappybird.ui.pipe.Pipe;
import com.zpj.flappybird.utils.ImgLoader;
import com.zpj.flappybird.utils.Log;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Bird {

    private static final String TAG = "Bird";
    private BufferedImage image;
    private int x,y;
    private int width, height;
    private int size;//鸟的大小，用于碰撞检测

    //在Bird类中增加属性，用于计算鸟的位置
    private double g;//  重力加速度
    private double t;//  两次位置的间隔时间
    private double v0;// 初始上抛速度
    private double speed;// 是当前的上抛速度
    private double s;//     是经过时间t以后的位移
    private double alpha;// 是鸟的倾角 弧度单位
    //在Bird类中定义
    //定义一组（数组）图片，是鸟的动画帧
    private BufferedImage[] images;
    //是动画帧数组元素的下标位置
    private int index;

    public Bird() {
        image = ImgLoader.loadImg("0.png");
        width = image.getWidth();
        height = image.getHeight();
        Log.d(TAG, "width:" + width + " height:" + height);
        x = 132;
        y = 280;
        size = 10;
        g = 1;
        v0 = 10;
        t = 0.25;
        speed = v0;
        s = 0;
        alpha = 0;
        //创建数组,创建8个元素的数组
        //是8个空位置，没有图片对象，
        //8个位置的序号: 0 1 2 3 4 5 6 7
        images = new BufferedImage[8];
        for(int i = 0; i < 8; i++){
            //i = 0 1 2 3 4 5 6 7
            images[i] = ImgLoader.loadImg( i + ".png");
        }
        index = 0;
    }
    //在Bird中添加飞翔(fly)的代码
    public void fly(){
        index++;
        image = images[(index/12) % 8];
    }
    //在Bird中添加鸟的移动方法
    public void move(){
        double v0 = speed;
        s = v0 * t + g * t * t / 2;//计算上抛运动位移
        y = y - (int)s;//计算鸟的坐标位置
        double v = v0 - g * t;//计算下次的速度
        speed = v;
//		if(y>=500){//如果到达地面，就重新抛起
//			y = 280;
//			speed = 35;
//		}
        //调用Java API提供的反正切函数，计算倾角
        alpha = Math.atan(s / 8);
        Log.d(TAG, "alpha:" + alpha);
    }
    //在Bird中添加方法
    public void flappy(){
        //重新设置初始速度，重新向上飞
        speed = v0;
    }

    //在鸟中添加方法hit
    // 检测当前鸟是否碰到地面ground
    //如果返回true表示发生碰撞
    //否则返回false表示没有碰撞
    public boolean hit (Ground ground){
        boolean hit = y + size / 2 > ground.getY();
        if(hit){
            y = ground.getY() - size / 2;
        }
        return hit;
    }
    //检测当前鸟是否撞倒柱子
    public boolean hit(Pipe column){
        //先检查是否在柱子的范围以内
        if  (x > column.getX() - column.getWidth() / 2 - size / 2 && x < column.getX()
                + column.getWidth() / 2 + size / 2){
            return y <= column.getY() - column.getGap() / 2 + size / 2 || y >= column.getY() + column.getGap() / 2 - size / 2;
        }
        return false;
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

    public int getSize() {
        return size;
    }

    public double getG() {
        return g;
    }

    public double getT() {
        return t;
    }

    public double getV0() {
        return v0;
    }

    public double getSpeed() {
        return speed;
    }

    public double getS() {
        return s;
    }

    public double getAlpha() {
        return alpha;
    }

    public BufferedImage[] getImages() {
        return images;
    }

    public int getIndex() {
        return index;
    }
}
