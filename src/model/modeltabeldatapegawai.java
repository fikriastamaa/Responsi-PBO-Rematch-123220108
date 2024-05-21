/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fikri
 */
public class modeltabeldatapegawai extends AbstractTableModel {
    List<datapegawai> dp;
    public modeltabeldatapegawai(List<datapegawai>dp){
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "NAMA";
            case 2:
                return "EMAIL";
            case 3:
                return "PASSWORD";
            case 4:
                return "ROLE";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getId();
            case 1:
                return dp.get(row).getNama();
            case 2:
                return dp.get(row).getEmail();
            case 3:
                return dp.get(row).getPassword();
            case 4:
                return dp.get(row).getRole();
            default:
                return null;
        }
    }
}
