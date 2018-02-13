package todo.ui.button;

import java.awt.event.ActionEvent;

public class DeleteButtonActionListener extends ListTableActionListener {
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        if(selectedRow == -1){
            return;
        }

        if(table.isEditing()){
            return;
        }

        list.remove(selectedRow);
        table.revalidate();
    }
}
