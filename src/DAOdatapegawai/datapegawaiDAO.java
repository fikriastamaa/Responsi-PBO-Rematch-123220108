/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatapegawai;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.datapegawaiimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fikri
 */
public class datapegawaiDAO implements datapegawaiimplement{
    Connection connection;
    
    final String select = "select * from pegawai;";
    
    public datapegawaiDAO(){
        connection = connector.connection();
    }
    
    public boolean cekUser(String username, String password) {
        String sql = "SELECT * FROM pegawai WHERE nama = ? AND password = ?";
        
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet rs = statement.executeQuery();
            
            return rs.next(); // Returns true if a record is found
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<datapegawai> getAll() {
        List<datapegawai> dp = null;
        try {
            dp = new ArrayList<datapegawai>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()) {
                datapegawai pg = new datapegawai();
                pg.setId(rs.getInt("id"));
                pg.setNama(rs.getString("nama"));
                pg.setEmail(rs.getString("email"));
                pg.setPassword(rs.getString("password"));
                pg.setRole(rs.getString("role"));
                dp.add(pg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(datapegawaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }
}
