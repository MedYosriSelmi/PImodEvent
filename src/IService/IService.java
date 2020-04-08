/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Evenement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Yosrio
 * @param <T>
 * */
public interface IService<T> {
    /*void ajouter(T t) throws SQLException;
    public void delete(Evenement a) throws SQLException ;

    void update(T t) throws SQLException;
    List<T> readAll() throws SQLException;*/
    void ajouter(Evenement a) throws SQLException;
    void delete(Evenement t) throws SQLException;
    void update(int id ,int user_id,String nom,String description,Date date_debut,Date date_fin,String validite,int nbre_places,String photo) throws SQLException;
    List<T> readAll() throws SQLException;
}
