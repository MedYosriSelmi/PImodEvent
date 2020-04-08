/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Evenement;
import IService.IService;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Yosrio
 */
public class ServiceEvenement implements IService<Evenement> {
 
   

     private Connection con;
    private Statement ste;

    public ServiceEvenement() {
        con = DataBase.getInstance().getConnection();
    }
    @Override
    public void ajouter(Evenement a) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `pidev`.`evenement` (`id`,`user_id`, `nom`, `description`,`date_debut`, `date_fin`, `validite`,`nbre_places`,`photo`) VALUES ( '" + a.getId()+  "','" + a.getUser_id()+  " ','" + a.getNom()+ "', '" + a.getDescription()+  "','" + a.getDate_debut()+  "','" + a.getDate_fin()+"','" + a.getValidite()+  "','" + a.getNbre_places()+  "','" + a.getPhoto()+  "');";
        ste.executeUpdate(requeteInsert);
        System.out.println("evenement ajouté");
    }
     

     @Override
    public void delete(Evenement t) throws SQLException {
      String querry = "DELETE FROM evenement WHERE id =?";
        PreparedStatement d = con.prepareStatement(querry);
        d.setInt(1, t.getId());
        d.executeUpdate();
        System.out.println("evenement supprimé");
    }
   @Override
       public void update(int id ,int user_id,String nom,String description,Date date_debut,Date date_fin,String validite,int nbre_places,String photo) throws SQLException {
        PreparedStatement pla = con.prepareStatement("update evenement set  user_id=? , nom=? , description=?,date_debut=?,date_fin=?,validite=?,nbre_places=?,photo=? where id=?");
        pla.setInt(1,user_id ); 
        pla.setString(2, nom);
        pla.setString(3, description);
        pla.setDate(4, date_debut);
        pla.setDate(5, date_fin);
        pla.setString(6, validite);
        pla.setInt(7, nbre_places);
        pla.setString(8, photo);
        pla.setInt(9,id);
        pla.executeUpdate();
        System.out.println("evenement modifié");

    }
   

    @Override
    public List<Evenement> readAll() throws SQLException {
        List<Evenement> arr=new ArrayList<>();
    ste=con.createStatement();
    
    ResultSet rs=ste.executeQuery("select * from evenement");
     while (rs.next()) {                
               int id=rs.getInt("id");
               int user_id=rs.getInt("user_id");
               String nom=rs.getString("nom");
               String description=rs.getString("description");
               Date date_debut = rs.getDate("date_debut");
               Date date_fin = rs.getDate("date_fin");
               String validite=rs.getString("validite");
               int nbre_places=rs.getInt("nbre_places");
               String photo=rs.getString("photo");
               Evenement e=new Evenement(id, user_id, nom, description,date_debut,date_fin,validite
               ,nbre_places,photo);
               arr.add(e);
               }
         return arr;
         }

}
