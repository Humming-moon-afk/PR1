public class Smartphone {
    // Attribute oder Datenelemente
    private String marke;
    private int akkustand;
    // Konstruktor
    public Smartphone(String marke, int akkustand) {
        this.marke = marke;
        this.akkustand = akkustand;
    }
    //leerer Konstruktor mit festgelegten Inhalten -> Überlädt den vorherigen Konstrukor
    public Smartphone() {
        this.marke = "Unknown";
        this.akkustand = 0;
    }
    //lädt das Datenelement um die menge(Parameter)
    public void laden(int menge) {
        akkustand+=menge;
    }
    @Override
    public String toString() {
        return marke + " " + akkustand;
    }
}
class SmartphoneMain {
    public static void main(String [] args) {
        //allokiert Speicher im Heap für ein neues Objekt s1
        Smartphone s1 = new Smartphone("Samsung", 100);
        s1.laden(-20);
        //Argument
        System.out.println(s1);
        Smartphone s2 = new Smartphone();
        System.out.println((s2));
        s2 = null;
        //s2 verweist jetzt auf null
        System.out.println(s2);
        s1 = s2;
        //s1 verweist auch jetzt null wie s2
        System.out.println(s1);
    }
}
