/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package model;

import controller.controllerSiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import views.tabelSiswa;

/**
 *
 * @author muham
 */
public class modelSiswa implements controllerSiswa {

    @Override
    public void tampil(tabelSiswa siswa) throws SQLException {
        siswa.tableModel.getDataVector().removeAllElements();
        siswa.tableModel.fireTableDataChanged();
    
        koneksi con = new koneksi();
        Connection konek = con.getKoneksi();
        String sql = "SELECT * FROM siswa WHERE isAvailable = true";
        PreparedStatement sttmnt = konek.prepareStatement(sql);
        ResultSet rs = sttmnt.executeQuery(sql);
        
        while(rs.next())
        {
            Object[] obj    = new Object[5];
            obj[0]          = rs.getString(2);
            obj[1]          = rs.getString(3);
            obj[2]          = rs.getString(4);
            obj[3]          = rs.getString(5);
            siswa.tableModel.addRow(obj);
        }
    }

    @Override
    public void reset(tabelSiswa siswa) {
        siswa.txtNama.setText("");
        siswa.txtNISN.setText("");
        siswa.txtTempatLahir.setText("");
        siswa.txtNISN.setText("");
    }

    @Override
    public void simpan(tabelSiswa siswa) throws SQLException {
                koneksi con = new koneksi();
        Connection konek = con.getKoneksi();
        String sql  = "INSERT INTO siswa (id_siswa, nama, nisn, tempat_lahir, alamat, isAvailable) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement prepare = konek.prepareStatement(sql);
        try {
            prepare.setString(1, null);
            prepare.setString(2, siswa.txtNama.getText());
            prepare.setString(3, siswa.txtNISN.getText());
            prepare.setString(4, siswa.txtTempatLahir.getText());
            prepare.setString(5, siswa.txtNISN.getText());
            prepare.setBoolean(6, true);
            
            prepare.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            prepare.close();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            this.reset(siswa);
            this.tampil(siswa);
        }
    }
    
}
