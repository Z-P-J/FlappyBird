package com.zpj.flappybird;

import com.zpj.flappybird.setting.Setting;
import com.zpj.flappybird.ui.StartButton;
import com.zpj.flappybird.ui.window.GamePanel;
import javax.swing.*;

public class FlappyBird {

    /** 运行游戏 */
    public static void main(String[] args)
            throws Exception {
        JFrame frame = new JFrame();
        GamePanel game = new GamePanel();
        frame.add(game);
        frame.setSize(Setting.screenWidth, Setting.screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        StartButton startButton = new StartButton();
        startButton.setVisible(true);
        frame.getContentPane().add(startButton);

        game.action();
    }

}
