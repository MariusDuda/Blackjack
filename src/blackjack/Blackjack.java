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
    
    private final String dylerisTextas = "Dylerio kortos.  Laimeta kartu: ";
    private final String losejasTextas = "Losejo kortos.  Laimeta kartu: ";
    private final int xLosejas = 20;
    private final int yLosejas = 190;
    private final int xDyleris = 20;
    private final int yDyleris = 60;
    private final int maxSuma = 21;
    private int dylerisLaimejo = 0;
    private int losejasLaimejo = 0;

    private Kalade kalade;

    private Dyleris dyleris = new Dyleris();
    private Losejas losejas = new Losejas();

    private Piesti piesti = new Piesti();

    JButton traukti = new JButton("Traukti");
    JButton uztenka = new JButton("Uztenka");
    JButton dalinti = new JButton("Dalinti");
    JLabel dylerisUzrasas = new JLabel(dylerisTextas + dylerisLaimejo);
    JLabel losejasUzrasas = new JLabel(losejasTextas + losejasLaimejo);

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        blackjack.zaidimas();
    }

    public void zaidimas() {
        piesimas(piesti);
        traukti.addActionListener(this);
        uztenka.addActionListener(this);
        dalinti.addActionListener(this);
        leistiDalinti(true);
    }

    private void piesimas(Piesti piesti) {
        piesti.paruosti();
        piesti.mygtukas(20, 300, 100, 40, traukti);
        piesti.mygtukas(140, 300, 100, 40, uztenka);
        piesti.mygtukas(460, 300, 100, 40, dalinti);
        piesti.textas(xDyleris, yDyleris - 65, 200, 40, dylerisUzrasas);
        piesti.textas(xLosejas, yLosejas + 65, 200, 40, losejasUzrasas);
        piesti.prideti(traukti);
        piesti.prideti(uztenka);
        piesti.prideti(dalinti);
        piesti.prideti(dylerisUzrasas);
        piesti.prideti(losejasUzrasas);
    }

    private void traukti(Losejas asmuo) throws IOException {
        asmuo.traukti(kalade.Traukti());
        asmuo.piesti(piesti, xLosejas, yLosejas);
    }

    private void traukti(Dyleris asmuo) throws IOException {
        asmuo.traukti(kalade.Traukti());
        asmuo.piesti(piesti, xDyleris, yDyleris);
    }

    private void trauktiDyleris(Dyleris dyleris) throws IOException {
        while (dyleris.galiTraukti()) {
            dyleris.traukti(kalade.Traukti());
            dyleris.piesti(piesti, xDyleris, yDyleris);
        }
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
    
    private void atnaujintiTexta(){
        dylerisUzrasas.setText(dylerisTextas + dylerisLaimejo);
        losejasUzrasas.setText(losejasTextas + losejasLaimejo);
    }

    private void laimetojas() {
        if (losejas.suma() > maxSuma) {
            showMessageDialog(null, "Zaidejas istrauke per daug");
            dylerisLaimejo++;
        } else if (dyleris.suma() > maxSuma) {
            showMessageDialog(null, "Dyleris istrauke per daug");
            losejasLaimejo++;
        } else if (losejas.suma() == dyleris.suma()) {
            showMessageDialog(null, "Lygiosios");
        } else if (losejas.suma() > dyleris.suma()) {
            showMessageDialog(null, "Zaidejas laimejo");
            losejasLaimejo++;
        } else {
            showMessageDialog(null, "Dyleris laimejo");
            dylerisLaimejo++;
        }
        try {
            piesti.valyti();
            atnaujintiTexta();
        } catch (IOException ex) {
            Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void leistiDalinti(boolean leisti) {
        if (leisti == true) {
            traukti.setEnabled(false);
            uztenka.setEnabled(false);
            dalinti.setEnabled(true);
        } else {
            traukti.setEnabled(true);
            uztenka.setEnabled(true);
            dalinti.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == traukti) {
            try {
                traukti(losejas);
                if (losejas.suma() > maxSuma) {
                    laimetojas();
                    leistiDalinti(true);
                }
            } catch (IOException ex) {
                Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == uztenka) {
            try {
                trauktiDyleris(dyleris);
            } catch (IOException ex) {
                Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
            }
            laimetojas();
            leistiDalinti(true);
        }

        if (e.getSource() == dalinti) {
            try {
                dalinti();
                leistiDalinti(false);
            } catch (IOException ex) {
                Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
