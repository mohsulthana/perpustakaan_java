/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package model;

import controller.controllerPeminjaman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import views.dashboard;
import views.admin_dashboard;
import views.peminjaman;
import views.tabelSiswa;

/**
 *
 * @author muham
 */
public final class modelPeminjaman implements controllerPeminjaman {
    koneksi con         = new koneksi();
    Connection konek    = con.getKoneksi();
    
    public modelPeminjaman() throws SQLException {
        peminjaman pinjam = null;
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

public void siswa(peminjaman pinjam) throws SQLException {
        koneksi conn = new koneksi();
        Connection koneksi = conn.getKoneksi();
        Statement st = null;
        ResultSet rs = null;
        
        try{
            String sql = "SELECT * FROM siswa";
            rs = st.executeQuery(sql);
                while(rs.next())
                {
                    pinjam.comboboxsiswa.addItem(rs.getString(2));
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        finally{
            try{
                st.close();
                rs.close();
                con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR CLOSE");
        }
    
        }
}
    @Override
    public void simpan(peminjaman pinjam) throws SQLException {
        koneksi conn = new koneksi();
        Connection koneksi = conn.getKoneksi();
        String sql  = "INSERT INTO peminjaman (id_pinjam, tgl_pinjam, nama_siswa, buku, lama_pinjam, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement prepare = koneksi.prepareStatement(sql)) {
            prepare.setString(1, null);
//            prepare.setString(5, buku.txtPengarang.getText());
            prepare.setString(3, (String) pinjam.comboboxsiswa.getSelectedItem());
            prepare.setString(4, (String) pinjam.comboBoxBuku.getSelectedItem());
            prepare.setString(5, pinjam.txtLamaPinjam.getText());
//            prepare.setString(6, pinjam.st.getText());
            
            prepare.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        }
    }

    @Override
    public void statusSelesai(peminjaman pinjam) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
