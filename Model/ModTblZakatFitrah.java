package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModTblZakatFitrah extends AbstractTableModel {
    
    List<ModZakatFitrah> lmzf;
    
    public ModTblZakatFitrah(List<ModZakatFitrah> lmzf){
        this.lmzf = lmzf;
    }
    
    @Override
    public int getRowCount() {
        return lmzf.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return lmzf.get(row).getNo();
            case 1:
                return lmzf.get(row).getNama();
            case 2:
                return lmzf.get(row).getAlamat();
            case 3:
                return lmzf.get(row).getJml_jiwa();
            case 4:
                return lmzf.get(row).getTotal();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "No";
            case 1:
                return "Nama";
            case 2:
                return "Alamat";
            case 3:
                return "Jiwa";
            case 4:
                return "Total";
            default:
                return null;
        }
    }
     
}
