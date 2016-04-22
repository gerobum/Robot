package exempleSimple;

import java.awt.Dimension;
import java.sql.RowId;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Maillot
 */
public class Ex2 extends JFrame {
  private  static Random random = new Random();
  private Object[][] rowData;
  private JTable table;

  public Ex2() {
    super("Table IDBS");
    String[] columnNames = {"Integer", "Double", "Boolean", "String"};
    rowData = new Object[10][4];
    rowData[0][0] = 1;
    rowData[0][1] = 1.0;
    rowData[0][2] = true;
    rowData[0][3] = "Un";

    table = new JTable(rowData, columnNames);
    
    new Thread(new Runnable() {

      @Override
      public void run() {
        while(true) {
          try {
            Thread.sleep(1000);
            int x = random.nextInt(9)+1;
            int y = random.nextInt(4);
            rowData[x][y] = random.nextInt(10);
            table.editCellAt(x, y);
            
          } catch (InterruptedException ex) {
            Logger.getLogger(Ex2.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      }
    }).start();

    JScrollPane scrollPane = new JScrollPane(table);
    getContentPane().add(scrollPane);
    table.setPreferredScrollableViewportSize(new Dimension(300, 170));


    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    pack();
  }

  public static void main(String[] args) {
    new Ex2();
  }
}
