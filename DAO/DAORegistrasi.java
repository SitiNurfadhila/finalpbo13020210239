package DAO;

import Koneksi.KoneksiDB;
import Model.ModRegistrasi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DAORegistrasi implements ImplementRegisLogin {
    
    Connection connection;
    final String registrasi = "INSERT INTO login (username, password, nama) VALUES (?, ?, ?)";
    final String login = "SELECT * FROM login WHERE username=? AND password=?";
    
    public DAORegistrasi(){
        connection = KoneksiDB.connection();
    }

    @Override
    public void Registrasi(ModRegistrasi mr) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(registrasi);
            statement.setString(1, mr.getUsername());
            statement.setString(2, mr.getPassword());
            statement.setString(3, mr.getNamalengkap());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void Login(ModRegistrasi mr) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareCall(login);
            statement.setString(1, mr.getUsername());
            statement.setString(2, mr.getPassword());
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                JOptionPane.showMessageDialog(null, "Login Berhasil dan ada di DATABASE");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
