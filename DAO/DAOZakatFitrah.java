package DAO;

import Koneksi.KoneksiDB;
import Model.ModZakatFitrah;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOZakatFitrah implements ImplementZakatFitrah{
    
    Connection connection;
    final String insert = "INSERT INTO zakat (nama, alamat, jml_jiwa, total_zakat) VALUES (?, ?, ?, ?)";
    final String delete = "DELETE FROM zakat WHERE id_zakat=?";
    final String update = "UPDATE zakat SET nama=?, alamat=?, jml_jiwa=?, total_zakat=? WHERE id_zakat=?";
    final String select = "SELECT * FROM zakat";
    final String cariNama = "SELECT * FROM zakat WHERE nama LIKE ?";
    
    public DAOZakatFitrah(){
        connection = KoneksiDB.connection();
    }
    
    @Override
    public void insert(ModZakatFitrah mzf) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareCall(insert);
            statement.setString(1, mzf.getNama());
            statement.setString(2, mzf.getAlamat());
            statement.setInt(3, mzf.getJml_jiwa());
            statement.setInt(4, mzf.getTotal());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                mzf.setNo(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int no) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, no);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(ModZakatFitrah mzf) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, mzf.getNama());
            statement.setString(2, mzf.getAlamat());
            statement.setInt(3, mzf.getJml_jiwa());
            statement.setInt(4, mzf.getTotal());
            statement.setInt(5, mzf.getNo());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<ModZakatFitrah> getAll() {
        List<ModZakatFitrah> lmzf = null;
        try{
            lmzf = new ArrayList<ModZakatFitrah>();
            Statement st = connection.createStatement();
            
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                ModZakatFitrah mzf = new ModZakatFitrah();
                mzf.setNo(rs.getInt("id_zakat"));
                mzf.setNama(rs.getString("nama"));
                mzf.setAlamat(rs.getString("alamat"));
                mzf.setJml_jiwa(rs.getInt("jml_jiwa"));
                mzf.setTotal(rs.getInt("total_zakat"));
                lmzf.add(mzf);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return lmzf;
    }

    @Override
    public List<ModZakatFitrah> getCari(String nama) {
        List<ModZakatFitrah> lmzf = null;
        try{
            lmzf = new ArrayList<ModZakatFitrah>();
            PreparedStatement st = connection.prepareStatement(cariNama);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ModZakatFitrah mzf = new ModZakatFitrah();
                mzf.setNo(rs.getInt("id_zakat"));
                mzf.setNama(rs.getString("nama"));
                mzf.setAlamat(rs.getString("alamat"));
                mzf.setJml_jiwa(rs.getInt("jml_jiwa"));
                mzf.setTotal(rs.getInt("total_zakat"));
                lmzf.add(mzf);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return lmzf;
    }

    
    
}
