/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Cristi
 */
public class ImagePanel extends javax.swing.JPanel {
    
    private final Image background;
    
    public ImagePanel(String filename) throws IOException{
        background = ImageIO.read(new File(filename));
    
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
    }

}
