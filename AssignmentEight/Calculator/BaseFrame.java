package AssignmentEight.Calculator;

import javax.swing.*;
import java.awt.*;

public abstract class BaseFrame extends JFrame {
    public BaseFrame(){
        create();
        Container con = getContentPane();
        add(con);
        addListeners();
        makeItVisible();

    }

    private void makeItVisible(){
        setSize(280,400);
        setVisible(true);
    }
    protected abstract void add(Container con);

    protected abstract void addListeners();

    protected abstract void create();
}
