public class Buch {
    private static int bücherZähler = 0;
    private String title;
    private int seiten;
    public Buch(String title, int seiten) {
        this.title = title;
        this.seiten = seiten;
        bücherZähler++;
    }
    public Buch() {
        this.title = "Unbekannt";
        this.seiten = 0;
        bücherZähler++;
    }
    public static int getBücherZähler() {
        return bücherZähler;
    }
    public void error(String message) {
        System.err.println(message);
    }
    public void setSeiten(int seiten) {
        if (seiten < 0) {
            error("Seiten dürfen nicht negativ sein bitte c;");
            return;
        } else {
            this.seiten = seiten;
        }
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getSeiten() {
        return seiten;
    }
    public String gettitle() {
        return title;
    }
    public boolean equals(Buch anderes) {
        if(this.title.equals(anderes.title) && this.seiten == anderes.seiten) {
            return true;
        } else {
            return false;
        }
    }
    public Buch cloneBuch() {
        return new Buch(this.title, this.seiten);
    }
    @Override
    public String toString() {
        return title + seiten;
    }
}
class Bibliothek {
    public static void main(String [] args) {
        Buch[] bibliothek = new Buch[3];
        Buch b1 = new Buch("java", 20);
        Buch b2 = b1;
        bibliothek[0] = b1;
        bibliothek[1] = b2;
        Buch b3 = b1.cloneBuch();
        for(Buch b : bibliothek) {
            System.out.println(b);
        }
        try {
            System.out.println(bibliothek[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }
}
