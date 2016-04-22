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
public class Modele6 extends DefaultTableModel {
    private String[] columnNames = {"Integer", "Boolean", "String"};
    private Object[][] donnee = {{1, true, "Vrai"}};
    public Modele6() {
        setDataVector(donnee, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 1) return true;
        else return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return donnee[0][columnIndex].getClass();
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        super.setValueAt(aValue, row, column);
        if ((Boolean) aValue) {
            super.setValueAt(1, row, 0);
            super.setValueAt("Vrai", row, 2);
        } else {
            super.setValueAt(0, row, 0);
            super.setValueAt("Faux", row, 2);
        }
    }


}
