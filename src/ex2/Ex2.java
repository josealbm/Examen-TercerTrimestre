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
public class Ex2 {
    
    public static void main(String[] args) {
        ArrayList<Persona> listapersonas = new ArrayList<>();
        ArrayList<Plaza> listaplazas = new ArrayList<>();
        //llenamos las listas para hacer pruebas
        listapersonas.add(new Docente(Persona.contador++, "Pepito", "Grillo", 
                "Grillez", "Biología", 4.05));
        listapersonas.add(new Sanitario(Persona.contador++, "Sanitario", 
                "Sanitáriez", "Sanitísimo", "Anestesia", 43));
        listapersonas.add(new Docente(Persona.contador++, "Profesor", 
                "Profesórez", "Asignaturo", "Informática", 3.65));
        listapersonas.add(new Sanitario(Persona.contador++, "Sanitaria", 
                "Matasanos", "Sanguinoliento", "Cirujano", 83));
        
        listaplazas.add(new Plaza(1, "D", false, null));
        listaplazas.add(new Plaza(2, "D", false, null));
        listaplazas.add(new Plaza(3, "S", false, null));
        listaplazas.add(new Plaza(4, "S", false, null));
        listaplazas.add(new Plaza(5, "D", false, null));
        listaplazas.add(new Plaza(6, "S", false, null));
        
                
        adjudicarPlazas(listaplazas, listapersonas);
        mostrar_adjudicaciones(listaplazas);
    }
    
    
    public static void adjudicarPlazas(ArrayList<Plaza> listaplazas, 
            ArrayList<Persona> listapersonas){
        for (int i = 0; i < listaplazas.size(); i++) {
            if (listaplazas.get(i).getTipo_plaza().equals("D")){
                ArrayList<Persona> listaordenada = new ArrayList<>();
                for (int j = 0; j < listapersonas.size(); j++) {
                    int k = 0;                        
                    while (k < listaordenada.size() && 
                            ((Docente) listapersonas.get(i)).getPuntos()
                    > ((Docente) listaordenada.get(j)).getPuntos()) {
                    k++;
                    }
                    listaordenada.add(k, listapersonas.get(j));
                    listaplazas.get(i).setAdjudicada(true);
                    listaplazas.get(i).setPersona(listaordenada.get(j));
                    listapersonas.remove(j);
                }
               
            }else{
                ArrayList<Persona> listaordenada = new ArrayList<>(); 
                for (int j = 0; j < listapersonas.size(); j++) {
                    int k = 0;                        
                    while (k < listaordenada.size() && 
                            ((Sanitario) listapersonas.get(i))
                    .getDias_trabajados() > ((Sanitario) listaordenada.get(j))
                    .getDias_trabajados()) {
                        k++;
                    }
                    listaordenada.add(k, listapersonas.get(j));
                    listaplazas.get(i).setAdjudicada(true);
                    listaplazas.get(i).setPersona(listaordenada.get(j));
                    listapersonas.remove(j);
                }
            
            }
        
        }
    }
    
   
        
    }
   
}
