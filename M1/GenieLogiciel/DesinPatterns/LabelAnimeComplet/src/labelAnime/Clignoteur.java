package labelAnime;

import java.awt.Color;

public class Clignoteur extends Decorateur {
    public Clignoteur(AnimateurAbstrait composant) {
        super(composant);
    }
    
    @Override
    public void animer() {
        super.animer();
        faireClignoter();
    }  
    private void faireClignoter() {
        new Thread(new Runnable() {

            public void run() {
                Color couleur = getJLabel().getForeground();
                while(true) {
                        if (getJLabel().getForeground() == couleur) {
                            getJLabel().setForeground(getJLabel().getBackground());
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException ex) {
                            }
                        } else {
                            getJLabel().setForeground(couleur);
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                            }

                        }
                    }
            }
        }).start();        
    }

}
