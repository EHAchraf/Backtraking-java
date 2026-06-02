package modele;

public class sudokuAchraf {

    public static boolean estValide(int[][] grille, int ligne, int col, int chiffre) {
        for (int c = 0; c < 9; c++) {
            if (grille[ligne][c] == chiffre) {
                return false;

            }
        }

        for (int l = 0; l < 9; l++) {
            if (grille[l][col] == chiffre) {
                return false;
            }
        }
        int ligneDebutbloc = (ligne / 3) * 3;
        int colDebutbloc = (col / 3) * 3;

        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                if (grille[ligneDebutbloc + l][colDebutbloc + c] == chiffre) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean solveur(int[][] grille) {
        for (int l = 0; l < 9; l++) {
            for (int c = 0; c < 9; c++) {
                if (grille[l][c] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        if (estValide(grille, l, c, i)) {
                            grille[l][c] = i;
                            if (solveur(grille)) {
                                return true;
                            }
                            grille[l][c] = 0;
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }
}