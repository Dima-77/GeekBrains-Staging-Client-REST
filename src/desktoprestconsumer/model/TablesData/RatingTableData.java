package desktoprestconsumer.model.TablesData;

import desktoprestconsumer.controller.PersonsController;
import desktoprestconsumer.model.Rest.PersonCoincidencesByDate;
import desktoprestconsumer.model.Rest.PersonWithCoincidences;

import javax.swing.table.AbstractTableModel;
import java.util.Date;

/**
 * Created by Dima on 18.05.2017.
 */
public class RatingTableData extends AbstractTableModel {

    private boolean DEBUG = false;

    private String[] columnNames = {"Site", "Name", "Begin date", "End date", "Rating"};
    private PersonWithCoincidences[] personsScores = null;
    private Object[][] data = null;

    public RatingTableData() {

        //TODO Параметр функции должен выбираться из формы списка
        int site_id = 1;
        personsScores = new PersonsController().getPersonsOnSite(site_id);

        if (personsScores != null) {

            data = new Object[personsScores.length][6];

            for (int i = 0; i < personsScores.length; i++) {
                data[i][0] = new Integer(site_id);
                data[i][1] = personsScores[i].getName();
                data[i][2] = new Date(0L);
                data[i][3] = new Date();
                data[i][4] = personsScores[i].getCoincidences();
            }

        } else {

            System.out.println("# NULL #");
        }
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        if (DEBUG) {
            System.out.println("Setting value at " + row + "," + col
                    + " to " + value
                    + " (an instance of "
                    + value.getClass() + ")");
        }

        data[row][col] = value;
        fireTableCellUpdated(row, col);

        if (DEBUG) {
            System.out.println("New value of data:");
            printDebugData();
        }
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i = 0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
