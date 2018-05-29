package sample;

public class Tuba {

    String nimi;
    float pikkus;
    float laius;
    float uks;

    Tuba() {
        nimi = "undefined";
        pikkus = 0;
        laius = 0;
        uks = 0;
    }

    Tuba(String nimi, float pikkus, float laius, float uks) {
        this.nimi = nimi;
        this.pikkus = pikkus;
        this.laius = laius;
        this.uks = uks;
    }

    public void anna_info() {
        System.out.println("Toa nimi on " + this.nimi + ". Selle pikkus on " + this.pikkus + ", laius on " + this.laius + " ning ukse suurus on " + this.uks + ".");
    }

}
