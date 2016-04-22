
package modele;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maillot
 */
public class Modele6 extends AbstractTableModel {
    private final String[] columnNames = {"Integer", "Boolean", "String"};
    private Integer vi;
    private Boolean vb;
    private String vs;
 

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 1;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return Boolean.class;
            default:
                return String.class;
        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        vb = (Boolean) aValue;
        vi = vb ? 1 : 0;
        vs = vb ? "Vrai" : "Faux";
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return vi;
            case 1:
                return vb;
            default:
                return vs;
        }
    }
}
