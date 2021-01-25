/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesAlm;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class Tabla extends JPanel {
  private JTable tabla;
  private JScrollPane panelScroll;
  // Creamos las etiquetas que sirven de título a cada una de
  // las columnas de la tabla
  private String titColumna[]={"Nombre","Codigo","Costo","Estado","Can.Articulo","tipo"};
  private String datoColumna[][];
  
  public Tabla(ArrayList<Articulo> list) {
    
    setLayout( new BorderLayout() );
    getMinimumSize();
    // Creamos las columnas y las cargamos con los datos que van a
    // aparecer en la pantalla
    CargaDatos(list);
    // Creamos una instancia del componente Swing
    tabla = new JTable( datoColumna,titColumna );
    // Aquí se configuran algunos de los parámetros que permite 
    // variar la JTable
    tabla.setShowHorizontalLines( false );
    tabla.setRowSelectionAllowed( true );
    tabla.setColumnSelectionAllowed( true );
    
    // Incorporamos la tabla a un panel que incorpora ya una barra
    // de desplazamiento, para que la visibilidad de la tabla sea
    // automática
    panelScroll = new JScrollPane( tabla );
    
    add( panelScroll, BorderLayout.CENTER );
    if(list.size()<5){
        setPreferredSize(new Dimension( 500,20*list.size()+20));
    }else{
        setPreferredSize(new Dimension( 500,20*list.size()));
    }
    
  }
 
  
  // Creamos los datos para cada uno de los elementos de la tabla
  public void CargaDatos(ArrayList<Articulo> list) {
    datoColumna = new String[list.size()][6];
    
    for( int iY=0; iY < list.size(); iY++ ) {
      for( int iX=0; iX < 6; iX++ ) {
          switch(iX+1){
              case 1:
                  datoColumna[iY][iX] =list.get(iY).getNombre();
              break;
              case 2:
                  datoColumna[iY][iX] = list.get(iY).getCodigo();
              break;
              case 3:
                  datoColumna[iY][iX] = String.valueOf(list.get(iY).getCosto());
              break;
              case 4:
                  datoColumna[iY][iX] = list.get(iY).getEstado();
              break;
              case 5:
                  datoColumna[iY][iX] = Integer.toString(list.get(iY).getCantidadArticulo());
              break;
              case 6:
                  if(list.get(iY) instanceof Animal){
                     datoColumna[iY][iX]="Animal"; 
                  }
                  if(list.get(iY) instanceof Quimico){
                     datoColumna[iY][iX]="Quimico";
                  }
                  if(list.get(iY) instanceof Vegetal){
                     datoColumna[iY][iX]="Vegetal";
                  }
              break;
          }
      }
    }
  }
}
