package tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.PracticaPedida;
 
public class ResultadosTableModel extends DefaultTableModel
{
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return columnIndex == 1;
    }

}