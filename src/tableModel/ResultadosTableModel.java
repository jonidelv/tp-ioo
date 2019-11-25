package tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.PracticaPedida;
 
public class ResultadosTableModel extends AbstractTableModel
{
    private final List<PracticaPedida> practicasPedidas;
     
    private final String[] columnNames = new String[] {
            "Pratica", "Resultado"
    };
    private final Class[] columnClass = new Class[] {
            String.class, String.class
        };
 
    public ResultadosTableModel(List<PracticaPedida> practicasPedidas)
    {
        this.practicasPedidas = practicasPedidas;
    }

     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return this.practicasPedidas.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        PracticaPedida pp = practicasPedidas.get(rowIndex);
        if(1 == columnIndex) {
            pp.setResultado(aValue.toString());
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }
}