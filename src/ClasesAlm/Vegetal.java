
package ClasesAlm;
/*clase hija de articulo y implemeta Seria..*/
public class Vegetal extends Articulo implements java.io.Serializable{
    /*atributos y metodos*/
    private String kilaje;

    public Vegetal() {
        this.kilaje="";
    }

    public Vegetal(String nombre, String codigo, float costo, String estado, int cantidadArticulo,String kilaje) {
        /*herencia de la clase padre*/
        super(nombre, codigo, costo, estado, cantidadArticulo);
        this.kilaje=kilaje;
    }
    
    /*metodo abstrato heredado*/
    public void operar(){
        
    }
    public String getKilaje() {
        return kilaje;
    }

    public void setKilaje(String kilaje) {
        this.kilaje = kilaje;
    }
    
}