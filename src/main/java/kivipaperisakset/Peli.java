package kivipaperisakset;

/**
 * Peli luokka, joka sisältää pelin logiikan
 * @author Ira Dook
 */
@SuppressWarnings("SpellCheckingInspection")
public class Peli {
    private final Pelaaja p1;
    private final Pelaaja p2;
    private boolean peliLoppui = false;
    private int pelatutPelit = 0;
    private int tasapelit = 0;

    public Peli() {
        p1 = new Pelaaja();
        p2 = new Pelaaja();
    }

    /**
     * Aloittaa pelin
     */
    public void aloita() {
        do {
            System.out.printf("Erä: %d =====================\n", pelatutPelit + 1);
            System.out.printf("Tasapelien lukumäärä: %d\n", tasapelit);

            p1.arvoMerkki();
            p2.arvoMerkki();

            tarkistaVoittaja();
            pelatutPelit++;

            System.out.printf("Pelaaja 1: %s%n\t Pelaaja 1:llä koossa %d voittoa.%n", p1.getValinta(), p1.getVoitot());
            System.out.printf("Pelaaja 2: %s%n\t Pelaaja 2:lla koossa %d voittoa.%n", p2.getValinta(), p2.getVoitot());


            if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
                peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }
            System.out.println();
        } while (!peliLoppui);
    }

    /**
     * Tarkistaa kumpi pelaajista voitti vai tulliko tasapeli
     */
    void tarkistaVoittaja() {
        String p1Valinta = p1.getValinta();
        String p2Valinta = p2.getValinta();

        if (p1.getValinta().equals(p2.getValinta())) {
            tasapelit++;
            System.out.println("\n\t\t\t Tasapeli \n");
            return;
        }

        if (p1Valinta.equals("kivi") && p2Valinta.equals("sakset")
                || p1Valinta.equals("paperi") && p2Valinta.equals("kivi")
                || p1Valinta.equals("sakset") && p2Valinta.equals("paperi")) {
            p1.lisaaVoitto();
        } else {
            p2.lisaaVoitto();
        }
    }

    public Pelaaja getP1() {
        return p1;
    }

    public Pelaaja getP2() {
        return p2;
    }

    public int getTasapelit() {
        return tasapelit;
    }
}
