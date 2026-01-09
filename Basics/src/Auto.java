public class Auto {
    private static int count = 0;
    private int id;
    private String marke;
    public Auto(String marke) {
        this.marke = marke;
        this.id = count;
        count++;
    }
    public static int getAnzahlAutos() {
        return count;
    }
    @Override
    public String toString() {
        return marke;
    }
}
class FuhrPark {
    public static void main(String [] args) {
        Auto[] garage = new Auto[3];
        garage[0] = new Auto("bmw");
        garage[1] = new Auto("mercedes");
        garage[2] = new Auto("tesla");

        System.out.println("In der Gerage stehen: ");
        for(Auto a : garage) {
            System.out.println(a);
        }
        try {
            System.out.println(garage[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Fehler abgefangen" + e.getMessage());
        }
    }
}