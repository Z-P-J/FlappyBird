package com.zpj.flappybird.ui.window;

import com.zpj.flappybird.setting.Setting;
import com.zpj.flappybird.ui.bird.Bird;
import com.zpj.flappybird.ui.ground.Ground;
import com.zpj.flappybird.ui.pipe.Pipe;
import com.zpj.flappybird.utils.ImgLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    private Bird bird;
    private Pipe pipe1, pipe2;
    private Ground ground;
    private boolean started;
    private BufferedImage background;
    private BufferedImage gameoverImg;
    private BufferedImage startImg;
    //分数
    int score;

    /** 初始化 BirdGame 的属性变量 */
    public GamePanel() {
       initGame();
    }

    private void initGame() {
        score = 0;
        bird = new Bird();
        pipe1 = new Pipe(1);
        pipe2 = new Pipe(2);
        ground = new Ground();
        background = ImgLoader.loadImg("bg.png");
        gameoverImg = ImgLoader.loadImg("gameover.png");
        startImg = ImgLoader.loadImg("start.png");
    }

    /** "重写(修改)"paint方法实现绘制 */
    public void paint(Graphics g){
        g.drawImage(background, 0, 0, null);
        paintPipe(g, pipe1);
        paintPipe(g, pipe2);
        //在paint方法中添加绘制分数的算法
        Font f = new Font(Font.SANS_SERIF,
                Font.BOLD, 40);
        g.setFont(f);
        g.drawString(""+score, 40, 60);
        g.setColor(Color.WHITE);
        g.drawString(""+score, 40-3, 60-3);

        g.drawImage(ground.getImage(), ground.getX(),
                ground.getY(), null);
        if (Setting.isGameOver){
            if (Setting.isFirst) {
                g.drawImage(startImg, 0, 0, null);
//                Setting.isFirst = false;
            } else
                g.drawImage(gameoverImg,0,0,null);
            return;
        }
        //旋转(rotate)绘图坐标系，是API方法
        Graphics2D g2 = (Graphics2D)g;
        g2.rotate(-bird.getAlpha(), bird.getX(), bird.getY());
        g.drawImage(bird.getImage(),
                bird.getX() - bird.getWidth() / 2,
                bird.getY() - bird.getHeight() / 2, null);
        g2.rotate(bird.getAlpha(), bird.getX(), bird.getY());
    }
    //BirdGame中添加方法action()
    public void action() throws Exception {

        //游戏面板添加游戏点击事件
        addMouseListener(new MouseAdapter(){
            //鼠标按下
            public void mousePressed(MouseEvent e){
                if (Setting.isFirst) {
                    started = false;
                    bird.flappy();
                    Setting.isFirst = false;
                    Setting.isGameOver = false;
                } else if (Setting.isGameOver) {
                    //鸟向上飞扬
                    started = true;
//                    bird.flappy();
                    initGame();
                    Setting.isGameOver = false;
                } else {
                    //鸟向上飞扬
                    started = true;
                    bird.flappy();
                }
            }
        });

        while(true){

            //计分逻辑
            if(!Setting.isGameOver || !Setting.isFirst){
                ground.move();
                pipe1.move();
                pipe2.move();
                bird.move();
            }
            bird.fly();
            ground.move();

            if(bird.hit(ground) || bird.hit(pipe1)||bird.hit(pipe2)){
                Setting.isGameOver = true;
                started = false;
            }
            bird.fly();
            if (!Setting.isGameOver && (bird.getX() == pipe1.getX() || bird.getX() == pipe2.getX())){
                score++;
            }
            repaint();
            Thread.sleep(1000 / 60);
        }
    }

    private void paintPipe(Graphics graphics, Pipe pipe) {
        graphics.drawImage(pipe.getImage(),
                pipe.getX()-pipe.getWidth() / 2,
                pipe.getY()-pipe.getHeight() / 2, null);
    }
}
