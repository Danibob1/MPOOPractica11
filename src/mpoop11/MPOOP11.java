package mpoop11;

import java.util.logging.Level;//Importa el paquete por defecto la excpepcion
import java.util.logging.Logger;//Importa el paquete por defecto la excpepcion
import java.io.IOException; //Importa el paquete por defecto la excpepcion
import java.io.FileNotFoundException;//Importa el paquete por defecto la excepcion

import java.io.File; //Importa el paquete  File

import java.io.FileInputStream; //Importa el paquete FileInputStream
import java.io.FileOutputStream; //Importa el paquete FileOutputStream

import java.io.BufferedReader;//Importa el paquete BufferedReader
import java.io.BufferedWriter;//Importa el paquete BufferedWriter
import java.io.FileReader; //Importa el paquete FileReader
import java.io.InputStreamReader; //Importa el paquete InputStreamReadee
import java.io.FileWriter;//Importa el paquete FileWriter
import java.io.PrintWriter;//Importa el paquete PrintWriter

import java.util.StringTokenizer; //Importa el paquete StringTokenizer

import java.util.Date;//Importa el paquete Date
import java.io.ObjectInputStream; //Importa el paquete ObjectInputStream
import java.io.ObjectOutputStream;//Importa el paquete ObjectOutputStream 

/**
 *
 * @author daniel y carlos
 * @version 1.0
 */
public class MPOOP11 {

    public static void main(String[] args) {
        
        //File permite manejar carpetas y archivos
        try {//Es una excepcion IOException para todo el bloque de codigo 
            //Creacion de objeto Archivo: File nombre= intanciarlo("nombre.txt")
            File archivo= new File("archivo.txt");//Comprueba si se creo el archivo marcando false porque no esta creado
            System.out.println(archivo.exists());
            boolean seCreo= archivo.createNewFile(); //Se crea el archivo con una variable boolean intanciandolo con el objeto archivo
            //Impremimos la variable seCreo y el objeto archivo
            System.out.println(seCreo);
            System.out.println(archivo.exists());
        } catch (IOException ex) {
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
        }//Fin de la excpecion
        
        //FileOutputStre: Permite crear y escribir un flujo de bytes en un archivo de texto plano
        System.out.println("\nFileOutputSteam");
        FileOutputStream fos= null;   //Creamos el objeto fos del paquete FileOutputStream y lo instanciamos a nulo
        byte[] buffer= new byte[150];//Hacemos un arreglo de byte con nombre buffer porque recibe informacion e intanciamos con un tamaño especifico
        int nBytes; //Variable auxiliar contador para saber que numero de byte estamos
        
        try{//Es una excepcion IOException para todo el bloque de codigo 
            System.out.println("El texto a guardar al archivo");
            nBytes= System.in.read(buffer);//Flujo de entrada que leera todo lo que tenga buffer y lo almacena el tamaño en nBytes
            fos = new FileOutputStream("dos.txt"); //Utilizamos el fos instanciandolo a la creacion de un nuevo archivo
            fos.write(buffer,0,nBytes);//Esta la sintaxis para escribir y guardar al archivo (Informacion, Inicio, CantidadDeDatos)
        }catch(IOException ex){//Atapar la excepcion IOException
            System.out.println("Error: "+ex.toString());
        }finally {//Cualquier cosa que ocurra el bloque de codigo de abajo lo ejecuta
            if (fos!= null) {// Si fos es diferente a nulo, intentara cerrar el archivo 
                try {//Es una excepcion IOException para todo el bloque de codigo 
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
                }//Fin de la excpecion
            }
        }//Fin de la excpecion
        
        System.out.println("\n FileInputStream");
        FileInputStream fis=null;//Creamos el objeto fis del paquete FileInputStream y lo instanciamos a nulo
        String texto; //Variable global
        try {//Es una excepcion IOException y FileNotFoundException para todo el bloque de codigo 
            fis= new FileInputStream("dos.txt");//fis esta intanciando al archivo dos.txt
            nBytes=fis.read(buffer, 0, 150);//Lee el bufer, empieza en 0, el tamaño de bytes
            texto= new String(buffer,0,nBytes);//Objeto String que lee el buffer, 0, nBytes
            System.out.println(texto);//Imprime el texto del archivo 
            }catch (FileNotFoundException ex) {
               Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
            }//Fin de la excpecion
        
        System.out.println("\nFileWritter");
        BufferedReader br;//Creamos un objeto llamado br
        br= new BufferedReader(new InputStreamReader(System.in));  //el objeto lo instanceamos a lo que va a leer
        System.out.println("Escribir texto a guardar");
        try {//Es una excepcion IOException 
            texto= br.readLine(); //La variable global esta apuntado a todo lo que lea el objeto br
            FileWriter fw= new FileWriter("fw.txt");//Creamos un nuevo archivo
            BufferedWriter bw =new BufferedWriter(fw); //Creamos un buffer para que guarde todo la informacion del nuevo archivo
            PrintWriter salida= new PrintWriter(bw);//Creamos un objeto salidad para PrintWriter
            salida.println(texto);//Imprime el texto
            salida.close();//Cierra el buffer
        } catch (IOException ex) {
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
        }//Fin de la excepcion
        
        System.out.println("\nFileReader");
        try {
            FileReader fr = new FileReader("fw.txt"); //Creamos un objeto fr
            br= new BufferedReader(fr);// El objeto del buffer esta intanciado al anterior objeto
            System.out.println("El texto contenido es: ");
            String linea= br.readLine(); //La variable String es intanciado al objeto anterior con su metodo propi
            while(linea!= null){//Se recorre el todos los caracteres
                System.out.println(linea);
                linea= br.readLine();
            }
            br.close();// Se cierra el archivo
        } catch (FileNotFoundException ex) { //Hacen excepciones
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
        }//Fin de la excepcion
        
        //Escribiendo por texto y leyendo en terminal con buffer
        try{
            texto =" "; //Variable String global
            br= new BufferedReader(new InputStreamReader(System.in)); //El objeto br esta instanciado a las clases de lectura   
            System.out.println(" \n Escribir el texto deseado");
            texto = br.readLine();//Lee los caracteres de texto
            System.out.println("\nEl texto escrito fue: "+texto);
        }catch(IOException ex){ //Hace excepcion
            System.out.println("Error al leer carecters: \n"+ex);
        }//Fin de la excepcion
        
        //Tokenizer
          try{
             texto= " ";//Variable String global
            br= new BufferedReader(new InputStreamReader(System.in));//El objeto br esta inciando a las clases de lectura
            System.out.println("\n Escribir texto");
            texto= br.readLine();//Lee todo lo que tenga el objeto br
            
            System.out.println("\n El texto separado por espacios es: ");
            StringTokenizer st= new StringTokenizer(texto); //se declara un objeto st intanciado a texto
            while(st.hasMoreTokens()){//Separa por espacios 
                System.out.println(st.nextToken());
            }
        }catch(IOException e){//Hace la excepcion   
            System.out.println("\n Error al leer de teclado: ");
        }//Fin de la excepcion
          
          Date d= new Date(); //Se crea un objeto de la clase fecha
          System.out.println("\n"+d); //Imprime fecha
          try{
            FileOutputStream f= new FileOutputStream ("date.txt");//Se crea un archivo
            ObjectOutputStream s= new ObjectOutputStream (f);//Se crea un objeto instanciado al objeto anterior
            s.writeObject(d); //Escribe la informacion de fecha
            s.close(); //Cierra el archivo
          }catch(IOException ex){//Hace la excepcion
             ex.printStackTrace();
          }//Fin de la excepcion
          
          d=null; //El objeto se instancia a nulo
          
          System.out.println("\nObjeto desrealizar\n");
          try{
            FileInputStream f= new FileInputStream ("date.txt");//Se declara el objeto
            ObjectInputStream s= new ObjectInputStream (f); //Se crea un objeto instanciado al objeto anterior
            d= (Date) s.readObject();// Se guarda el dato de fecha
            s.close();//Se cierra el archivo
          }catch(IOException ex){//Hacen las excepciones
              System.out.println("Error al leer carecters: \n"+ex);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
        }//Fin de la excepcion
          System.out.println("\n Date "+d);//Se imprime Fecha
          
    }
}
