package labelAnime;

public class Vague extends Decorateur {

  public Vague(AnimateurAbstrait composant) {
    super(composant);
    //faireVaguer();
  }

  @Override
  public void animer() {
    super.animer();
    faireVaguer();
  }

  private void faireVaguer() {
    new Thread(new Runnable() {
      public void run() {
        String texte;
        synchronized (getJLabel()) {
          texte = getJLabel().getText().toLowerCase();
        }
        String début, lettre, fin;
        int i = 0;
        while (true) {
          début = texte.substring(0, i);
          lettre = texte.substring(i, i + 1).toUpperCase();
          fin = texte.substring(i + 1, texte.length());
          i++;
          if (i == texte.length()) {
            i = 0;
          }
          synchronized (getJLabel()) {
            getJLabel().setText(début + lettre + fin);
          }
          try {
            Thread.sleep(200);
          } catch (InterruptedException ex) {
          }
        }
      }
    }).start();
  }
}
