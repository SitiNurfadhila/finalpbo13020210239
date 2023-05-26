
package Controller;

import DAO.DAORegistrasi;
import Model.ModRegistrasi;
import View.FormLogin;
import View.FormRegistrasi;
import javax.swing.JOptionPane;
import DAO.ImplementRegisLogin;

public class ControllerRegistrasi {
    
    FormRegistrasi frame;
    ImplementRegisLogin implRegistrasi;
    
    public ControllerRegistrasi(FormRegistrasi frame){
       this.frame = frame;
       implRegistrasi = new DAORegistrasi();
    }
    
    public void reset(){
        frame.getTf_NamaLengkap().setText("");
        frame.getTf_Username().setText("");
        frame.getTf_Password().setText("");
        frame.getTf_UlangPassword().setText("");
    }
    
    public void registrasi(){
        String username = frame.getTf_Username().getText().trim();
        String namalengkap = frame.getTf_Username().getText().trim();
        String password = String.valueOf(frame.getTf_Password().getPassword());
        String retypePassword = String.valueOf(frame.getTf_UlangPassword().getPassword());
        
        if(!username.isEmpty() && !namalengkap.isEmpty() ){
            ModRegistrasi mr = new ModRegistrasi();
            mr.setNamalengkap(frame.getTf_NamaLengkap().getText().trim());
            mr.setUsername(frame.getTf_Username().getText().trim());
            mr.setPassword(String.valueOf(frame.getTf_Password().getPassword()));
            if(password.equals(retypePassword)){
                implRegistrasi.Registrasi(mr);
                JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
            }else{
                JOptionPane.showMessageDialog(null, "Password tidak MATCH");
            } 
        }else{
            JOptionPane.showMessageDialog(null, "Registrasi Gagal");
        }
    }
}
