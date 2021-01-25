
package ClasesAlm;
/*clase hija de articulo y implemeta Seria..*/
public class Animal extends Articulo implements java.io.Serializable {
    /*atributos y metodos*/
    private String tipo;
    
    public Animal() {
        this.tipo="";
    }

    public Animal(String nombre, String codigo, float costo, String estado,int cantidadArticulo,String tipo) {
        /*herencia de la clase padre*/
        super(nombre, codigo, costo, estado,cantidadArticulo);
        this.tipo=tipo;
    }
    
    /*metodo abstrato heredado*/
    public  void operar(){
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}