/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package controller;

import java.sql.SQLException;
import views.formBuku;

/**
 *
 * @author muham
 */
public interface controllerBuku {
    public void simpan(formBuku buku) throws SQLException;
    public void tampil(formBuku buku) throws SQLException;
    public void hapus(formBuku buku) throws SQLException;
    public void reset(formBuku buku) throws SQLException;
}
