package sudoku;

import graphics.FrameSudoku;



public class Main {
    public static void main(String[] args) {
        Grille g = new Grille(
                new Grille.SetFixed(0, 0, 1),
                new Grille.SetFixed(0, 1, 5),
                new Grille.SetFixed(0, 3, 2),
                new Grille.SetFixed(0, 4, 4),
                new Grille.SetFixed(0, 4, 4),
                new Grille.SetFixed(0, 5, 7),
                new Grille.SetFixed(1, 3, 6),
                new Grille.SetFixed(1, 7, 4),
                new Grille.SetFixed(2, 2, 7),
                new Grille.SetFixed(2, 4, 3),
                new Grille.SetFixed(2, 7, 1),
                new Grille.SetFixed(2, 8, 2),
                new Grille.SetFixed(3, 0, 3),
                new Grille.SetFixed(3, 1, 7),
                new Grille.SetFixed(3, 3, 9),
                new Grille.SetFixed(3, 4, 8),
                new Grille.SetFixed(3, 8, 5),
                new Grille.SetFixed(4, 0, 4),
                new Grille.SetFixed(4, 1, 9),
                new Grille.SetFixed(4, 7, 7),
                new Grille.SetFixed(4, 8, 1),
                new Grille.SetFixed(5, 0, 2),
                new Grille.SetFixed(5, 4, 1),
                new Grille.SetFixed(5, 5, 4),
                new Grille.SetFixed(5, 7, 8),
                new Grille.SetFixed(5, 8, 9),
                new Grille.SetFixed(6, 0, 7),
                new Grille.SetFixed(6, 1, 8),
                new Grille.SetFixed(6, 4, 5),
                new Grille.SetFixed(6, 6, 1),
                new Grille.SetFixed(7, 1, 1),
                new Grille.SetFixed(7, 5, 6),
                new Grille.SetFixed(8, 3, 1),
                new Grille.SetFixed(8, 4, 7),
                new Grille.SetFixed(8, 5, 3),
                new Grille.SetFixed(8, 7, 9),
                new Grille.SetFixed(8, 8, 6)
        );
        
        new FrameSudoku(g);
    }
}
