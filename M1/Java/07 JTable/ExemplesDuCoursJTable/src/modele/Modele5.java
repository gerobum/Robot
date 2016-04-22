/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maillot
 */
public class Modele5 extends DefaultTableModel {

    private Object[] columnTypes = {1, 1.0, true, ""};
    private Vector<Vector<Object>> donnee;

    public Modele5(Vector<Vector<Object>> donnee, Vector<String> columnNames, Object[] columnTypes) {
        this.donnee = donnee;
        setDataVector(donnee, columnNames);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex].getClass();
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        super.setValueAt(aValue, row, column);
        donnee.get(row).set(column, aValue);
    }
}
