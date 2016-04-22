/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tableDeMultiplication;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author yvan
 */
public class TableMultiplicationModel implements TableModel {
  private int nbLignes, nbColonnes;

  public TableMultiplicationModel(int l, int c) {
    nbLignes = l; nbColonnes = c;
  }
  @Override
  public int getRowCount() {
    return nbLignes;
  }
  @Override
  public int getColumnCount() {
    return nbColonnes;
  }
  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return (rowIndex+1)*(columnIndex+1);
  }
  @Override
  public String getColumnName(int column) {
    return "x "+(column+1);
  }
  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return Integer.class;
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return false;
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
  }

  @Override
  public void addTableModelListener(TableModelListener l) {
  }

  @Override
  public void removeTableModelListener(TableModelListener l) {
  }
  
  

}
