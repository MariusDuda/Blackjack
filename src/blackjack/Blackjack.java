package blackjack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

public class Blackjack extends JFrame implements ActionListener {
    
    Graphics g;

    private Kalade kalade;

    private Zaidejas dyleris = new Zaidejas(20, 20);
    private Zaidejas losejas = new Zaidejas(20, 150);

    private Piesti piesti = new Piesti();

    JButton traukti = new JButton("Traukti");
    JButton uztenka = new JButton("Uztenka");
    JButton dalinti = new JButton("Dalinti");

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        blackjack.zaidimas();
    }

    public void zaidimas() {
        piesimas(piesti);
        traukti.addActionListener(this);
        uztenka.addActionListener(this);
        dalinti.addActionListener(this);
        traukti.setEnabled(false);
        uztenka.setEnabled(false);
    }

    private void piesimas(Piesti piesti) {
        piesti.paruosti();
        piesti.mygtukas(20, 300, 100, 40, traukti);
        piesti.mygtukas(140, 300, 100, 40, uztenka);
        piesti.mygtukas(460, 300, 100, 40, dalinti);
        piesti.prideti(traukti);
        piesti.prideti(uztenka);
        piesti.prideti(dalinti);
    }

    private void traukti(Zaidejas asmuo) throws IOException {
        asmuo.traukti(kalade.Traukti());
        asmuo.piesti(piesti);
    }

    private void dalinti() throws IOException {
        losejas.reset();
        dyleris.reset();
        kalade = new Kalade();
        kalade.Ismaisyti();
        traukti(losejas);
        traukti(dyleris);
        traukti(losejas);
        traukti(dyleris);
    }

    private void laimetojas() {
        if (losejas.suma() > 21) {
            showMessageDialog(null, "Zaidejas istrauke per daug");
        } else if (dyleris.suma() > 21) {
            showMessageDialog(null, "Dyleris istrauke per daug");
        } else if (losejas.suma() == dyleris.suma()) {
            showMessageDialog(null, "Lygiosios");
        } else if (losejas.suma() > dyleris.suma()) {
            showMessageDialog(null, "Zaidejas laimejo");
        } else {
            showMessageDialog(null, "Dyleris laimejo");
        }
        try {
            piesti.valyti();
        } catch (IOException ex) {
            Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == traukti) {
            try {
                traukti(losejas);
                if (losejas.suma() > 21) {
                    laimetojas();
                    traukti.setEnabled(false);
                    uztenka.setEnabled(false);
                    dalinti.setEnabled(true);
                }
            } catch (IOException ex) {
                Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == uztenka) {
            while (dyleris.suma() < 17) {
                try {
                    traukti(dyleris);
                } catch (IOException ex) {
                    Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            laimetojas();
            traukti.setEnabled(false);
            uztenka.setEnabled(false);
            dalinti.setEnabled(true);
        }

        if (e.getSource() == dalinti) {
            try {
                dalinti();
                traukti.setEnabled(true);
                uztenka.setEnabled(true);
                dalinti.setEnabled(false);
            } catch (IOException ex) {
                Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
