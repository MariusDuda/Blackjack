package blackjack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Piesti {

    private final int nuotraukaDim = 100;
    private final int skaiciusDim = 50;
    private final int langoPlotis = 600;
    private final int langoAukstis = 400;
    JFrame f = new JFrame();

    public void paruosti() {
        paruosti( langoPlotis, langoAukstis );
    }
    
    public void paruosti(int x, int y) {
        f.setTitle("Blackjack");
        f.setSize(x, y);
        f.setBounds(10, 10, x, y);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mygtukas(int x, int y, int plotis, int aukstis, JButton mygtukas) {
        mygtukas.setBounds(x, y, plotis, aukstis);
    }
    public void textas(int x, int y, int plotis, int aukstis, JLabel mygtukas) {
        mygtukas.setBounds(x, y, plotis, aukstis);
    }

    public void prideti(JButton mygtukas) {
        f.add(mygtukas);
    }
    public void prideti(JLabel textas) {
        f.add(textas);
    }

    public void nuotrauka(int x, int y, String nuotr) throws IOException {
        BufferedImage myPicture = ImageIO.read(new File("src/blackjack/Kortos/" + nuotr));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        f.add(picLabel);
        picLabel.setBounds(x, y, nuotraukaDim, nuotraukaDim);
        f.setComponentZOrder(picLabel, 0);
    }
    public void skaicius(int x, int y, String nuotr) throws IOException {
        BufferedImage myPicture = ImageIO.read(new File("src/blackjack/Kortos/" + nuotr));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        f.add(picLabel);
        picLabel.setBounds(x, y, skaiciusDim, skaiciusDim);
        f.setComponentZOrder(picLabel, 0);
    }

    public void valyti() throws IOException {
        BufferedImage myPicture = ImageIO.read(new File("src/blackjack/Kortos/fonas.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        f.add(picLabel);
        picLabel.setBounds(20, 60, 558, 230);
        f.setComponentZOrder(picLabel, 0);
        
    }

}
