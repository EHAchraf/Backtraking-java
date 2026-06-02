package modele;

public class Main {
    public static void main(String[] args) {
        int[][] grilleOriginale = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        int[][] grillePourSudoku = copierGrille(grilleOriginale);
        int[][] grillePourAchraf = copierGrille(grilleOriginale);

        afficherGrille(grilleOriginale);
        System.out.println();

        Sudoku solveur1 = new Sudoku(grillePourSudoku);
        if (solveur1.Resoudre(0, 0)) {
            afficherGrille(grillePourSudoku);
        }
        System.out.println();

        if (sudokuAchraf.solveur(grillePourAchraf)) {
            afficherGrille(grillePourAchraf);
        }
    }

    private static int[][] copierGrille(int[][] origine) {
        int[][] copie = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(origine[i], 0, copie[i], 0, 9);
        }
        return copie;
    }

    private static void afficherGrille(int[][] grille) {
        for (int l = 0; l < 9; l++) {
            if (l % 3 == 0 && l != 0) {
                System.out.println("---------------------");
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0 && c != 0) {
                    System.out.print("| ");
                }
                System.out.print(grille[l][c] == 0 ? ". " : grille[l][c] + " ");
            }
            System.out.println();
        }
    }
}