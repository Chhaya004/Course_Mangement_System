/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pes2;

import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author hema
 */
public class image extends JPanel {

    private ImageIcon i;

    public image() {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        i = new ImageIcon(getClass().getResource("..\\img\\v1.png"));// (..\\img\\v1.png)
        i.paintIcon(this, grphcs, 0, 0);
    }

}
