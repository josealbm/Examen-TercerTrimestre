/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author infor15
 */
public class Ex1 {

    private final static String user = "alumne";
    private final static String password = "alualualu";
    private final static String base = "jdbc:mysql://192.168.56.101:3306/Beer";
    private final static String fileOut = "E:\\consultas.txt";
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        try (Connection con = DriverManager.getConnection(base, user, password)){

            while (!salir){    
                System.out.println("Escoge una opción");
                System.out.println("1. Insertar SERVES");
                System.out.println("2. Consultar DRINKER");
                System.out.println("3. Salir");
                int opcion = sc.nextInt();
                switch(opcion){
                    case 1 :{
                    try {
                        insertarServes(con);
                    }catch (SQLException ex) {
                        System.out.println("Error");
                        System.out.println(ex.getMessage());
                    }
                        break;
                    }
                    case 2 :{
                        consultarDrinker(con);
                        break;
                    }
                    case 3 :{
                        salir=true;
                        break;
                    }
                    default :{
                        System.out.println("Opción no contemplada, por favor, "
                                + "escoge una de que aparecen en en menú");
                        break;
                    }
                }

            }
        }catch (SQLException ex) {
           System.out.println("Error en la bbdd " + ex.getSQLState() + 
                   ex.getMessage());
        }catch (IOException ex) {
           System.out.println("Error de entrada/salida " + ex.getMessage());
        }catch (Exception ex){
            System.out.println("Error no controlado " + ex.getMessage());
        }
           
    }

  
    
    public static void insertarServes(Connection con) throws SQLException {
            Scanner sc = new Scanner(System.in);
            System.out.print("¿Cuántos inserts quieres hacer?: ");
            String ps = "INSERT INTO Serves(bar, beer, price) VALUES "
                        + "(?, ?, ?);";
            int n_inserts = sc.nextInt();
            if (n_inserts %3 != 0){
                System.out.println("Tienes que introducir los inserts de "
                        + "3 en 3");
            }else{
                try (PreparedStatement pst = con.prepareStatement(ps)) {
                    con.setAutoCommit(false);
                    System.out.println("Inserta los nuevos SERVES:");
                    for (int i = 0; i < n_inserts; i++) {
                        System.out.println("Insert nº" + (i + 1));
                        System.out.print("Nombre del bar: ");
                        sc.nextLine();  //Si no pongo esta entrada, me salta al
                        //siguiente "nextLine"
                        pst.setString(1, sc.nextLine());
                        System.out.print("Nombre de la cerveza: ");
                        pst.setString(2, sc.nextLine());
                        System.out.print("Precio de la cerveza: ");
                        pst.setFloat(3, sc.nextFloat());
                        pst.executeUpdate();
                    }
                    con.commit();                
                } catch (SQLException ex) {
                    System.out.println("Fallo en la transacción");
                    System.out.println(ex.getMessage());
                    con.rollback();
                } finally {
                    con.setAutoCommit(true);
                }
            }
    }
    
     public static void consultarDrinker(Connection con) throws IOException, 
             SQLException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter
        (fileOut));
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from Drinker")) {

            escritor.write("En la tabla DRINKER tenemos estos datos");
            escritor.newLine();
            escritor.write("=======================================");
            escritor.newLine();
            while (rs.next()) {
                escritor.write("Nombre del cliente: " + rs.getString("name"));
                escritor.newLine();
                escritor.write("Dirección del cliente: " 
                        + rs.getString("address"));
                escritor.newLine();
            }
            System.out.println("La consulta se ha volcado al archivo "
                    + "correctamente");
        }
     }
}
    

