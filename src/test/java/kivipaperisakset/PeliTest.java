package kivipaperisakset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PeliTest {

    @Test
    public void peliAlkaaJaLoppuu() {
        Peli peli = new Peli();
        peli.aloita();

        int p1voitot = peli.getP1().getVoitot();
        int p2voitot = peli.getP2().getVoitot();

        assertTrue(p1voitot == 3 || p2voitot == 3, "Peli ei lopu kolmeen voittoon");
    }

    @ParameterizedTest
    @CsvSource({"kivi, sakset", "paperi, kivi", "sakset, paperi"})
    public void pelaaja1VoittaaOikein(String v1, String v2) {
        Peli peli = new Peli();
        peli.getP1().setValinta(v1);
        peli.getP2().setValinta(v2);
        peli.tarkistaVoittaja();

        int p1voitot = peli.getP1().getVoitot();
        int p2voitot = peli.getP2().getVoitot();

        assertTrue(p1voitot == 1 && p2voitot == 0, "Voittaja ei tarkistu oikein");
    }

    @ParameterizedTest
    @CsvSource({"kivi, sakset", "paperi, kivi", "sakset, paperi"})
    public void pelaaja2VoittaaOikein(String v1, String v2) {
        Peli peli = new Peli();
        peli.getP1().setValinta(v2);
        peli.getP2().setValinta(v1);
        peli.tarkistaVoittaja();

        int p1voitot = peli.getP1().getVoitot();
        int p2voitot = peli.getP2().getVoitot();

        assertTrue(p1voitot == 0 && p2voitot == 1, "Voittaja ei tarkistu oikein");
    }

    @Test
    public void tasapelitToimivat() {
        Peli peli = new Peli();
        peli.getP1().setValinta("kivi");
        peli.getP2().setValinta("kivi");
        peli.tarkistaVoittaja();

        int tasapelit = peli.getTasapelit();

        assertTrue(tasapelit == 1
                && peli.getP1().getVoitot() == 0
                && peli.getP2().getVoitot() == 0, "Tasapelien laskeminen ei toimi");
    }
}