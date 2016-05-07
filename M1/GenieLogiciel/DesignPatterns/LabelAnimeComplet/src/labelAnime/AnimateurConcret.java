package labelAnime;

import javax.swing.JLabel;


public class AnimateurConcret extends AnimateurAbstrait {
    private final JLabel label;
    public AnimateurConcret(JLabel label) {
        this.label = label;
    }

    @Override
    public void animer() {       
    }

  @Override
  public JLabel getJLabel() {
    return label;
  }
}
