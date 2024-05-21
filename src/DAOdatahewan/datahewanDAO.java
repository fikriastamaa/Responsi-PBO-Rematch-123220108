/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatahewan;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.datahewanimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fikri
 */
public class datahewanDAO implements datahewanimplement {
    Connection connection;
    
    final String select = "select * from hewan;";
    final String insert = "INSERT INTO hewan (nama, kelas, jenis_makanan) VALUES (?, ?, ?);";
    final String update = "update hewan set nama=?, kelas=?, jenis_makanan=? where id=?";
    final String delete = "delete from hewan where id=?";
    public datahewanDAO(){
        connection = connector.connection();
    }
    
    @Override
    public void insert(datahewan p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getKelas());
            statement.setString(3, p.getJenismakanan());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Hewan berhasil ditambahkan");
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
    public void update(datahewan p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getKelas());
            statement.setString(3, p.getJenismakanan());
            statement.setInt(4, p.getId());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hewan berhasil diupdate");
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
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hewan berhasil dihapus");
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
    public List<datahewan> getAll() {
        List<datahewan> dh = null;
        try {
            dh = new ArrayList<datahewan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()) {
                datahewan hw = new datahewan();
                hw.setId(rs.getInt("id"));
                hw.setNama(rs.getString("nama"));
                hw.setKelas(rs.getString("kelas"));
                hw.setJenismakanan(rs.getString("jenis_makanan"));
                dh.add(hw);
            }
        } catch (SQLException ex) {
            Logger.getLogger(datahewanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dh;
    }
    
}
