package blackjack;

import java.io.IOException;

public class Korta {
    
    private final int tuzoVerte = 12;
    private final int verciuSkaicius = 13;
    private final int numeriuSkaicius = 8;
    private final int rusis;
    private final int verte;
    private final String rusisPav;
    private final String vertePav;

    Korta(int korta) {
        this.verte = korta % verciuSkaicius;
        this.rusis = korta / verciuSkaicius;
        this.rusisPav = rusis + ".jpg";
        if (rusis < 2) {
            vertePav = verte + "r.jpg";
        } else {
            vertePav = verte + "j.jpg";
        }
    }

    public boolean tuzas() {
        return verte == tuzoVerte;
    }

    public int verte() {
        if (verte == tuzoVerte) {
            return 1;
        }
        if (verte >= numeriuSkaicius) {
            return 10;
        }
        return verte + 2;
    }

    public void piesti(Piesti p, int x, int y) throws IOException {
        p.nuotrauka(x, y, rusisPav);
        p.skaicius(x + 50, y, vertePav);
    }

}
