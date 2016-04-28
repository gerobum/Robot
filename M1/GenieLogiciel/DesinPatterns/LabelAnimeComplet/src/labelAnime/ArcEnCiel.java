package labelAnime;

import java.awt.Color;

public class ArcEnCiel extends Decorateur {
    public ArcEnCiel(AnimateurAbstrait composant) {
        super(composant);
        //faireLArcEnCiel();
    } 
    @Override
    public void animer() {
        super.animer();
        faireLArcEnCiel();
    }
    
    private void faireLArcEnCiel() {

        new Thread(new Runnable() {

            public void run() {
                Color fond = Color.BLACK;
                Color trait = Color.WHITE;
                getJLabel().setOpaque(true);
                while(true) {
                    getJLabel().setBackground(fond);
                    getJLabel().setForeground(trait);
                    fond = couleurSuivante(fond);
                    trait = new Color(255-fond.getRed(), 255-fond.getGreen(), 255-fond.getBlue());

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {

                    }    

                }
            }

            private Color couleurSuivante(Color fond) {
                int r = fond.getRed();
                int v = fond.getGreen();
                int b = fond.getBlue();
                if (r == 0 && v == 0 && b < 255)
                    b++;
                else if (r == 0 && v < 255 && b == 255)
                    v++;
                else if (r == 0 && v == 255 && b > 0)
                    b--;
                else if (r < 255 && v == 255 && b == 0)
                    r++;
                else if (r == 255 && v > 0 && b == 0)
                    v--;
                else
                    r--;
                return new Color(r, v, b);
            }


            
        }).start();        
    }

}
