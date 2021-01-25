package ClasesAlm;
/*clase padre de articulo quimico,vegetal y animal */
/*para poder ser polimorfica requiere ser pura abstract*/
/*para poder serializar los objetos requiere la interdas java.io.Seria..*/
public abstract class  Articulo implements java.io.Serializable{
    
    /*atributos*/
    private String nombre;
    private String codigo;
    private float costo;
    private String estado;
    private int cantidadArticulo;
    
    /*metodos*/
    public Articulo(){
        this.nombre="";
        this.codigo="";
        this.costo=0.0f;
        this.estado="";
        this.cantidadArticulo=0;
    }
    public Articulo(String nombre,String codigo,float costo,String estado,int cantidadArticulo){
        this.nombre=nombre;
        this.codigo=codigo;
        this.costo=costo;
        this.estado=estado;
        this.cantidadArticulo=cantidadArticulo;
    }
    
    public abstract void operar();/*metodo puro abstrato */

    /*geter y seter*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }
}