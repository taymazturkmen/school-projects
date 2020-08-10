import java.util.Random;
import java.util.Scanner;

interface Interface{
    public void mine();
    public void normalesFeld();
    public void enscharftFeld();
}
/**
 * Ein 10*10 Minesweeper Spiel
 *
 * @author Taymaz Türkmen
 */
public class MineSweeper {
    static Scanner in;
    int n;
    int x;
    int v;

    public MineSweeper() {
        n = 10;
        x = 23;
        v = 5;
    }

    public static void main(String[] args) {
        MineSweeper konstruktor = new MineSweeper();
        Field[][] board = new Field[konstruktor.n][konstruktor.n];
        Random r = new Random();
        in = new Scanner(System.in);


        for (int i = 0; i < konstruktor.n; i++) {
            for (int j = 0; j < konstruktor.n; j++) {
                board[i][j] = new Field();
                board[i][j].mine = false;
            }
        }
        for (int i = 0; i < konstruktor.x; i++) {
            int mine_i;
            int mine_j;
            do {
                mine_i = r.nextInt(konstruktor.n);
                mine_j = r.nextInt(konstruktor.n);
            }
            while (board[mine_i][mine_j].mine == true);
            board[mine_i][mine_j].mine = true;

        }
        for (int i = 0; i < konstruktor.v; i++) {
            int row, col;
            do {
                row = r.nextInt(konstruktor.n);
                col = r.nextInt(konstruktor.n);
            }
            while (board[row][col].sehen == true | board[row][col].mine == true);
            board[row][col].sehen = true;
            if (board[row][col].sehen == true) {
                if (col != konstruktor.n - 1) {
                    if (row != 0) {
                        if (board[row - 1][col + 1].mine == true) {
                            board[row][col].block += 1;
                        }
                    }
                    if (board[row][col + 1].mine == true) {
                        board[row][col].block += 1;
                    }
                    if (row != konstruktor.n - 1) {
                        if (board[row + 1][col + 1].mine == true) {
                            board[row][col].block += 1;
                        }
                    }

                }
                if (row != 0) {
                    if (board[row - 1][col].mine == true) {
                        board[row][col].block += 1;
                    }
                }
                if (row != konstruktor.n - 1) {
                    if (board[row + 1][col].mine == true) {
                        board[row][col].block += 1;
                    }
                }
                if (col != 0) {
                    if (row != 0) {
                        if (board[row - 1][col - 1].mine == true) {
                            board[row][col].block += 1;
                        }
                    }
                    if (board[row][col - 1].mine == true) {
                        board[row][col].block += 1;
                    }
                    if (row != konstruktor.n - 1) {
                        if (board[row + 1][col - 1].mine == true) {
                            board[row][col].block += 1;
                        }
                    }

                }
            }
        }
        System.out.println(" |A|B|C|D|E|F|G|H|I|J|");
        for (int i = 0; i < konstruktor.n; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < konstruktor.n; j++) {
                if (board[i][j].sehen == true) {
                    System.out.print(board[i][j].block + "|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.println();
        }

        boolean istEnde = false;

        do {
            System.out.println(" Enter 1 für ’ Betreten ’ , 2 für ’ Entscharfen ’ ");
            int a = in.nextInt();
            if (a == 1) {
                System.out.println("Enter nachste Koordinaten (zB., \" H4 \") ");
                String Coordinates;
                Coordinates = in.next();
                char column = Coordinates.charAt(0);
                char letter = Coordinates.charAt(1);
                int row = Character.getNumericValue(letter);
                int col = 0;
                if (column >= 'A' && column <= 'Z')
                    col = column - 'A';
                else
                    col = column - 'a';

                if (0 <= row & row < konstruktor.n) {
                    if (0 <= col & col <= konstruktor.n) {
                        board[row][col].sehen = true;
                        if (board[row][col].mine == true) {
                            System.out.println("Gewahlte Feld war vermintet, spiel ist zu ende");
                            istEnde = true;
                            break;
                        }
                        if (board[row][col].mine == false) {
                            if (board[row][col].mine == false) {
                                board[row][col].block = 0;
                                if (board[row][col].block == 0) {
                                    if (col != konstruktor.n - 1) {
                                        if (row != 0) {
                                            if (board[row - 1][col + 1].mine == true) {
                                                board[row][col].block += 1;
                                            }
                                        }
                                        if (board[row][col + 1].mine == true) {
                                            board[row][col].block += 1;
                                        }
                                        if (row != konstruktor.n - 1) {
                                            if (board[row + 1][col + 1].mine == true) {
                                                board[row][col].block += 1;
                                            }
                                        }

                                    }
                                    if (row != 0) {
                                        if (board[row - 1][col].mine == true) {
                                            board[row][col].block += 1;
                                        }
                                    }
                                    if (row != konstruktor.n - 1) {
                                        if (board[row + 1][col].mine == true) {
                                            board[row][col].block += 1;
                                        }
                                    }
                                    if (col != 0) {
                                        if (row != 0) {
                                            if (board[row - 1][col - 1].mine == true) {
                                                board[row][col].block += 1;
                                            }
                                        }
                                        if (board[row][col - 1].mine == true) {
                                            board[row][col].block += 1;
                                        }
                                        if (row != konstruktor.n - 1) {
                                            if (board[row + 1][col - 1].mine == true) {
                                                board[row][col].block += 1;
                                            }
                                        }

                                    }
                                }
                            }
                            if (board[row][col].block == 0) {
                                for (int i = row - 1; i <= row + 1; i++) {
                                    for (int j = col - 1; j <= col + 1; j++) {
                                        if (i >= 0 && j >= 0 && i < konstruktor.n && j < konstruktor.n) {
                                            if (board[i][j].sehen == false) {
                                                if (j != konstruktor.n - 1) {
                                                    if (i != 0) {
                                                        if (board[i - 1][j + 1].mine == true) {
                                                            if (board[i][j].mine == false) {
                                                                board[i][j].block += 1;
                                                            }
                                                        }
                                                    }
                                                    if (board[i][j + 1].mine == true) {
                                                        if (board[i][j].mine == false) {
                                                            board[i][j].block += 1;
                                                        }
                                                    }

                                                    if (i != konstruktor.n - 1) {
                                                        if (board[i + 1][j + 1].mine == true) {
                                                            if (board[i][j].mine == false) {
                                                                board[i][j].block += 1;
                                                            }
                                                        }
                                                    }

                                                }
                                                if (i != 0) {
                                                    if (board[i - 1][j].mine == true) {
                                                        if (board[i][j].mine == false) {
                                                            board[i][j].block += 1;
                                                        }
                                                    }
                                                }
                                                if (i != konstruktor.n - 1) {
                                                    if (board[i + 1][j].mine == true) {
                                                        if (board[i][j].mine == false) {
                                                            board[i][j].block += 1;
                                                        }
                                                    }
                                                }
                                                if (j != 0) {
                                                    if (i != 0) {
                                                        if (board[i - 1][j - 1].mine == true) {
                                                            if (board[i][j].mine == false) {
                                                                board[i][j].block += 1;
                                                            }
                                                        }
                                                    }
                                                    if (board[i][j - 1].mine == true) {
                                                        if (board[i][j].mine == false) {
                                                            board[i][j].block += 1;
                                                        }
                                                    }
                                                    if (i != konstruktor.n - 1) {
                                                        if (board[i + 1][j - 1].mine == true) {
                                                            if (board[i][j].mine == false) {
                                                                board[i][j].block += 1;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            System.out.println(" |A|B|C|D|E|F|G|H|I|J|");
            for (int i = 0; i < konstruktor.n; i++) {
                System.out.print(i + "|");
                for (int j = 0; j < konstruktor.n; j++) {
                    if (board[i][j].sehen == true & board[i][j].defused==false) {
                        System.out.print(board[i][j].block + "|");
                    }
                    if (board[i][j].defused == true) {
                        System.out.print("!|");
                    }
                    if (board[i][j].sehen == false) {
                        System.out.print(" |");
                    }
                }
                System.out.println();
            }

            if (a == 2) {
                System.out.println("Enter nachste Koordinaten (zB., \" H4 \") ");
                String Coordinates;
                Coordinates = in.next();
                char column = Coordinates.charAt(0);
                char letter = Coordinates.charAt(1);
                int row = Character.getNumericValue(letter);
                int col = 0;
                if (column >= 'A' && column <= 'Z')
                    col = column - 'A';
                else
                    col = column - 'a';

                if (0 <= row & row < konstruktor.n - 1) {
                    if (0 <= col & col <= konstruktor.n - 1) {
                        if (board[row][col].mine == false) {
                            System.out.println("Gewahlte Feld war kein Mine ");
                            istEnde = true;
                            break;
                        }
                    }
                    if (board[row][col].mine == true) {
                        board[row][col].defused = true;
                        board[row][col].sehen = true;
                        System.out.println(" |A|B|C|D|E|F|G|H|I|J|");
                        for (int i = 0; i < konstruktor.n; i++) {
                            System.out.print(i + "|");
                            for (int j = 0; j < konstruktor.n; j++) {
                                if (board[i][j].sehen == true & board[i][j].defused==false) {
                                    System.out.print(board[i][j].block + "|");
                                }
                                if (board[i][j].defused == true) {
                                    System.out.print("!|");
                                }
                                if (board[i][j].sehen == false) {
                                    System.out.print(" |");
                                }
                            }
                            System.out.println();
                        }
                        System.out.println("Mine wurde entschärft");
                    }
                }
            }
            boolean isstEnde = true;
            for (int i = 0; i < konstruktor.n; i++) {
                for (int j = 0; j < konstruktor.n; j++) {
                    if(board[i][j].mine==false){
                        if(board[i][j].sehen==false){
                            isstEnde = false;
                        }
                    }
                }

            }
            if(isstEnde == true){
                System.out.println("Bravo! Spiel ist zu Ende");
                break;
            }


        }
        while (istEnde = true);

        for (int row = 0; row < konstruktor.n; row++) {
            for (int col = 0; col < konstruktor.n - 1; col++) {
                if (board[row][col].mine == false) {
                    board[row][col].block = 0;
                    if (board[row][col].block == 0) {
                        if (col != konstruktor.n - 1) {
                            if (row != 0) {
                                if (board[row - 1][col + 1].mine == true) {
                                    board[row][col].block += 1;
                                }
                            }
                            if (board[row][col + 1].mine == true) {
                                board[row][col].block += 1;
                            }
                            if (row != konstruktor.n - 1) {
                                if (board[row + 1][col + 1].mine == true) {
                                    board[row][col].block += 1;
                                }
                            }

                        }
                        if (row != 0) {
                            if (board[row - 1][col].mine == true) {
                                board[row][col].block += 1;
                            }
                        }
                        if (board[row][col].mine == true) {
                            board[row][col].block += 1;
                        }
                        if (row != konstruktor.n - 1) {
                            if (board[row + 1][col].mine == true) {
                                board[row][col].block += 1;
                            }
                        }
                        if (col != 0) {
                            if (row != 0) {
                                if (board[row - 1][col - 1].mine == true) {
                                    board[row][col].block += 1;
                                }
                            }
                            if (board[row][col - 1].mine == true) {
                                board[row][col].block += 1;
                            }
                            if (row != konstruktor.n - 1) {
                                if (board[row + 1][col - 1].mine == true) {
                                    board[row][col].block += 1;
                                }
                            }

                        }
                    }


                }
            }
        }
        System.out.println(" |A|B|C|D|E|F|G|H|I|J|");
        for (int i = 0; i < konstruktor.n; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < konstruktor.n; j++) {
                if (board[i][j].mine == false) {
                    System.out.print(board[i][j].block + "|");
                } else {
                    System.out.print("X|");
                }
            }
            System.out.println();
        }

    }
}
