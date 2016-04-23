/**
 * Un exemple de modèle qui permet la saisie d'informations concernant une personne
 * 
 * Informations à saisir
 * 1. Sa civilité : un objet à choisir dans une liste (Madame, Mademoiselle, Monsieur...)
 * 2. Ses nom et prénom : deux chaînes de caractères à saisir au clavier
 * 3. Son genre : une case à cocher
 * 4. Son âge : un entier à saisir au clavier
 * 
 * Comportement de la table
 * Au départ il n'y a qu'une seule ligne vide.
 * L'utilisateur rempli les informations dans l'ordre qu'il veut. 
 * La colonne du genre n'est pas modifiable parce qu'elle est modifiée par 
 * l'entremise de sa voisine, la colonne du choix du genre.
 * 
 * Dès que toutes les informations sont remplis, une nouvelle ligne se rajoute 
 * à la fin.
*/

package modele;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maillot
 */
public class Modele7 extends AbstractTableModel {
    private final String[] columnNames = {"Civilité", "Nom", "Prénom", "Choix du genre", "Genre", "Âge"};
    private final Class<?>[] columnTypes = {String.class, String.class, String.class, Boolean.class, String.class, Integer.class};
    private final ArrayList<ArrayList<Object>> datas;
    
    public Modele7() {
        datas = new ArrayList<>();
        datas.add(new ArrayList<>());
        for(int i = 0; i < columnNames.length; ++i) {
            datas.get(0).add(null);
        }
    }

    /**
     * La colonne 4 est la seule qui n'est pas éditable
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 4;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    @Override
    public int getRowCount() {
        return datas.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datas.get(rowIndex).get(columnIndex);
    }

    /**
     * setValueAt est souvent la méthode la plus compliquée à écrire car
     * c'est ici que le comportement de la table est traité.
     * 
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        datas.get(rowIndex).set(columnIndex, aValue);
        
        // Si c'est la colonne du choix du genre qui modifiée, il faut reporter
        // ce choix dans celle d'à côté.
        if (columnIndex == 3) {
            if ((Boolean) aValue) {
                datas.get(rowIndex).set(4, "Masculin");
            } else {
                datas.get(rowIndex).set(4, "Féminin");
            }
        }
        
        // Une ligne est ajoutée si et seulement si tous les champs de la table
        // sont remplis.
        boolean full = true;
        
        for(int i = 0;i < datas.size() && full;++i) {
            if (datas.get(i).contains(null))
                full = false;
        }
        if (full) {
            addARow();
        }
            
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    private void addARow() {
        
        datas.add(new ArrayList<>());
        int last = datas.size()-1;
        for(int i = 0; i < columnNames.length; ++i) {
            datas.get(last).add(null);
        }
    }
    
}
