package modele;

public class Main {
    public static void main(String[] args) {
        int[][] facile = {
                {0, 0, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0}
        };

        int[][] moyenne = {
                {0, 2, 0, 6, 0, 8, 0, 0, 0},
                {5, 8, 0, 0, 0, 9, 7, 0, 0},
                {0, 0, 0, 0, 4, 0, 0, 0, 0},
                {3, 7, 0, 0, 0, 0, 5, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 8, 0, 0, 0, 0, 1, 3},
                {0, 0, 0, 0, 2, 0, 0, 0, 0},
                {0, 0, 9, 8, 0, 0, 0, 3, 6},
                {0, 0, 0, 3, 0, 6, 0, 9, 0}
        };

        int[][] difficile = {
                {0, 0, 0, 6, 0, 0, 4, 0, 0},
                {7, 0, 0, 0, 0, 3, 6, 0, 0},
                {0, 0, 0, 0, 9, 1, 0, 8, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 5, 0, 1, 8, 0, 0, 0, 3},
                {0, 0, 0, 3, 0, 6, 0, 4, 5},
                {0, 4, 0, 2, 0, 0, 0, 6, 0},
                {9, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 1, 0, 0}
        };

        testerGrille("FACILE", facile);
        testerGrille("MOYENNE", moyenne);
        testerGrille("DIFFICILE", difficile);
    }


    private static void testerGrille(String niveau, int[][] grilleOriginale) {
        int[][] copie1 = copierGrille(grilleOriginale);
        int[][] copie2 = copierGrille(grilleOriginale);

        System.out.println("====== TEST NIVEAU : " + niveau + " ======");

        // Test du premier code (Sudoku.java)
        Sudoku solveur1 = new Sudoku(copie1);
        long debut1 = System.currentTimeMillis();
        boolean ok1 = solveur1.Resoudre(0, 0);
        long fin1 = System.currentTimeMillis();
        System.out.println("Code 1 (Sudoku)      -> Résolu : " + ok1 + " | Temps : " + (fin1 - debut1) + " ms");

        // Test du deuxième code (sudokuAchraf.java)
        long debut2 = System.currentTimeMillis();
        boolean ok2 = sudokuAchraf.solveur(copie2);
        long fin2 = System.currentTimeMillis();
        System.out.println("Code 2 (suduAchraf)  -> Résolu : " + ok2 + " | Temps : " + (fin2 - debut2) + " ms");

        System.out.println();
    }


    private static int[][] copierGrille(int[][] origine) {
        int[][] copie = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(origine[i], 0, copie[i], 0, 9);
        }
        return copie;
    }
}