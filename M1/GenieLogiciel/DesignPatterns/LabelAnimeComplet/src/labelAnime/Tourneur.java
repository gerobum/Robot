package labelAnime;

public class Tourneur extends Decorateur {
    public Tourneur(AnimateurAbstrait composant) {
        super(composant);
        //faireTourner();
    }
    @Override
    public void animer() {
        super.animer();
        faireTourner();
    }  
    private void faireTourner() {
        new Thread(new Runnable() {

            public void run() {
                while(true) {
                    synchronized(getJLabel()) {
                        getJLabel().setText(getJLabel().getText().substring(1)+getJLabel().getText().substring(0, 1));
                     }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) { 
                        }   

                }
            }
        }).start();       
    }
}
