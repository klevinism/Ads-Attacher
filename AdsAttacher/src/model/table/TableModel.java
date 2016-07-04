package model.table;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import model.PostObject;

public class TableModel extends AbstractTableModel {

    private static final String[] columnNames = {"column 1", "column 2"};
    private final LinkedList<PostObject> list;

    private TableModel() {
        list = new LinkedList<PostObject>();
    }

    public void addElement(PostObject e) {
        // Adds the element in the last position in the list
        list.add(e);
        fireTableRowsInserted(list.size()-1, list.size()-1);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return list.get(rowIndex).getId();
            case 1: return list.get(rowIndex).getTitle();
        }
        return null;
    }

}