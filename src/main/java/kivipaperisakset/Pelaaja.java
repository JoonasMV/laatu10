
package kivipaperisakset;

/**
 * @author Ira Dook
 */
@SuppressWarnings("SpellCheckingInspection")
/**
 * Pelaaja luokka, joka sisältää pelaajan tiedot
 */
public class Pelaaja {

    private int voitot;
    private String valinta;

    public Pelaaja() {
        this.voitot = 0;
    }

    /**
     * Arpoo pelaajalle pelimerkin
     */
    public void arvoMerkki() {
        String arvottuValinta = "";
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0 -> arvottuValinta = ("kivi");
            case 1 -> arvottuValinta = ("paperi");
            case 2 -> arvottuValinta = ("sakset");
        }
        this.valinta = arvottuValinta;
    }

    /**
     * Lisaa voiton pelaajalle
     */
    public void lisaaVoitto() {
        voitot++;
    }

    /**
     * Palauttaa pelaajan voittojen yhteismäärän
     * @return Pelaajan yhteismäärä voittoja
     */
    public int getVoitot() {
        return voitot;
    }

    /**
     * Palauttaa peelajan merkin, joka tällä on kyseisellä hetkellä
     * @return Pelaajan valinta
     */
    public String getValinta() {
        return valinta;
    }

    /**
     * Asettaa pelaajalle merkin
     * @param valinta Merkki joka pelaajalle halutaan asettaa
     */
    public void setValinta(String valinta) {
        this.valinta = valinta;
    }
}
