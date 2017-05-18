package desktoprestconsumer.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dima on 14.05.2017.
 */
public class RestConsumerGUI {

    JFrame frame = new JFrame("Desktop rest consumer");

    TabbedPanes tabbedPanes = new TabbedPanes();

    public RestConsumerGUI() {

        frame.setSize(new Dimension(800,480));
        frame.setLocation(new Point(400, 250));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPanes.setOpaque(true); //content panes must be opaque
        frame.setContentPane(tabbedPanes);

//        frame.pack();
        frame.setVisible(true);

    }

}
