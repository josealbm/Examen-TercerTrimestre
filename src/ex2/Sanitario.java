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
public class Sanitario extends Persona{
    private String especialidad;
    private int dias_trabajados;

    public Sanitario() {
        this.id = contador++;
    }

    public Sanitario(String especialidad, int dias_trabajados) {
        this.especialidad = especialidad;
        this.dias_trabajados = dias_trabajados;
    }
    
    public Sanitario(Sanitario s){
        this.especialidad = s.especialidad;
        this.dias_trabajados = s.dias_trabajados;
    }
    public Sanitario(int id, String nombre, String primer_apellido, String 
        segundo_apellido, String especialidad, int dias_trabajados){
        super(id, nombre, primer_apellido, segundo_apellido);
        this.especialidad = especialidad;
        this.dias_trabajados = dias_trabajados;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getDias_trabajados() {
        return dias_trabajados;
    }

    public void setDias_trabajados(int dias_trabajados) {
        this.dias_trabajados = dias_trabajados;
    }
    
    
    
}
