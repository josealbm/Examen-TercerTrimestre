/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.util.ArrayList;

/**
 *
 * @author infor15
 */
public class Plaza {
    private int id_plaza;
    private String tipo_plaza;
    private boolean adjudicada;
    private Persona persona;

    public Plaza() {
    }

    public Plaza(int id_plaza, String tipo_plaza, boolean adjudicada, Persona persona) {
        this.id_plaza = id_plaza;
        this.tipo_plaza = tipo_plaza.toUpperCase();
        this.adjudicada = false;
        this.persona = null;
    }
    
    public Plaza(Plaza plaz) {
        this.id_plaza = plaz.id_plaza;
        this.tipo_plaza = plaz.tipo_plaza;
        this.adjudicada = plaz.adjudicada;
        this.persona = plaz.persona;
    }

    public int getId_plaza() {
        return id_plaza;
    }

    public void setId_plaza(int id_plaza) {
        this.id_plaza = id_plaza;
    }

    public String getTipo_plaza() {
        return tipo_plaza;
    }

    public void setTipo_plaza(String tipo_plaza) {
        this.tipo_plaza = tipo_plaza.toUpperCase();
    }

    public boolean isAdjudicada() {
        return adjudicada;
    }

    public void setAdjudicada(boolean adjudicada) {
        this.adjudicada = adjudicada;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
     public static void mostrar_adjudicaciones(ArrayList<Plaza> listaplazas){
        for (int i = 0; i < listaplazas.size(); i++) {
            System.out.println("La última adjucicación de plazas ha producido"
                 + "los siguientes resultados para DOCENTES");
            System.out.println("ID Plaza: " + listaplazas.get(i).getId_plaza());
            System.out.println("Tipo: " + listaplazas.get(i).getTipo_plaza());
            System.out.println("Adjudicada: " + listaplazas.get(i).isAdjudicada());
            System.out.println("ID: " + listaplazas.get(i).getPersona().getId());
            System.out.println("Nombre: " + listaplazas.get(i).getPersona().
                    getNombre());
            System.out.println("Apellido 1: " +listaplazas.get(i).getPersona()
                    .getPrimer_apellido());
             
             
         }
     }
}
