/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import java.sql.*;
import backend.*;

/**
 *
 * @author Rossy
 */
public class Anggota {
    private int idAnggota;
    private String nama;
    private String alamat;
    private String telepon;

    public int getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Anggota() {
    }

    public Anggota(String nama, String alamat, String telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }
    
    public Anggota getById(int id) {
        Anggota agt = new Anggota();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM anggota " + " WHERE idAnggota = '" + id + "'");

        try {
            while (rs.next()) {
                agt = new Anggota();
                agt.setIdAnggota(rs.getInt("idAnggota"));
                agt.setNama(rs.getString("nama"));
                agt.setAlamat(rs.getString("alamat"));
                agt.setTelepon(rs.getString("telepon"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agt;
    }

    public ArrayList<Anggota> getAll() {
        ArrayList<Anggota> ListAnggota = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM anggota");

        try {
            while (rs.next()) {
                Anggota agt = new Anggota();
                agt.setIdAnggota(rs.getInt("idAnggota"));
                agt.setNama(rs.getString("nama"));
                agt.setAlamat(rs.getString("alamat"));
                agt.setTelepon(rs.getString("telepon"));

                ListAnggota.add(agt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListAnggota;
    }

    public ArrayList<Anggota> search(String keyword) {
        ArrayList<Anggota> ListAnggota = new ArrayList();

        String sql = "Select * from anggota where " + " nama like '%" + keyword + "%' " + " or alamat like '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Anggota agt = new Anggota();
                agt.setIdAnggota(rs.getInt("idAnggota"));
                agt.setNama(rs.getString("nama"));
                agt.setAlamat(rs.getString("alamat"));
                agt.setTelepon(rs.getString("telepon"));

                ListAnggota.add(agt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListAnggota;
    }
    
    public void save(){
        if(getById(idAnggota).getIdAnggota() == 0){
            String SQL = "Insert into anggota (nama,alamat,telepon) values(" 
                    + " '" +this.nama + "', "
                    + " '" +this.alamat + "', "
                    + " '"+this.telepon+"' "
                    + " )";
                    this.idAnggota = DBHelper.insertQueryGetId(SQL);
        }else{
            String SQL = "Update anggota set"
                   + " nama = '" +this.nama +"', "
                   + " alamat = '" +this.alamat +"', "
                   + " telepon = '"+this.telepon+"' "
                   +"Where idAnggota = '"+this.idAnggota+"'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM anggota WHERE idAnggota = '"+this.idAnggota+"'";
        DBHelper.executeQuery(SQL);
    }
}
