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
import javax.swing.JTextField;
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

    public void siswa(tabelSiswa siswa, peminjaman pinjam) throws SQLException {
        
        try{
                String sql = "SELECT * FROM siswa ORDER BY nama";
                Statement st = con.getKoneksi().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    pinjam.comboBoxSiswa.addItem(rs.getString("nama"));
                }
                
                rs.last();
                int jumlahdata = rs.getRow();
                rs.first();
        }
        catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex);
        }
    }   
    
    public void buku(peminjaman pinjam) throws SQLException {
        
        try{
                String sql = "SELECT * FROM buku ORDER BY kode_buku";
                Statement st = con.getKoneksi().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    pinjam.comboBoxBuku.addItem(rs.getString("judul_buku"));
                }
                
                rs.last();
                int jumlahdata = rs.getRow();
                rs.first();
        }
        catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex);
    }
}
    
    @Override
    public void simpan(peminjaman pinjam) throws SQLException {
        String sql  = "INSERT INTO peminjaman (id_pinjam, tgl_pinjam, nama_siswa, lama_pinjam, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement prepare = konek.prepareStatement(sql)) {
            prepare.setString(1, null);
//            prepare.setString(5, buku.txtPengarang.getText());
            prepare.setString(2,((JTextField) pinjam.tanggal.getDateEditor().getUiComponent()).getText());
            prepare.setString(3, (String) pinjam.comboBoxSiswa.getSelectedItem());
//            prepare.setString(4, (String) pinjam.comboBoxBuku.getSelectedItem());
            prepare.setString(4, pinjam.txtLamaPinjam.getText());
//            prepare.setString(6, pinjam.st.getText());
            if (pinjam.dipinjam.isSelected())
            {
                prepare.setString(5, "Dipinjam");
            } else if (pinjam.dikembalikan.isSelected()){
                prepare.setString(5, "Dikembalikan");
            }            
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
