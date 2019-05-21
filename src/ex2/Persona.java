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
public class Persona {
    protected static int contador = 1;
    protected int id;
    protected String nombre;
    protected String primer_apellido;
    protected String segundo_apellido;

    public Persona() {
        this.id = contador++;
    }

    public Persona(int id, String nombre, String primer_apellido, String segundo_apellido) {
        this.id = contador++;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
    }
    
    public Persona(Persona p) {
        this.id = p.id;
        this.nombre = p.nombre;
        this.primer_apellido = p.primer_apellido;
        this.segundo_apellido = p.segundo_apellido;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Persona.contador = contador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }
    
    
    
    
          
    
    
}
