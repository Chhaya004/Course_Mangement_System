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
public class image2 extends JPanel{
    private ImageIcon i1;
    public image2(){
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        i1=new ImageIcon(getClass().getResource("..\\img\\v2.jpg"));
        i1.paintIcon(this, grphcs, 300, 300);
    }
    
}
