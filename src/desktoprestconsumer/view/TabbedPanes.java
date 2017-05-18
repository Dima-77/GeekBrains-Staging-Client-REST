package desktoprestconsumer.view;

import javax.swing.*;

/**
 * Created by Dima on 18.05.2017.
 */
public class TabbedPanes extends JTabbedPane{
    public TabbedPanes() {
        addTab("Список личностей", new PersonTable());
        addTab("Рейтинг", new RatingTable());
    }
}
