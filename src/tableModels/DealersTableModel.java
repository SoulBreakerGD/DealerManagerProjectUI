package tableModels;

import data.Dealer;
import data.DealerList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.table.AbstractTableModel;

public class DealersTableModel extends AbstractTableModel
{
    private ArrayList<String> columnNames = new ArrayList(Arrays.asList("ID", "Name", "Address", "Phone", "Continuing"));
    private ArrayList<Dealer> list;
    private HashMap<Dealer, Boolean> data = new HashMap();    
    private int addedColumns = 0;

    public ArrayList<Dealer> getList() 
    {
        return list;
    }

    public HashMap<Dealer, Boolean> getData() 
    {
        return data;
    }
    
    public void setData(HashMap<Dealer, Boolean> data) 
    {
        this.data = data;
    }
    
    public DealersTableModel(DealerList list)
    {
        this.list = list.getList();
        data.clear();
        for (Dealer d : list) 
        {
            data.put(d, Boolean.FALSE);
        }
    }
    
    public DealersTableModel (ArrayList<Dealer> list)
    {
        this.list = list;
        data.clear();
        for (Dealer d : list) 
        {
            data.put(d, Boolean.FALSE);
        }
    }
    
    @Override
    public int getColumnCount() 
    {
      return columnNames.size();
    }
    
    @Override
    public int getRowCount() 
    {
        int size;
        if (list == null) 
        {
           size = 0;
        }
        else
        {
           size = list.size();
        }
        return size;
   }
    
    @Override
    public Object getValueAt(int row, int col)
    {
        Object temp = null;
//        if (col == 0) 
//        {
//            temp = list.get(row).getNum();
//        }
//        else 
            if (col == 0 + addedColumns) 
        {
            temp = list.get(row).getID();
        }
        else if (col == 1 + addedColumns) 
        {
            temp = list.get(row).getName();
        }
        else if (col == 2 + addedColumns) 
        {
            temp = list.get(row).getAddr();
        }
        else if (col == 3 + addedColumns) 
        {
            temp = list.get(row).getPhone();
        }
        else if (col == 4 + addedColumns) 
        {
            temp = list.get(row).isContinuing();
        }
        else temp = data.get(list.get(row));
        return temp;
    }

    @Override
    public boolean isCellEditable(int row, int col)
    {
        if (runtime.JFrameUI.EditMode)
        {
            return ((col != 0 + addedColumns) && (col != 5 + addedColumns));
        }
        return col == 0;
    }

    @Override
    public String getColumnName(int col)
    {
        return columnNames.get(col);
    }
    
    @Override
    public Class getColumnClass (int col) 
    {
        if (col == 4 + addedColumns) return Boolean.class;
        else if (col != 4 + addedColumns && col > 0) return String.class;
        return String.class;
    }

    @Override
    public void setValueAt(Object value, int row, int col)
    {
        if (col == 0 + addedColumns)
        {
            list.get(row).setID((String)value);
            runtime.JFrameUI.setSaved(Boolean.FALSE);
        }
        else if (col == 1 + addedColumns) 
        {
            list.get(row).setName((String)value);
            runtime.JFrameUI.setSaved(Boolean.FALSE);
        }
        else if (col == 2 + addedColumns) 
        {
            list.get(row).setAddr((String)value);
            runtime.JFrameUI.setSaved(Boolean.FALSE);
        }
        else if (col == 3 + addedColumns)
        {
            list.get(row).setPhone((String)value);
            runtime.JFrameUI.setSaved(Boolean.FALSE);
        }
        else if (col == 4 + addedColumns) 
        {
            list.get(row).setContinuing((Boolean)value);
            runtime.JFrameUI.setSaved(Boolean.FALSE);
        }
    }
    
    public void addColumn(Object o) 
    {
        columnNames.add(0, (String) o);
        addedColumns++;
    }
}