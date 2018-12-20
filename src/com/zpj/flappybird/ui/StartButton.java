package com.zpj.flappybird.ui;

import com.zpj.flappybird.utils.ImgLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartButton extends JButton {

    public StartButton() {
        Icon icon = ImgLoader.loadIcon("start.png");
        this.setIcon(icon);
        setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        this.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
            }
        });
    }

}
