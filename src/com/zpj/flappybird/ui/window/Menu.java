package com.zpj.flappybird.ui.window;

import javax.swing.*;
import java.awt.*;

public class Menu {
    private final Image[] IMG_GUID ={
            new ImageIcon("images/guid1.png").getImage(),
            new ImageIcon("images/guid2.png").getImage(),
            new ImageIcon("images/guid3.png").getImage(),
    };
    private final int MENU_STATE_1 = 0;
    private final int MENU_STATE_2 = 1;
    private final int MENU_STATE_3 = 2;
    private int MENU_STATE=0;
    private int count;
    public void draw(Graphics g) {
        g.drawImage(IMG_GUID[MENU_STATE], 0, 0, null);
    }

    public void logic() {
        count++;
        if(count%4==0) {
            MENU_STATE++;
        }
        if(MENU_STATE>=3) {
            MENU_STATE=0;
        }
    }
}
