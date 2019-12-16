package blackjack;

import java.io.IOException;

public class Zaidejas {

    private Korta[] kortos = new Korta[6];
    private int n = 0;
    private int x, y;

    public Zaidejas(int x, int y) {
        this.x = x;
        this.y = y;
    }
    

    public Korta pirma() {
        return kortos[0];
    }

    public void traukti(Korta kort) {
        kortos[n++] = kort;
    }

    public void reset() {
        n = 0;
    }

    public int suma() {
        int sum = 0;
        boolean tuzas = false;
        for (int i = 0; i < n; i++) {
            sum = sum + kortos[i].verte();
            if (kortos[i].tuzas()) {
                tuzas = true;
            }
        }
        if (tuzas && (sum <= 11)) {
            sum = sum + 10;
        }
        return sum;
    }

    public void piesti(Piesti p) throws IOException {
        for (int i = 0; i < n; i++) {
            kortos[i].piesti(p, x + i * 100, y);
        }
    }
}
