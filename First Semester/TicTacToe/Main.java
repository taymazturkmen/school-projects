import java.util.Scanner;

/**
 * Ein 5*5 Tic Tac Toe Spiel
 *
 * @author Taymaz Türkmen
 */
public class Main {
    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        char[][] tafel = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tafel[i][j] = '-';

            }

        }
        System.out.println("---------------------");

        for (int i = 0; i < 5; i++) {
            System.out.print("| ");
            for (int j = 0; j < 5; j++) {
                System.out.print(tafel[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------------------");
        }
        int a;
        int b;
        boolean Spieler1Gewonnen = false;
        boolean Spieler2Gewonnen = false;
        int zug = 0;

        do {
            System.out.println("Jetzt am Zug: Spieler 1");
            System.out.println("Bitte die Koordinate (Reihe und Spalte, jeweils 0-4) eingeben");
            System.out.println("Wählen sie eine Reihe (0-4)");
            a = in.nextInt();
            if (a >= 5 | a < 0) {
                System.out.println("Falsche Zahl Eingabe!");
                System.exit(0);
            }
            System.out.println("Wählen Sie eine Spalte");
            b = in.nextInt();
            if (b >= 5 | b < 0) {
                System.out.println("Falsche Zahl Eingabe!");
                System.exit(0);
            }
            if (tafel[a][b] != '-') {
                System.out.println("Falsche Koordinaten! Platz ist schon voll");
                System.exit(0);
            }
            tafel[a][b] = 'X';

            System.out.println("---------------------");

            for (int i = 0; i < 5; i++) {
                System.out.print("| ");
                for (int j = 0; j < 5; j++) {
                    System.out.print(tafel[i][j] + " | ");
                }
                System.out.println();
                System.out.println("---------------------");
            }
            for (int i = 0; i < 5; i++) {
                if ((tafel[i][0] & tafel[i][1] & tafel[i][2] & tafel[i][3] & tafel[i][4]) == 'X') {
                    System.out.println("Spieler 1 hat gewonnen");
                    Spieler1Gewonnen = true;
                    System.exit(0);

                }
                if ((tafel[0][i] & tafel[1][i] & tafel[2][i] & tafel[3][i] & tafel[4][i]) == 'X') {
                    System.out.println("Spieler 1 hat gewonnen");
                    Spieler1Gewonnen = true;
                    System.exit(0);
                }
                if ((tafel[0][0] & tafel[1][1] & tafel[2][2] & tafel[3][3] & tafel[4][4]) == 'X') {
                    System.out.println("Spieler 1 hat gewonnen");
                    Spieler1Gewonnen = true;
                    System.exit(0);
                }
                if ((tafel[0][4] & tafel[1][3] & tafel[2][2] & tafel[3][1] & tafel[4][0]) == 'X') {
                    System.out.println("Spieler 1 hat gewonnen");
                    Spieler1Gewonnen = true;
                    System.exit(0);
                }

            }
            zug += 1;
            if (zug == 25) {
                System.out.println("Spiel ist Unentschieden");
                break;
            }

            System.out.println("Jetzt am Zug: Spieler 2");
            System.out.println("Bitte die Koordinate (Reihe und Spalte, jeweils 0-4) eingeben");
            System.out.println("Wählen Sie eine Reihe (0-4)");
            a = in.nextInt();
            if (a >= 5 | a < 0) {
                System.out.println("Falsche Zahl Eingabe!");
                System.exit(0);
            }
            System.out.println("Wählen Sie eine Spalte");
            b = in.nextInt();
            if (b >= 5 | b < 0) {
                System.out.println("Falsche Zahl Eingabe!");
                System.exit(0);
            }
            if (tafel[a][b] != '-') {
                System.out.println("Falsche Koordinaten! Platz ist schon voll");
                System.exit(0);
            }
            tafel[a][b] = 'O';

            System.out.println("---------------------");

            for (int i = 0; i < 5; i++) {
                System.out.print("| ");
                for (int j = 0; j < 5; j++) {
                    System.out.print(tafel[i][j] + " | ");
                }
                System.out.println();
                System.out.println("---------------------");
            }
            for (int i = 0; i < 5; i++) {
                if ((tafel[i][0] & tafel[i][1] & tafel[i][2] & tafel[i][3] & tafel[i][4]) == 'O') {
                    System.out.println("Spieler 2 hat gewonnen");
                    Spieler2Gewonnen = true;
                    System.exit(0);
                }
                if ((tafel[0][i] & tafel[1][i] & tafel[2][i] & tafel[3][i] & tafel[4][i]) == 'O') {
                    System.out.println("Spieler 2 hat gewonnen");
                    Spieler2Gewonnen = true;
                    System.exit(0);
                }
                if ((tafel[0][0] & tafel[1][1] & tafel[2][2] & tafel[3][3] & tafel[4][4]) == 'O') {
                    System.out.println("Spieler 2 hat gewonnen");
                    Spieler2Gewonnen = true;
                    System.exit(0);
                }
                if ((tafel[0][4] & tafel[1][3] & tafel[2][2] & tafel[3][1] & tafel[4][0]) == 'O') {
                    System.out.println("Spieler 2 hat gewonnen");
                    Spieler2Gewonnen = true;
                    System.exit(0);
                }
            }
            zug += 1;
        }
        while (zug <= 25);

    }


}





