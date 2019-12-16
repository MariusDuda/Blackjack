package blackjack;

import java.io.IOException;

public class Korta {

    private int rusis;
    private int verte;
    private String rusisPav;
    private String vertePav;

    Korta(int korta) {
        this.verte = korta % 13;
        this.rusis = korta / 13;
        this.rusisPav = rusis + ".jpg";
        if (rusis < 2) {
            vertePav = verte + "r.jpg";
        } else {
            vertePav = verte + "j.jpg";
        }
    }

    public boolean tuzas() {
        return verte == 12;
    }

    public int verte() {
        if (verte == 12) {
            return 1;
        }
        if (verte >= 8) {
            return 10;
        }
        return verte + 2;
    }

    public void piesti(Piesti p, int x, int y) throws IOException {
        p.nuotrauka(x, y + 20, rusisPav);
        p.skaicius(x + 50, y + 20, vertePav);
    }

}
