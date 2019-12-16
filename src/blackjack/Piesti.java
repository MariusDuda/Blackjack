package blackjack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Piesti {

    int x, y, plotis, aukstis;
    JFrame f = new JFrame();

    public void paruosti() {
        f.setTitle("Blackjack");
        f.setSize(600, 400);
        f.setBounds(10, 10, 600, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void mygtukas(int x, int y, int plotis, int aukstis, JButton mygtukas) {
        mygtukas.setBounds(x, y, plotis, aukstis);
    }

    public void prideti(JButton mygtukas) {
        f.add(mygtukas);
    }

    public void nuotrauka(int x, int y, String nuotr) throws IOException {
        BufferedImage myPicture = ImageIO.read(new File("src/blackjack/Kortos/" + nuotr));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        f.add(picLabel);
        picLabel.setBounds(x, y, 100, 100);
        f.setComponentZOrder(picLabel, 0);
    }
    public void skaicius(int x, int y, String nuotr) throws IOException {
        BufferedImage myPicture = ImageIO.read(new File("src/blackjack/Kortos/" + nuotr));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        f.add(picLabel);
        picLabel.setBounds(x, y, 50, 50);
        f.setComponentZOrder(picLabel, 0);
    }

    public void valyti() throws IOException {
        BufferedImage myPicture = ImageIO.read(new File("src/blackjack/Kortos/fonas.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        f.add(picLabel);
        picLabel.setBounds(20, 20, 558, 272);
        f.setComponentZOrder(picLabel, 0);
        
    }

}
