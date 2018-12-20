package com.zpj.flappybird.utils;

import com.zpj.flappybird.FlappyBird;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImgLoader {
    /*
    图片加载工具类
     */

    private static final String TAG = "ImgLoader";

    public static BufferedImage loadImg(String imgName) {
        try {
            Log.d(TAG, FlappyBird.class.getResource("").toString());
            return ImageIO.read(FlappyBird.class.getResource("resources/" + imgName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Icon loadIcon(String imgName) {
        Log.d(TAG, FlappyBird.class.getResource("").toString());
        return new ImageIcon(FlappyBird.class.getResource("resources/" + imgName));
    }
}
