package com.zpj.flappybird.ui.window;

import javax.swing.*;
import java.awt.*;

public class Background {

    private final Image IMG_BG = new ImageIcon("images/bg.png").getImage();
    private int firstBgX=-IMG_BG.getWidth(null),secBgX=0;
    private int rollingSpeed = 6;

    public void draw(Graphics g) {
        g.drawImage(IMG_BG, firstBgX, 0, null);
        g.drawImage(IMG_BG, secBgX, 0, null);
    }

    public void logic() {
        firstBgX+=rollingSpeed;
        secBgX+=rollingSpeed;
        if(firstBgX==0) {
            secBgX = -IMG_BG.getWidth(null);
        }
        if(firstBgX==IMG_BG.getWidth(null)) {
            firstBgX = -IMG_BG.getWidth(null);
        }
    }

}
