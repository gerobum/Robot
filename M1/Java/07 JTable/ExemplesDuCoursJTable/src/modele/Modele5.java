/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maillot
 */
public class Modele5 extends AbstractTableModel {

    private Object[][] datas;
    private String[] columnNames;
    private Class<?>[] columnTypes;

    public Modele5(Object[][] datas, String[] columnNames, Class<?>[] columnTypes) {
        this.datas = datas;
        this.columnNames = columnNames;
        this.columnTypes = columnTypes;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }

    @Override
    public int getRowCount() {
        return datas.length;
    }

    @Override
    public int getColumnCount() {
        return datas[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datas[rowIndex][columnIndex];
    }
}
