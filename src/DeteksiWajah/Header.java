/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DeteksiWajah;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Syem
 */
public class Header extends JLabel{
//    public static void main(String[] args) {
//        JFrame jf = new JFrame();
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jf.setBounds(100, 100, 300, 300);
//        jf.add(new Header());
//        jf.setVisible(true);
//    }
//    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        final ImageIcon gambar = new ImageIcon(getClass().getResource("Header.jpg"));
        final Graphics2D g2 = (Graphics2D) g.create();
//        g2.setPaint(new GradientPaint(0, 0, Color.BLUE, 0, gambar.getHeight(null), Color.BLACK));
//        g2.fillRect(0, 0, getWidth(), getHeight());
        //g2.drawImage(EfekGambar.getEfekKaca(gambar), 1, 1, null);
    }
    
}
