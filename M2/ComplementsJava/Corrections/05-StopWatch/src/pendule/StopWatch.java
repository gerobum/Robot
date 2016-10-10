package pendule;

import langues.ChoixDeLangue;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.*;
import java.util.ResourceBundle;

/**
 *
 * @author maillot
 */
public class StopWatch extends JFrame implements Runnable {

    public enum State {
        READY, // pret à démarrer
        ACTIVE, // en train de décompter
        BLOQUED     // bloqué
    }

    private final JLabel centre;
    private int heure, minute, seconde;
    private final JButton start, stop, reset;
    private State state;
    private Thread runner;
    private JCheckBox changerDeLangue;
    private ChoixDeLangue choixDeLangue;

    private void OneSecondMore() {
        seconde++;
        if (seconde == 60) {
            seconde = 0;
            minute++;
            if (minute == 60) {
                minute = 0;
                heure++;
                if (heure == 100) {
                    heure = 0;
                }
            }
        }
    }

    private void print() {
        centre.setText(String.format("%02d:%02d:%02d", heure, minute, seconde)); //NOI18N
    }

    @Override
    public void run() {
        while (true) {
            switch (state) {
                case READY:
                case BLOQUED:
                    synchronized (this) {
                        try {
                            wait();
                        } catch (InterruptedException ex) {
                        }
                    }
                    break;

                case ACTIVE:
                    try {
                        Thread.sleep(1000);
                        OneSecondMore();
                        print();
                    } catch (InterruptedException ex) {
                    }

            }
        }
    }

    public StopWatch() {
        super(java.util.ResourceBundle.getBundle("langues/dico").getString("WATCH"));
        state = State.READY;

        heure = 0;
        minute = 0;
        seconde = 0;
        start = new JButton(ResourceBundle.getBundle("langues/dico").getString("START"));
        stop = new JButton(ResourceBundle.getBundle("langues/dico").getString("STOP"));
        reset = new JButton(ResourceBundle.getBundle("langues/dico").getString("RESET"));

        centre = new JLabel("00:00:00", JLabel.CENTER);
        centre.setFont(centre.getFont().deriveFont(40F));

        centre.setBorder(BorderFactory.createEmptyBorder(10, 70, 10, 70));


        init();

        changerDeLangue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixDeLangue.setVisible(changerDeLangue.isSelected());
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = State.ACTIVE;
                //runner.interrupt(); // possible aussi
                synchronized (StopWatch.this) {
                    StopWatch.this.notify();
                }
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state == State.ACTIVE) {
                    state = State.BLOQUED;
                }
                // Pourquoi une interruption ici ?
                runner.interrupt();
                // Sans ça, l'appui sur STOP n'est pas immédiat
                // L'attente (sleep) doit se terminer.
                // L'interruption interrompt cette attente.
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state != State.ACTIVE) {
                    state = State.READY;
                    heure = minute = seconde = 0;
                    print();
                    runner.interrupt();
                }

            }
        });
        runner = new Thread(this);
    }

    private void init() {
        
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(1, 3));
        pan.add(start);
        pan.add(stop);
        pan.add(reset);

        getContentPane().add(centre, "Center");
        getContentPane().add(pan, "South");
        getContentPane().setBackground(Color.orange);
        choixDeLangue = new ChoixDeLangue(this);
        changerDeLangue = new JCheckBox(java.util.ResourceBundle.getBundle("langues/dico").getString("CHANGER DE LANGUE"));
        getContentPane().add(changerDeLangue, "North");

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void setLocale(Locale locale) {
        super.setLocale(locale);
        try {
            start.setText(ResourceBundle.getBundle("langues/dico", locale).getString("START"));
            reset.setText(ResourceBundle.getBundle("langues/dico", locale).getString("RESET"));
            stop.setText(ResourceBundle.getBundle("langues/dico", locale).getString("STOP"));
            StopWatch.this.setTitle(ResourceBundle.getBundle("langues/dico", locale).getString("WATCH"));
            changerDeLangue.setText(ResourceBundle.getBundle("langues/dico", locale).getString("CHANGER DE LANGUE"));
            choixDeLangue.setLocale(locale);
        } catch (NullPointerException ne) {

        }
    }

    public void start() {
        runner.start();
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        sw.start();
    }
}
