/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package controller;

import java.sql.SQLException;
import views.dashboard;
import views.peminjaman;

/**
 *
 * @author muham
 */
public interface controllerPeminjaman {
    public void tampil(dashboard pinjam) throws SQLException;
    public void simpan(peminjaman pinjam) throws SQLException;
    public void statusSelesai(peminjaman pinjam) throws SQLException;
}
