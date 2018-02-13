package todo.ui.button;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.util.List;

public abstract class ListTableActionListener implements ActionListener{
    protected JTable table;
    protected List list;

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setList(List list) {
        this.list = list;
    }
}
