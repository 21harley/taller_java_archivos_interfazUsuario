
package ClasesAlm;

import java.util.ArrayList;

public class Almacen {
    private ArrayList<Articulo> listaA = new ArrayList<Articulo>();
    private ArrayList<Articulo> listaC = new ArrayList<Articulo>();
    private ArrayList<Articulo> listaV = new ArrayList<Articulo>();
    private DataFichero registro;
    
    public Almacen(){
        registro=new DataFichero();
        if(registro.getStart()!=1){
            listaA=registro.selectData(0);
            listaC=registro.selectData(1);
            listaV=registro.selectData(2);          
        }
    }
    public void agregarArticulo(Articulo a){
        int res=0;
        for(Articulo b:listaA){
            if(a.getCodigo().equals(b.getCodigo())){
                res=1;
            }
        }
        if(res==0){
            listaA.add(a); registro.updateData(listaA, 0);
        }else{
            //System.out.println("Articulo ya fue registrado");
        }
        
    }
    
    public void compra(Articulo a){
                
            int res=0;
            for (Articulo b : listaA) {
                if(a.getCodigo().equals(b.getCodigo())){
                    b.setCantidadArticulo(a.getCantidadArticulo()+b.getCantidadArticulo());
                    listaC.add(a); 
                    res=1;
                }
            }
            if(res==0){
                agregarArticulo(a);
            }
        
        registro.updateData(listaA, 0);
        registro.updateData(listaC, 1);
        
    }
    
    public void venta(Articulo a){

        
            for (Articulo b : listaA) {
                if(a.getCodigo().equals(b.getCodigo())){
                    if(b.getCantidadArticulo()>=a.getCantidadArticulo()){
                        b.setCantidadArticulo(b.getCantidadArticulo()-a.getCantidadArticulo());
                        listaV.add(a);
                    }
                }
            }      
        
        registro.updateData(listaA, 0);
        registro.updateData(listaV, 2);
                
    }
    public int existencia(Articulo a){
        /*
        res=respuesta
        0 no esta el producto en el almacen
        1 se encontro y exite la cantidad necesaria para una venta
        2 se encontro y no exite la cantidad necesaria para una venta
        */
        int res=0;
        for (Articulo b : listaA) {
            if(a.getCodigo().equals(b.getCodigo())){
               if(b.getCantidadArticulo()>=a.getCantidadArticulo()){
                   res=1;
            }else{
                   res=2;
            }
          }
        }
        return res;
    }
    
    public Articulo retornarProducto(String codigo){

        Articulo res=null;
            for (Articulo b : listaA) {
                if(codigo.equals(b.getCodigo())){
                    res=b;
                }
            }      
        
        return res;
                
    }    
    public int getStado(){
        return registro.getStart();
    }
    
    public  ArrayList<ArrayList<Articulo>> reporteArticulo(Articulo a){
        
        ArrayList<ArrayList<Articulo>> reporteArticulo = new ArrayList<>();
        
        ArrayList<Articulo> actual=new ArrayList();
        ArrayList<Articulo> compra=new ArrayList();
        ArrayList<Articulo> venta=new ArrayList();
        
        for(Articulo b:listaA){
            if(a.getCodigo().equals(b.getCodigo())){
                actual.add(b);
            }
        }
        reporteArticulo.add(actual);
        
        for(Articulo b:listaC){
            if(a.getCodigo().equals(b.getCodigo())){
                compra.add(b);
            }
        }
        reporteArticulo.add(compra);
        
        for(Articulo b:listaV){
            if(a.getCodigo().equals(b.getCodigo())){
                venta.add(b);
            }
        }
        reporteArticulo.add(venta);
        
        return reporteArticulo;
    }
    
    /*reporte de existencia*/
    public ArrayList<Articulo> getListaA() {
        return listaA;
    }

    public void setLista(ArrayList<Articulo> listaA) {
        this.listaA = listaA;
    }

    public ArrayList<Articulo> getListaC() {
        return listaC;
    }

    public void setListaC(ArrayList<Articulo> listaC) {
        this.listaC = listaC;
    }

    public ArrayList<Articulo> getListaV() {
        return listaV;
    }

    public void setListaV(ArrayList<Articulo> listaV) {
        this.listaV = listaV;
    }
}
