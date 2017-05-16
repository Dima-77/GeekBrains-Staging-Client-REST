package desktoprestconsumer;

import desktoprestconsumer.view.RestConsumerGUI;

/**
 * Created by Dima on 10.05.2017.
 */
public class DesktopRestConsumer {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RestConsumerGUI();
            }
        });
    }

}
