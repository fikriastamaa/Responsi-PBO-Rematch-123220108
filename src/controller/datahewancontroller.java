/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.ArrayList;
import DAOdatahewan.datahewanDAO;
import DAOImplement.datahewanimplement;
import javax.swing.JOptionPane;
import model.*;
import view.*;

/**
 *
 * @author Fikri
 */
public class datahewancontroller {
    MainView frame;
    TambahView tambah;
    EditView edit;
    datahewanimplement impldatahewan;
    List<datahewan> dh;
    
    public datahewancontroller(MainView frame){
        this.frame = frame;
        impldatahewan = new datahewanDAO();
        dh = impldatahewan.getAll();
    }
    
    public datahewancontroller(TambahView tambah){
        this.tambah = tambah;
        impldatahewan = new datahewanDAO();
        dh = impldatahewan.getAll();
    }
    
    public datahewancontroller(EditView edit){
        this.edit = edit;
        impldatahewan = new datahewanDAO();
        dh = impldatahewan.getAll();
    }
    
    public void isitabel(){
        dh = impldatahewan.getAll();
        modeltabeldatahewan mp = new modeltabeldatahewan(dh);
        frame.getTabelDatahewan().setModel(mp);
    }
    
    public void insert(){ 
        datahewan dh = new datahewan();
        dh.setNama(tambah.getJTxtnama().getText());
        dh.setKelas(tambah.getJtxtkelas().getText());
        dh.setJenismakanan(tambah.getJtxtjenis().getText());
        impldatahewan.insert(dh);
    }
    
    public void update(){
        datahewan dh = new datahewan();
        dh.setNama(edit.getJTxtnama().getText());
        dh.setKelas(edit.getJtxtkelas().getText());
        dh.setJenismakanan(edit.getJtxtjenis().getText());
        dh.setId(Integer.parseInt(edit.getJTxtid().getText()));
        impldatahewan.update(dh);
    }
    
    public void delete(){
        int id = frame.getSelectedId();
        if (id != -1) {
            impldatahewan.delete(id);
        }
    }
    
    public void cari(String keyword, String category) {
        List<datahewan> hasilPencarian = new ArrayList<>();
        List<datahewan> semuaData = impldatahewan.getAll();

        for (datahewan hewan : semuaData) {
            if (category.equalsIgnoreCase("Nama")) {
                if (hewan.getNama().equalsIgnoreCase(keyword)) {
                    hasilPencarian.add(hewan);
                }
            } else if (category.equalsIgnoreCase("Kelas")) {
                if (hewan.getKelas().equalsIgnoreCase(keyword)) {
                    hasilPencarian.add(hewan);
                }
            } else if (category.equalsIgnoreCase("Jenis")) {
                if (hewan.getJenismakanan().equalsIgnoreCase(keyword)) {
                    hasilPencarian.add(hewan);
                }
            }
        }

        modeltabeldatahewan model = new modeltabeldatahewan(hasilPencarian);
        frame.getTabelDatahewan().setModel(model);
        
        if (hasilPencarian.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Hewan yang Anda cari tidak ditemukan");
        }
    }
}
