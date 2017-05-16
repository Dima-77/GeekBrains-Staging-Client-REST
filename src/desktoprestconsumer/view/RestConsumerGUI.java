package desktoprestconsumer.view;

import javax.swing.*;

/**
 * Created by Dima on 14.05.2017.
 */
public class RestConsumerGUI {

    JFrame frame = new JFrame("DesktopRestConsumer");

    PersonTable newContentPane = new PersonTable();

    public RestConsumerGUI() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);

    }

}
