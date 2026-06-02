package modele;

public class Sudoku {
    private int[][] grille;
    private final int  Taille=9;

    public Sudoku(int[][] pargrille){
        grille=pargrille;
    }
    public Boolean  est_Valid(int nblig,int nbcol,int solutio){
        int cassex = (nblig /3)*3;
        int cassey =(nbcol /3)*3;
        for(int i=0;i<Taille;i++) {
            if (grille[nblig][i] == solutio) {
                return false;
            }
        }
        for(int y=0;y<Taille;y++) {
            if (grille[y][nbcol] == solutio) {
                return false;
            }
        }
        for(int i=cassex;i<cassex+3;i++){
            for(int y=cassey;y<cassey+3;y++){
                if (grille[i][y]==solutio){
                    return false;
                }
            }
        }
        return true;

    }
    public Boolean Resoudre(int parligne,int parcolonne){
        if (parligne==9){
            return true;
        }
        else if(parcolonne==9){
            return Resoudre(parligne+1,0);
        }
        else if (grille[parligne][parcolonne]!=0) {
            if (Resoudre(parligne, parcolonne+1)){
                return true;
            }
            return false;
        }
        else {
            for(int k=1;k<10;k++){
                if (est_Valid(parligne,parcolonne,k)){
                    grille[parligne][parcolonne]=k;
                    if (Resoudre(parligne,parcolonne+1)){
                        return true;
                    }
                    grille[parligne][parcolonne]=0;
                }
            }
            return false;
        }
    }
}
