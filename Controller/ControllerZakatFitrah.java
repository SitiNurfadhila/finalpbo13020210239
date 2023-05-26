package Controller;

import DAO.DAOZakatFitrah;
import DAO.ImplementZakatFitrah;
import Model.ModTblZakatFitrah;
import Model.ModZakatFitrah;
import View.FormZakat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class ControllerZakatFitrah {
    FormZakat frame;
    ImplementZakatFitrah implZakatFitrah;
    List<ModZakatFitrah> lmzf;
    
    public ControllerZakatFitrah(FormZakat frame){
        this.frame = frame;
        implZakatFitrah = new DAOZakatFitrah();
        lmzf = implZakatFitrah.getAll();
    }
    
    public void reset(){
        frame.getTf_idzakat().setText("");
        frame.getTf_nama().setText("");
        frame.getTf_alamat().setText("");
        frame.getTf_jmljiwa().setText("");
        frame.getTf_zakatfitrah().setText("Rp. 30000");
        frame.getTf_total().setText("");
    }
    
    public void isiTable(){
        lmzf = implZakatFitrah.getAll();
        ModTblZakatFitrah mtzf = new ModTblZakatFitrah(lmzf);
        frame.getTbl_zakatfitrah().setModel(mtzf);
    }
    
    public void hitungZakat(){
        String zakat = frame.getTf_zakatfitrah().getText();
        String[] ZakatFitrah = zakat.split(" ");
        String Bagian1 = ZakatFitrah[1];
        int jumlah = Integer.valueOf(frame.getTf_jmljiwa().getText()) * Integer.valueOf(Bagian1);
        frame.getTf_total().setText("Rp. " + String.valueOf(jumlah));
    }
    
    public void isiField(int row){
        frame.getTf_idzakat().setText(String.valueOf(lmzf.get(row).getNo()));
        frame.getTf_nama().setText(lmzf.get(row).getNama());
        frame.getTf_alamat().setText(lmzf.get(row).getAlamat());
        frame.getTf_jmljiwa().setText(String.valueOf(lmzf.get(row).getJml_jiwa()));
        frame.getTf_total().setText("Rp. " + String.valueOf(lmzf.get(row).getTotal()));
    }
    
    public void insert(){
        String total = frame.getTf_total().getText();
        String[] split = total.split(" ");
        String Bagian1 = split[1];
        if(!frame.getTf_nama().getText().trim().isEmpty() & !frame.getTf_alamat().getText().trim().isEmpty()){
            ModZakatFitrah mzf = new ModZakatFitrah();
            mzf.setNama(frame.getTf_nama().getText());
            mzf.setAlamat(frame.getTf_alamat().getText());
            mzf.setJml_jiwa(Integer.valueOf(frame.getTf_jmljiwa().getText()));
            mzf.setTotal(Integer.valueOf(Bagian1));
            
            implZakatFitrah.insert(mzf);
            JOptionPane.showMessageDialog(null, "Data Telah di Simpan");
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal di Simpan");
        }
    }
    
    public void delete(){
        if(!frame.getTf_idzakat().getText().trim().isEmpty()){
            int no = Integer.parseInt(frame.getTf_idzakat().getText());
            implZakatFitrah.delete(no);
            JOptionPane.showMessageDialog(null, "Data Telah di Hapus");
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal di Hapus");
        }
    }
    
    public void update(){
        String total = frame.getTf_total().getText();
        String[] split = total.split(" ");
        String Bagian1 = split[1];
        if(!frame.getTf_idzakat().getText().trim().isEmpty()){
            ModZakatFitrah mzf = new ModZakatFitrah();
            mzf.setNama(frame.getTf_nama().getText());
            mzf.setAlamat(frame.getTf_alamat().getText());
            mzf.setJml_jiwa(Integer.valueOf(frame.getTf_jmljiwa().getText()));
            mzf.setTotal(Integer.valueOf(Bagian1));
            mzf.setNo(Integer.valueOf(frame.getTf_idzakat().getText()));
            
            implZakatFitrah.update(mzf);
            JOptionPane.showMessageDialog(null, "Data Telah di Update");
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal di Update");
        }
    }
    
    public void isiTableCariNama(){
        lmzf = implZakatFitrah.getCari(frame.getTf_carinama().getText());
        ModTblZakatFitrah mtzf = new ModTblZakatFitrah(lmzf);
        frame.getTbl_zakatfitrah().setModel(mtzf);
    }
    
    public void cariNama(){
        if(!frame.getTf_carinama().getText().trim().isEmpty()){
            implZakatFitrah.getCari(frame.getTf_carinama().getText());
            isiTableCariNama();
            setLebarKolom();
            setRataTengah();
        }else{
            JOptionPane.showMessageDialog(null, "Silahkan masukan nama terlebih dahulu");
        }
    }
    
    public void setLebarKolom(){
        TableColumn column;
        frame.getTbl_zakatfitrah().setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        int[] ukuran = {30, 100, 200, 40, 80};
        
        for(int i = 0; i < frame.getTbl_zakatfitrah().getColumnCount(); i++){
            column = frame.getTbl_zakatfitrah().getColumnModel().getColumn(i);
            column.setPreferredWidth(ukuran[i]);
        }
    }
    
    public void setRataTengah(){
        DefaultTableCellRenderer center = new DefaultTableCellHeaderRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i = 0; i < frame.getTbl_zakatfitrah().getColumnCount(); i++){
            frame.getTbl_zakatfitrah().getColumnModel().getColumn(i).setCellRenderer(center);
        }
    }
}
