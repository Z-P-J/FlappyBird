//package com.zpj.flappybird.ui.window;
//
//import com.zpj.flappybird.MainActivity;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.File;
//import java.io.FileInputStream;
//
//public class OverMenu {
//    private final Image IMG_OVER = new ImageIcon("images/gameover.png").getImage();
//    private final Image IMG_OVER_BACK = new ImageIcon("images/bg.png").getImage();
//    private final Image IMG_REPLAY_BTN = new ImageIcon("images/replay.png").getImage();
//    public boolean isReplay=false;
//    public int btnX,btnY,btnW,btnH;
//    private final Image IMG_SCORE_BORAD = new ImageIcon("images/scoreboard.png").getImage();
//    private final Image IMG_MEDAL0 = new ImageIcon("images/medal0.png").getImage();
//    private final Image IMG_MEDAL1 = new ImageIcon("images/medal1.png").getImage();
//    private final Image IMG_MEDAL2 = new ImageIcon("images/medal2.png").getImage();
//    public boolean isPlayed=false;
//
//    public OverMenu() {
//        this.btnX = MainActivity.gameW/2-IMG_REPLAY_BTN.getWidth(null)/2;
//        this.btnY = MainActivity.gameH/2-IMG_OVER.getHeight(null)+160;
//        this.btnW = IMG_REPLAY_BTN.getWidth(null);
//        this.btnH = IMG_REPLAY_BTN.getHeight(null);
//    }
//
//
//
//    public void draw(Graphics g,int score) {
//        g.drawImage(IMG_OVER_BACK, 0, 0, null);
//        g.drawImage(IMG_OVER, MainActivity.gameW/2-IMG_OVER.getWidth(null)/2, MainActivity.gameH/2-IMG_OVER.getHeight(null)-140, null);
//        g.drawImage(IMG_SCORE_BORAD, MainActivity.gameW/2-IMG_OVER.getWidth(null)/2-20, MainActivity.gameH/2-IMG_OVER.getHeight(null)-40, null);
//        g.drawImage(IMG_REPLAY_BTN, MainActivity.gameW/2-IMG_REPLAY_BTN.getWidth(null)/2, MainActivity.gameH/2-IMG_OVER.getHeight(null)+160, null);
//        String sscore="";
//        if(score<10) {
//            sscore = "0"+String.valueOf(score);
//        } else {
//            sscore = String.valueOf(score);
//        }
//        g.drawString(sscore, 274,214);
//        if(score<10) {
//            g.drawImage(IMG_MEDAL2,80,200, null);
//        } else if(score<20) {
//            g.drawImage(IMG_MEDAL1,80,200, null);
//        } else {
//            g.drawImage(IMG_MEDAL2,80,200, null);
//        }
//    }
//
//    public void playDead() {
//        try {
//            FileInputStream fis = new FileInputStream(new File("sound/die.wav"));
////            Audio.player.start(fis);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        isPlayed = true;
//    }
//}
