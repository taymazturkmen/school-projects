/**
 * Ein Programm , das von Kommandozeilen Parameters ein Landschaft mit Grass gefüllt.
 * Unterstützt nur Natürliche Zahlen
 *
 * @author Taymaz Türkmen
 */
public class Main {
    public static void main(String[] args) {
        
        int[] a = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            a[i] = Integer.parseInt(args[i]);
        }


        int Breite = a[0];

        for (int i = 0; i < args.length; i++) {
            if (a[i] <= 0) {
                System.out.println("Falsche Anzahl an Parametern!");
                System.exit(0);
            }
        }

        if (args.length - 1 != Breite) {
            System.out.println("Falsche Anzahl an Parametern!");
            System.exit(0);
        }

        int sum1 = 0 - a[0];
        for (int value : a) {
            sum1 += value;
        }

        System.out.println("Landschaft hat " + sum1 + " Blöcke");

        int Max = a[1];
        for (int k = 1; k < a.length - 1; k++) {
            if (a[k] > Max) {
                Max = a[k];

            }
        }

        int ArrayOfMax = 1;
        for (int k = 1; k < a.length - 1; k++) {
            if (a[k] == Max) {
                ArrayOfMax = k;

            }
        }
        for (int i = 1; i < ArrayOfMax - 1; i++) {
            if (a[i] > a[i + 1]) {
                a[i + 1] += (a[i] - a[i + 1]);
            }
        }

        for (int i = a.length - 1; i > ArrayOfMax + 1; i--) {
            if (a[i] > a[i - 1]) {
                a[i - 1] += (a[i] - a[i - 1]);
            }
        }
        
        int sum2 = 0 - a[0];
        for (int value : a) {
            sum2 += value;
        }
        int WasserGefüllteBlöcke = sum2 - sum1;
        System.out.println("Man kann " + WasserGefüllteBlöcke + " Blöcke mit Wasser füllen");
        System.out.println("Gefüllte Landschaft hat " + sum2 + " Blöcke");

    }
}


