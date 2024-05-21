/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.ArrayList;
import DAOdatapegawai.datapegawaiDAO;
import DAOImplement.datapegawaiimplement;
import model.*;
import view.*;

/**
 *
 * @author Fikri
 */
public class datapegawaicontroller {
    PegawaiView pegawai;

    datapegawaiimplement impldatapegawai;
    List<datapegawai> dp;
    
    public datapegawaicontroller(PegawaiView pegawai){
        this.pegawai = pegawai;
        impldatapegawai = new datapegawaiDAO();
        dp = impldatapegawai.getAll();
    }
    
    public void isitabel(){
        dp = impldatapegawai.getAll();
        modeltabeldatapegawai mp = new modeltabeldatapegawai(dp);
        pegawai.getTabelDatapegawai().setModel(mp);
    }
}
