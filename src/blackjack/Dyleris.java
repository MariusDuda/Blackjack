package blackjack;

public class Dyleris extends Zaidejas {

    private final int dylerioRiba = 17;

    public boolean galiTraukti() {
        return suma() < dylerioRiba;
    }
}
