
package ClasesAlm;
/*clase hija de articulo y implemeta Seria..*/
public class Quimico extends Articulo implements java.io.Serializable{
    /*atributos y metodos*/
    private String formulaQuimica;

    public Quimico() {
        this.formulaQuimica = "";
    }

    public Quimico( String nombre, String codigo, float costo, String estado, int cantidadArticulo,String formulaQuimica) {
        /*herencia de la clase padre*/
        super(nombre, codigo, costo, estado, cantidadArticulo);
        this.formulaQuimica = formulaQuimica;
    }
    /*metodo abstrato heredado*/
    public void operar(){
        
    }
    
    public String getFormulaQuimica() {
        return formulaQuimica;
    }

    public void setFormulaQuimica(String formulaQuimica) {
        this.formulaQuimica = formulaQuimica;
    }

    
}