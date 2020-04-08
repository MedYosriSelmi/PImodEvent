/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author Yosrio
 */
public class ListeParticipants {
    
    private int id;
    private int evenement_id;
    private int user_id;
    private Date date_participation;

    public ListeParticipants(int id, int evenement_id, int user_id, Date date_participation) {
        this.id = id;
        this.evenement_id = evenement_id;
        this.user_id = user_id;
        this.date_participation = date_participation;
    }

    public ListeParticipants(int evenement_id, int user_id, Date date_participation) {
        this.evenement_id = evenement_id;
        this.user_id = user_id;
        this.date_participation = date_participation;
    }

    public ListeParticipants(Date date_participation) {
        this.date_participation = date_participation;
    }

   

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvenement_id() {
        return evenement_id;
    }

    public void setEvenement_id(int evenement_id) {
        this.evenement_id = evenement_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate_participation() {
        return date_participation;
    }

    public void setDate_participation(Date date_participation) {
        this.date_participation = date_participation;
    }

    @Override
    public String toString() {
        return "ListeParticipants{" + "id=" + id + ", evenement_id=" + evenement_id + ", user_id=" + user_id + ", date_participation=" + date_participation + '}';
    }
    
    
}
