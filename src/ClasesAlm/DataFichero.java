
package ClasesAlm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataFichero {
    /*ruta del archivo*/
    private String [] ruta={"registroA.txt","registroC.txt","registroV.txt"};
    /*estado si existen .txt*/
    private int start=0;
    
    public DataFichero(){
        start=0;
        try {
            /*registro de articulo*/
            File registroA = new File("archivos/registroA.txt");
            String ruta = registroA.getAbsolutePath();      
            File file = new File(ruta);
            
            /*registro de compra*/
            File registroC = new File("archivos/registroC.txt");
            String ruta1 = registroC.getAbsolutePath();      
            File file1 = new File(ruta1); 
            
            /*registro de ventas*/
            File registroV = new File("archivos/registroV.txt");
            String ruta2 = registroV.getAbsolutePath();      
            File file2 = new File(ruta2); 
            
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile(); start=1;
            }
            if (!file1.exists()) {
                file1.createNewFile(); start=1;
            }
            if (!file2.exists()) {
                file2.createNewFile(); start=1;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*guarda la lista de articulo en el .txt dado por pos */
    public void updateData(ArrayList<Articulo> lista,int pos){
        try {
            if(pos>ruta.length){
                System.out.println("Ruta fuera de rango update");
                return ;
            }
            
            File archivo = new File("archivos/"+ruta[pos]);
            String rutaA = archivo.getAbsolutePath();
                   
            try{
                FileOutputStream fs = new FileOutputStream(rutaA);
                ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos 
                os.writeObject(lista);//El método writeObject() serializa el objeto y lo escribe en el archivo
                os.close();//Hay que cerrar siempre el archivo
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Articulo> selectData(int pos){
        ArrayList<Articulo> lista = new ArrayList<Articulo>();
        try {
            if(pos>ruta.length){
                System.out.println("Ruta fuera de rango Select");
                return null;
            }

            File archivo = new File("archivos/"+ruta[pos]);
            String rutaA = archivo.getAbsolutePath();
            
            try{
                FileInputStream fis = new FileInputStream(rutaA);
                ObjectInputStream ois = new ObjectInputStream(fis);
                lista = (ArrayList<Articulo>) ois.readObject();//El método readObject() recupera el objeto
                ois.close(); fis.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                 //e.printStackTrace();
                 System.out.println("no hay datos en "+ruta[pos]);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String[] getRuta() {
        return ruta;
    }

    public void setRuta(String[] ruta) {
        this.ruta = ruta;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
    
    
}