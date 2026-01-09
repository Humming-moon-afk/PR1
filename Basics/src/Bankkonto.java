/**
 * THEMA: DATENKAPSELUNG, METHODEN MIT RÜCKGABE & STRING-VERGLEICH
 */
public class Bankkonto {
    // DATENKAPSELUNG: Felder sind private, um direkten Zugriff von außen zu verhindern
    private double Kontostand;
    private String inhaber;

    public Bankkonto(String inhaber, double Kontostand) {
        this.inhaber = inhaber; // THIS verweist auf die Instanzvariable
        this.Kontostand = Kontostand;
    }

    // Hilfsmethode zur Fehlerausgabe
    public void GetError(String message) {
        System.err.println(message);
    }

    // GETTER: Ermöglicht lesenden Zugriff auf private Daten
    public String getInhaber() {
        return inhaber;
    }

    // SETTER: Ermöglicht kontrolliertes Ändern mit Validierung (Prüfung)
    public void setKontostand(double kontostand) {
        if(kontostand < 0) {
            GetError("Kontostand darf nicht kleiner als 0 sein");
            return; // Beendet die Methode vorzeitig
        } else {
            Kontostand = kontostand;
        }
    }

    // RÜCKGABETYP boolean: Gibt Erfolg (true) oder Misserfolg (false) zurück
    public boolean abheben(double betrag) {
        if(betrag <= Kontostand) {
            Kontostand -= betrag;
            return true; // ERGEBNISRÜCKGABE: Transaktion okay
        }
        GetError("Nicht genug Guthaben");
        return false; // ERGEBNISRÜCKGABE: Transaktion gescheitert
    }

    // OVERRIDE: Eigene Implementierung der Standard-toString Methode
    @Override
    public String toString() {
        return "Inhaber: " + inhaber + " | Stand: " + Kontostand;
    }
}

class BankkontoMain {
    public static void main(String [] args) {
        Bankkonto b1 = new Bankkonto("Milian", 500);
        System.out.println(b1);

        // Prüfung des Rückgabewerts einer Methode
        if(b1.abheben(5000) == true) {
            System.out.println("Geld wurde ausgezahlt");
        } else {
            System.out.println("Transaktion abgelehnt");
        }

        String testName = "Milian";

        // EQUALS: Inhaltsvergleich (Prüft, ob der Text gleich ist) -> Richtig für Strings!
        System.out.println("Vergleich mit .equals(): " + testName.equals(b1.getInhaber()));

        // ==: Referenzvergleich (Prüft, ob es dasselbe Objekt im Speicher ist) -> Riskant bei Strings!
        System.out.println("Vergleich mit ==: " + (testName == b1.getInhaber()));
    }
}