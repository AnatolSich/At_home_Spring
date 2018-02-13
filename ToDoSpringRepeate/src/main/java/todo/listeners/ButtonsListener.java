package todo.listeners;

import javax.swing.*;

import java.awt.Component;

import java.awt.event.ActionListener;
import java.util.List;

public abstract class ButtonsListener implements ActionListener {

    protected JTable table;
    protected List<String> list;

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setList(List list) {
        this.list = list;
    }
}
