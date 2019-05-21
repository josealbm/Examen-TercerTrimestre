/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author infor15
 */
public class Docente extends Persona{
    private String titulacion;
    private double puntos;

    public Docente() {
        this.id = contador++;
    }

    public Docente(String titulacion, double puntos) {
        this.titulacion = titulacion;
        this.puntos = puntos;
    }
    
    public Docente(int id, String nombre, String primer_apellido, String 
            segundo_apellido, String titulacion, double puntos){
        super(id, nombre, primer_apellido, segundo_apellido);
        this.titulacion = titulacion;
        this.puntos = puntos;
    }
    
    public Docente(Docente d){
        this.titulacion = d.titulacion;
        this.puntos = d.puntos;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }
    
    
    
    
    
    
}
