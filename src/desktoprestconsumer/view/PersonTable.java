package desktoprestconsumer.view;

import desktoprestconsumer.model.TablesData.PersonTableData;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dima on 14.05.2017.
 */
public class PersonTable extends JPanel {

    public PersonTable() {
        super(new GridLayout(1,0));

        JTable table = new JTable(new PersonTableData());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }


}
