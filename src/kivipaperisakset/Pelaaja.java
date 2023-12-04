
package kivipaperisakset;

/**
 * @author Ira Dook
 */
@SuppressWarnings("SpellCheckingInspection")
public class Pelaaja {

    private int voitot;      // Voittojen lukumäärä
    private String valinta;

    public Pelaaja() {
        this.voitot = 0;
    }

    /**
     * Valitse randomilla kivi, paperi tai sakset
     */
    public void arvoKiviPaperiSakset() {
        String arvottuValinta = "";
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0 -> arvottuValinta = ("kivi");
            case 1 -> arvottuValinta = ("paperi");
            case 2 -> arvottuValinta = ("sakset");
        }
        this.valinta = arvottuValinta;
    }

    public void lisaaVoitto() {
        voitot++;
    }

    public int getVoitot() {
        return voitot;
    }

    public String getValinta() {
        return valinta;
    }

    // Testausta varten
    public void setValinta(String valinta) {
        this.valinta = valinta;
    }
}
