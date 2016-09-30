package exemples;

import dessin.Cercle;
import dessin.FigureComposee;
import dessin.Ligne;
import dessin.Rectangle;
import fenetres.Dessin;
import java.awt.Point;

public class Exemple {

    public static void main(String[] args) throws InterruptedException {
        FigureComposee caravane = new FigureComposee();
        caravane.ajouter(new Cercle(new Point(50, 480), 8));
        caravane.ajouter(new Ligne(75, 472, 90, 472));
        caravane.ajouter(new Rectangle(25, 430, 50, 40));
        FigureComposee voiture = new FigureComposee();
        voiture.ajouter(new Cercle(new Point(110, 480), 8));
        voiture.ajouter(new Cercle(new Point(150, 480), 8));
        voiture.ajouter(new Rectangle(90, 450, 80, 20));
        voiture.ajouter(new Rectangle(110, 430, 40, 20));
        FigureComposee attelage = new FigureComposee();
        attelage.ajouter(voiture);
        attelage.ajouter(caravane);

        //attelage.dessiner();
        double duree = 100;
        Dessin dessin = new Dessin(attelage);
        dessin.translater(000, 0);
        Thread.sleep(5000);
        for (int i = 0; i < 1000; i++) {
            dessin.translater(1, 0);
            Thread.sleep((long) duree);
            duree = (duree * 0.99);
        }
        Thread.sleep(500);
        dessin.translater(-1000, 0);
        for (int i = 0; i < 1000; i++) {
            dessin.translater(1, 0);
            Thread.sleep(2);
        }
        Thread.sleep(1000);
        dessin.translater(-1000, 0);
        for (int i = 0; i < 1000; i++) {
            dessin.translater(1, 0);
            Thread.sleep(1);
        }

        Thread.sleep(1000);
        dessin.translater(-1000, 0);
        for (int i = 0; i < 100; i++) {
            dessin.translater(10, 0);
            Thread.sleep(5);
        }

        while (true) {
            Thread.sleep(1000);
            dessin.translater(-1000, 0);
            for (int i = 0; i < 100; i++) {
                dessin.translater(10, 0);
                Thread.sleep(3);
            }
        }
    }
}
