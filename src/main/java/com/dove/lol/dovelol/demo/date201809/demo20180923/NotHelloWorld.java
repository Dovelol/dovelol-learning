package com.dove.lol.dovelol.demo.date201809.demo20180923;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dovelol
 * @date 2018/9/23 9:26
 */
public class NotHelloWorld {

    public void init() {
        EventQueue.invokeLater(() -> {
            JLabel label = new JLabel("Not a Hello, World applet", SwingConstants.CENTER);
        });
    }

}
