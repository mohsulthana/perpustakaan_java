/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package controller;

import java.sql.SQLException;
import views.formPenerbit;

/**
 *
 * @author muham
 */
public interface controllerPenerbit {
    public void tampil(formPenerbit penerbit) throws SQLException;

    /**
     *
     * @param penerbit
     * @throws SQLException
     */
    public void insert(formPenerbit penerbit) throws SQLException;
}
