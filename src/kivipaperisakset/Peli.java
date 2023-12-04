package kivipaperisakset;

/**
 * @author Ira Dook
 */
@SuppressWarnings("SpellCheckingInspection")
public class Peli {

    public static void main(String args[]) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        boolean peliLoppui = false;
        int pelatutPelit = 0;           // Pelattujen pelien lkm
        int tasapelit = 0;              // Tasapelien lkm

        do {
            System.out.printf("Erä: %d =====================\n", pelatutPelit);
            System.out.printf("Tasapelien lukumäärä: %d\n", tasapelit);


            p1.arvoKiviPaperiSakset();
            p2.arvoKiviPaperiSakset();

            if (p1.getValinta().equals(p2.getValinta())) {
                tasapelit++;
                System.out.println("\n\t\t\t Tasapeli \n");
            } else {
                tarkistaVoittaja(p1, p2);
            }
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

    static void tarkistaVoittaja(Pelaaja p1, Pelaaja p2) {
        String p1Valinta = p1.getValinta();
        String p2Valinta = p2.getValinta();

        if (p1Valinta.equals("kivi") && p2Valinta.equals("sakset")
                || p1Valinta.equals("paperi") && p2Valinta.equals("kivi")
                || p1Valinta.equals("sakset") && p2Valinta.equals("paperi")) {
            p1.lisaaVoitto();
        } else {
            p2.lisaaVoitto();
        }
    }
}
