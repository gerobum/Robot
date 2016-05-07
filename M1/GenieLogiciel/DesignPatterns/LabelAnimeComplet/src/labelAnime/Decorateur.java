package labelAnime;

import javax.swing.JLabel;

public class Decorateur extends AnimateurAbstrait {
    private AnimateurAbstrait composant;
    
    public Decorateur(AnimateurAbstrait composant) {
        this.composant = composant;
    }

    @Override
    public void animer() {
        composant.animer();
    }

  @Override
  public JLabel getJLabel() {
    return composant.getJLabel();
  }

}
