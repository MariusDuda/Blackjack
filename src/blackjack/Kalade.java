package blackjack;

public class Kalade {

    private final Korta[] kortos;
    private int KortuKalade = 52;

    public Kalade() {
        kortos = new Korta[KortuKalade];
        for (int i = 0; i < KortuKalade; i++) {
            kortos[KortuKalade - i - 1] = new Korta(i);
        }
    }

    public Korta Traukti() {
        return kortos[--KortuKalade];
    }

    public void Ismaisyti() {
        for (int i = 0; i < KortuKalade; i++) {
            int r = (int) (Math.random() * i);
            Korta sukeist = kortos[i];
            kortos[i] = kortos[r];
            kortos[r] = sukeist;
        }
    }

}
