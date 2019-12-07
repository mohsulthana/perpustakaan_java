/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package model;

import controller.controllerPeminjaman;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import koneksi.koneksi;
import views.dashboard;
import views.admin_dashboard;
import views.peminjaman;

/**
 *
 * @author muham
 */
public final class modelPeminjaman implements controllerPeminjaman {
    koneksi con         = new koneksi();
    Connection konek    = con.getKoneksi();
    
    public modelPeminjaman() throws SQLException {
        peminjaman pinjam = null;
//        this.fillComboSiswa(pinjam);
    }

    @Override
    public void tampil(dashboard pinjam) throws SQLException {
        pinjam.tableModel.getDataVector().removeAllElements();
        pinjam.tableModel.getDataVector().removeAllElements();
        
        try {
            Statement sttmnt    = konek.createStatement();
            String sql          = "SELECT * FROM peminjaman";
            ResultSet rs        = sttmnt.executeQuery(sql);
            
            while(rs.next())
            {
                Object[] obj    = new Object[2];
                obj[0]          = rs.getString(1);
                obj[1]          = rs.getString(2);
                obj[2]          = rs.getString(3);
                obj[3]          = rs.getString(4);
                obj[4]          = rs.getString(5);
                pinjam.tableModel.addRow(obj);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public void tampil_admin(admin_dashboard pinjam) throws SQLException {
        pinjam.tableModel.getDataVector().removeAllElements();
        pinjam.tableModel.getDataVector().removeAllElements();
        
        try {
            Statement sttmnt    = konek.createStatement();
            String sql          = "SELECT * FROM peminjaman";
            ResultSet rs        = sttmnt.executeQuery(sql);
            
            while(rs.next())
            {
                Object[] obj    = new Object[2];
                obj[0]          = rs.getString(1);
                obj[1]          = rs.getString(2);
                obj[2]          = rs.getString(3);
                obj[3]          = rs.getString(4);
                obj[4]          = rs.getString(5);
                pinjam.tableModel.addRow(obj);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void simpan(peminjaman pinjam) throws SQLException {
        
    }

    @Override
    public void statusSelesai(peminjaman pinjam) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hapus(peminjaman pinjam) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void fillComboSiswa(peminjaman pinjam) throws SQLException {
        Statement sttmnt    = konek.createStatement();
        String sql          = "SELECT * FROM siswa";
        ResultSet rs        = sttmnt.executeQuery(sql);
    }
}
