package kivipaperisakset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PelaajaTest {

    private Pelaaja p1;

    @BeforeEach
    public void init() {
        p1 = new Pelaaja();
    }

    @Test
    public void testArvoMerkki() {
        Pelaaja p1 = new Pelaaja();

        p1.arvoMerkki();

        String result = p1.getValinta();
        assertTrue(result.equals("kivi") || result.equals("paperi") || result.equals("sakset"),
                "Tuloksen pitäisi olla jokin seuraavista: kivi, paperi, sakset");
    }

    @Test
    public void voittojaVoiLisata() {
        int alkuVoitot = p1.getVoitot();
        p1.lisaaVoitto();

        int loppuvoitot = p1.getVoitot();
        assertTrue(alkuVoitot == 0 && loppuvoitot == 1,
                "Pelaajan voittoja ei lisätä oikein");
    }
}