/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maillot
 */
public class Modele7 extends DefaultTableModel {
    private String[] columnNames = {"Integer", "Double", "Boolean", "String", "Fruit"};
    private Object donnée[][] = {{1, 1.0, true, "Un", ""}};
    public Modele7() {
        setDataVector(donnée, columnNames);
        
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 1 || column == 4) return true;
        else return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return donnée[0][columnIndex].getClass();
    }
}
