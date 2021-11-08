
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.io.*;
import javax.swing.JOptionPane;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class USUARIOS {
    
    JFrame Ventana = new JFrame();
    JFrame Ventana2 = new JFrame();
    NuevoUsuario UsuarioNue = new NuevoUsuario();//paquete se creo
    
    private String id_depa= "vacio";//estas son las variables
    private String Nombre = "vacio";
    private String Apellido = "Vacio";
    private double Telefono = 0.00;
    private double FechaNacimiento = 0.00;
    private String Correo = "vacio";
    private double FechaRegistro = 0.00;
    private String id_regis = "vacio";
            
    
    public void FormularNuevoUsuario(){
    
        Ventana.getContentPane().add(UsuarioNue);
        Ventana.pack();
        Ventana.setVisible(true);
        //la formulacion de ventanas para que se muestre lo ingresado
        
    }
    
    public void VerUsuario(){
    //estructura para la tabla
    
    Vector columnas = new Vector();//estoy nombrando los nombre de las columnas
    columnas.add("id_depa");
    columnas.add("id_regis");
    columnas.add("Nombre");
    columnas.add("Apellido");
    columnas.add("Telefono");
    columnas.add("Correo");
    columnas.add("FechaNacimiento");
    columnas.add("FechaRegistro");
    
    Vector filas = new Vector();
    Vector fila = new Vector();
    
   
    
        fila.add(id_depa);//nombrando los nombre de las filas 
        fila.add(id_regis);
        fila.add(Nombre);
        fila.add(Apellido);
        fila.add(Telefono);
        fila.add(FechaNacimiento);
        fila.add(FechaRegistro);
        fila.add(Correo);
        filas.add(fila);
    
    
    
    JTable tabla = new JTable(filas,columnas);//hacieno un llamado de la tabla
    JScrollPane scroll = new JScrollPane(tabla);
    Ventana2.getContentPane().add(scroll);
    Ventana2.setLocationRelativeTo(null);
    Ventana2.pack();
    Ventana2.setVisible(true);
    
    
    
    }
    //metodo para guardar la informacionde los usuarios
     public void EscribirArchivo(String id_depaN,String id_regisN,String NombreN,String ApellidoN,String TelefonoN,String FechaNacimientoN,String FechaRegistroN,String CorreoN) throws IOException  {
     //se va a contatenear los datos a la tabla
     
         String CadenaDatos="";//datos a almacenar en una sola fila de datos
         CadenaDatos=id_depaN+","+id_regisN+","+NombreN+","+ApellidoN+","+TelefonoN+","+FechaNacimientoN+","+FechaRegistroN+","+CorreoN;
         //se procede a guardar los datos 
         
         FileWriter fichero;
         PrintWriter pw;
         try
         {
             fichero= new FileWriter("Datos.txt",true);//direccion de donde guardaran los datos
             pw = new PrintWriter (fichero);//conexion
             pw.println(CadenaDatos);
             pw.close();//cerrar el archivo
             fichero.close();
             JOptionPane.showConfirmDialog(null,"DatosIngresado correctamente","Infor",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);//mensaje 
             
         }catch(Exception e){
         
         JOptionPane.showConfirmDialog(null,"Ha ocurrido un error","Infor",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
         
         }
         
         
         
         
     
     
     }     
    
   
    
}
