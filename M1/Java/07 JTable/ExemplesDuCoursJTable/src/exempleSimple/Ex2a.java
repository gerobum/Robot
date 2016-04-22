package exempleSimple;

import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Maillot
 */
public class Ex2a extends JFrame {

  public Ex2a() {
    super("Table IDBS");
    String[] columnNames = {"Integer", "Double", "Boolean", "String"};
    //Object[][] rowData = new Object[10][4];

    Vector<Vector<Object>> rowData;
    rowData = new Vector<>();
    Vector<Object> v = new Vector<>();
    v.add(1);
    v.add(1.0);
    v.add(true);
    v.add("Un");
    rowData.add(v);
    
    Vector<String> vs = new Vector<>();
    vs.add("Integer");
    vs.add("Double");
    vs.add("Boolean");
    vs.add("String");
   

    JTable table = new JTable(rowData, vs);v = new Vector<>();
    v = new Vector<>();
    v.add(2);
    v.add(2.0);
    v.add(false);
    v.add("Deux");
    
    rowData.add(v);

    JScrollPane scrollPane = new JScrollPane(table);
    //table.setFillsViewportHeight(true);
    getContentPane().add(scrollPane);
    table.setPreferredScrollableViewportSize(new Dimension(300, 170));


    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    pack();
  }

  public static void main(String[] args) {
    new Ex2a();
  }
}
