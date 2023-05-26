package Controller;

import DAO.DAORegistrasi;
import DAO.ImplementRegisLogin;
import Model.ModRegistrasi;
import View.FormLogin;
import javax.swing.JOptionPane;

public class ControllerLogin {
    FormLogin frame;
    ImplementRegisLogin implLogin;
    
    public ControllerLogin(FormLogin frame){
        this.frame = frame;
        implLogin = new DAORegistrasi();
    }
    
    public void Login(){
        String username = frame.getTf_Username().getText();
        String password = String.valueOf(frame.getTf_Password().getPassword());
        if(!username.isEmpty() && !password.isEmpty()){
            ModRegistrasi mr = new ModRegistrasi();
            mr.setUsername(frame.getTf_Username().getText().trim());
            mr.setPassword(String.valueOf(frame.getTf_Password().getPassword()));
            implLogin.Login(mr);
        }else{
            JOptionPane.showMessageDialog(null, "Masukan kembali Password dan Username");
        }
            
    }
}
