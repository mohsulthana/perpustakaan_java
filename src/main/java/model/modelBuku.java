/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package model;

import controller.controllerBuku;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import views.formBuku;

/**
 *
 * @author muham
 */
public class modelBuku implements controllerBuku {

    @Override
    public void simpan(formBuku buku) throws SQLException {
        
        koneksi con = new koneksi();
        Connection konek = con.getKoneksi();
        String sql  = "INSERT INTO buku (id_buku, kode_buku, judul_buku, isbn, pengarang) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement prepare = konek.prepareStatement(sql)) {
            prepare.setString(1, null);
            prepare.setString(2, buku.txtKodeBuku.getText());
            prepare.setString(3, buku.txtJudulBuku.getText());
            prepare.setString(4, buku.txtISBN.getText());
            prepare.setString(5, buku.txtPengarang.getText());
            
            prepare.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void tampil(formBuku buku) throws SQLException {
        buku.tableModel.getDataVector().removeAllElements();
        buku.tableModel.fireTableDataChanged();
        
        try {
            koneksi con         = new koneksi();
            Connection konek    = con.getKoneksi();
            Statement sttmnt    = konek.createStatement();
            String sql          = "SELECT * FROM buku";
            ResultSet rs        = sttmnt.executeQuery(sql);
            
            while(rs.next())
            {
                Object[] obj    = new Object[4];
                obj[0]          = rs.getString(1);
                obj[1]          = rs.getString(2);
                obj[2]          = rs.getString(3);
                obj[3]          = rs.getString(4);
                buku.tableModel.addRow(obj);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void hapus(formBuku buku) throws SQLException {
        koneksi con             = new koneksi();
        Connection konek        = con.getKoneksi();
        String sql              = "DELETE FROM buku where kodeBuku = ?";
        try (PreparedStatement prepare = konek.prepareStatement(sql)) {
            prepare.setString(1, buku.txtKodeBuku.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (HeadlessException | SQLException e) {
            System.err.println(e);
        } finally {
            tampil(buku);
            buku.setLebarKolom();
        }
    }

    @Override
    public void reset(formBuku buku) throws SQLException {
        buku.txtISBN.setText("");
        buku.txtJudulBuku.setText("");
        buku.txtPengarang.setText("");
        buku.txtKodeBuku.setText("");
    }
}
