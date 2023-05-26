package Koneksi;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class KoneksiDB {
     
   static Connection con;
   
   public static Connection connection(){
       if(con == null){
           MysqlDataSource data = new MysqlDataSource();
           data.setDatabaseName("db_zakat");
           data.setUser("root");
           data.setPassword("");
           try{
               con = data.getConnection();
               //System.out.println("Database Berhasil Terhubung");
           }catch(SQLException e){
               e.printStackTrace();
               //System.out.println("Database Gagal Terhubung");
           }
       }
       
       return con;
   }
    
}
