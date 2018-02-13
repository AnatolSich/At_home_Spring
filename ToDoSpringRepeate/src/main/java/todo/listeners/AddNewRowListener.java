package todo.listeners;

import todo.listeners.ButtonsListener;

import java.awt.*;
import java.awt.event.ActionEvent;

public class AddNewRowListener extends ButtonsListener{

    public void actionPerformed(ActionEvent e) {
        list.add("New item");
        table.revalidate();
    }
}
