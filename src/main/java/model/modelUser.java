/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package model;

import controller.controllerUser;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import views.formUser;

/**
 *
 * @author muham
 */
public class modelUser implements controllerUser {

    @Override
    public void tampil(formUser user) throws SQLException {
        user.tableModel.getDataVector().removeAllElements();
        user.tableModel.fireTableDataChanged();
        
        koneksi con = new koneksi();
        Connection konek = con.getKoneksi();
        String sql = "SELECT * FROM user";
        PreparedStatement prepare = konek.prepareStatement(sql);
        ResultSet rs = prepare.executeQuery(sql);
        
        while(rs.next())
        {
            Object[] obj    = new Object[5];
            obj[0]          = rs.getString(2);
            obj[1]          = rs.getString(3);
            obj[2]          = rs.getString(5);
            user.tableModel.addRow(obj);
        }
    }

    @Override
    public void tambah(formUser user) throws SQLException {
        koneksi con = new koneksi();
        Connection konek = con.getKoneksi();
        String sql  = "INSERT INTO user (user_id, username, name, password, role) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement prepare = konek.prepareStatement(sql);
        try {
            prepare.setString(1, null);
            prepare.setString(2, user.txtUsername.getText());
            prepare.setString(3, user.txtName.getText());
            prepare.setString(4, String.valueOf(user.txtPassword.getPassword()));
            prepare.setString(5, (String) user.txtRole.getSelectedItem());
            
            prepare.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            prepare.close();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            this.reset(user);
            this.tampil(user);
        }
    }

    public void update(formUser user) throws SQLException {
    koneksi con             = new koneksi();
    Connection konek        = con.getKoneksi();
        String sql              = "UPDATE user SET name='"+ user.txtName.getText() + "', password='"+ String.valueOf(user.txtPassword.getPassword()) +"', role='"+ user.txtRole.getSelectedItem() +"' where username='" + user.txtUsername.getText() + "'";
    try (PreparedStatement prepare = konek.prepareStatement(sql)) {
            
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            prepare.close();
            
        } catch (HeadlessException | SQLException e) {
            System.err.println(e);
        } finally {
            tampil(user);
        }
    }
    
    @Override
    public void reset(formUser user) {
        user.txtUsername.setText("");
        user.txtName.setText("");
        user.txtPassword.setText("");
    }
    
}
