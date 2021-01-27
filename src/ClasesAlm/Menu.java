package ClasesAlm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;

public class Menu {
    /*clase para mensajes por pantalla*/
    public class MessageDialog {
           public MessageDialog(){
               
           }
           public MessageDialog(int i,String resp){
               switch(i){
                   case 1:
                       JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
                   break;
                   case 2:
                       JOptionPane.showMessageDialog(null,resp, "Error al ingresar datos", JOptionPane.WARNING_MESSAGE);
                   break;
                   case 3:
                       JOptionPane.showMessageDialog(null,"El articulo ya esta Registrado", "Error al ingresar datos", JOptionPane.WARNING_MESSAGE);
                   break;
                   case 4:
                       JOptionPane.showMessageDialog(null,"El articulo no esta registrado", "Error al ingresar datos", JOptionPane.WARNING_MESSAGE);
                   break;
                   case 5:
                       JOptionPane.showMessageDialog(null,"No se cuentan con la existencia de la compra ", "Error de compra", JOptionPane.WARNING_MESSAGE);
                   break;
               }
           }
    }
    /*clase para tener fondo de imagen*/
    class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("img.jpg")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
    /*objeto de interfaz*/
    private JFrame frame;/*Fame menu principal*/
    private JFrame frameDos;/*2Frame se genera al hace click en option menu*/
   
    private JTextField textField;/*entra de text generica*/
    
    /*dimencion de la pantalla*/
    private Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize(); 
    
    /*entrada de text para atributo de los obj articulos*/
    private JTextField nombre;
    private JTextField codi;
    private JTextField esta;
    private JTextField canti;
    private JTextField cost;
    private JTextField preg;
    private JComboBox combo;
    private FondoPanel fondo = new FondoPanel();
    
    /*clase de la parte logica del programa*/
    private Almacen agro=new Almacen();

   /*main del programa*/
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu window = new Menu();                    
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*contructo de menu*/
    public Menu() {
        initialize();
    }
    public void limpiarTxt(){
        nombre.setText("");
        codi.setText("");
        esta.setText("");
        canti.setText("");
        cost.setText("");
        preg.setText("");

    }
    public void limpiarVenta(){
        nombre.setText("");
        codi.setText("");
        canti.setText("");
    }

    /*muetra por pantalla menu*/
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Agro ");
        frame.setContentPane(fondo);
        
        	       
        frame.setBounds(pantalla.width/4, pantalla.height/4, 650, 450);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 600, 600);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setOpaque(false);
        JButton btnAgre = new JButton("Agregar");
        btnAgre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar();
            }
        });
        btnAgre.setBounds(60, 90, 150, 30);
        panel.add(btnAgre);

        JButton btnModificar = new JButton("Comprar");
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprar();
            }
        });
        btnModificar.setBounds(60, 140, 150, 30);
        panel.add(btnModificar);
        
        JButton btnVender = new JButton("Vender");
        btnVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vender();
            }
        });
        btnVender.setBounds(60, 190, 150, 30);
        panel.add(btnVender);
        
        JButton btnReporte = new JButton("Reporte");
        btnReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reporte();
            }
        });
        btnReporte.setBounds(60, 240, 150, 30);
        panel.add(btnReporte);
        
        JButton btnReporteArticulo = new JButton("Reposter Articulo");
        btnReporteArticulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 reporteA();
            }
        });
        btnReporteArticulo.setBounds(60, 290, 150, 30);
        panel.add(btnReporteArticulo);

        JLabel titilo = new JLabel("Centro Agropecuario");
        titilo.setBounds(70, 10, 414, 60);
        titilo.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(titilo);
        
    }
    private void agregar() {

        frameDos = new JFrame();
        
        frameDos.setTitle("Ingrese Articulo");
        
        frameDos.setTitle("Ingrese Producto");
        frameDos.setBounds(450, 200, 500, 350);
        frameDos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDos.setContentPane(new FondoPanel());/*fondo de pantalla*/
        frameDos.getContentPane().setLayout(null);
        frameDos.setResizable(false);//evita cambiar de tamaño
        
        /*evita que se cierre*/
        frameDos.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frameDos.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(true);
                frameDos.dispose();
            }
        });
        //
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 1);
        frameDos.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setOpaque(false);//panel trasparente
        JLabel lblNewLabel=new JLabel();
        lblNewLabel = new JLabel("Introduce los datos del articulo: ");
        
        lblNewLabel.setForeground(Color.white);
        lblNewLabel.setBounds(20, 20, 204, 14);
        frameDos.getContentPane().add(lblNewLabel);
       
        /*1-nombre--------*/
        JLabel name = new JLabel("Nombre: ");
        name.setForeground(Color.white);
        name.setBounds(40, 40, 100, 14);
        frameDos.getContentPane().add(name);
        
        nombre = new JTextField();
        nombre.setBounds(130, 40, 100, 20);
        frameDos.getContentPane().add(nombre);
        nombre.setColumns(10);
        
        /*2-codigo--------*/
        JLabel codigo = new JLabel("Codigo: ");
        codigo.setForeground(Color.white);
        codigo.setBounds(40, 70, 100, 14);
        frameDos.getContentPane().add(codigo);
        
        codi = new JTextField();
        codi.setBounds(130, 70, 100, 20);
        frameDos.getContentPane().add(codi);
        codi.setColumns(10);
        
        /*3-estado--------*/
        JLabel estado = new JLabel("Estado: ");
        estado.setForeground(Color.white);
        estado.setBounds(40, 100, 100, 14);
        frameDos.getContentPane().add(estado);
        
        esta = new JTextField();
        esta.setBounds(130, 100, 100, 20);
        frameDos.getContentPane().add(esta);
        esta.setColumns(10);
        
        /*4-cantidad--------*/
        JLabel cantidad = new JLabel("Cantidad: ");
        cantidad.setForeground(Color.white);
        cantidad.setBounds(40, 130, 100, 14);
        frameDos.getContentPane().add(cantidad);
        
        canti = new JTextField();
        canti.setBounds(130, 130, 100, 20);
        frameDos.getContentPane().add(canti);
        canti.setColumns(10);
        
        /*5-costo--------*/
        JLabel costo = new JLabel("Costo: ");
        costo.setForeground(Color.white);
        costo.setBounds(40, 160, 100, 14);
        frameDos.getContentPane().add(costo);
        
        cost = new JTextField();
        cost.setBounds(130, 160, 100, 20);
        frameDos.getContentPane().add(cost);
        cost.setColumns(10);  
        
        /*6-tipo de articulo*/
        JTextField tf = new JTextField(20);
        combo = new JComboBox();
	combo.addItem("Animal");
	combo.addItem("Vegetal");
	combo.addItem("Quimico");
        tf.setText("TipoAnimal:");
        combo.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
                String mensaje="";
                if(combo.getSelectedItem().equals("Animal")){
                    mensaje="TipoAnimal:";
                }
                if(combo.getSelectedItem().equals("Vegetal")){
                    mensaje="Kilaje:";
                }
                if(combo.getSelectedItem().equals("Quimico")){
                    mensaje="formulaQuimica:";
                }
		tf.setText(mensaje);
	    }
        });
        JLabel tipo = new JLabel("tipo articulo: ");
        tipo.setForeground(Color.white);
        tipo.setBounds(40, 190, 100, 14);
        frameDos.getContentPane().add(tipo);
        combo.setBounds(130, 190, 100, 20); 
        frameDos.getContentPane().add(combo);
        
        /*pregunta por tipo de articulo */
        tf.setEditable(false);
        tf.setBounds(20, 220, 100, 20);
        frameDos.getContentPane().add(tf);
        
        preg = new JTextField();
        preg.setBounds(130, 220, 100, 20);
        frameDos.getContentPane().add(preg);
        preg.setColumns(10);
        
        /*boton registro*/
        JButton btnNewButton = new JButton("Registrar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                
                float auxCost=0.0f;
                int auxCant=0;
                ArrayList<Integer> err = new ArrayList();
                
                /*validar si existe los datos y si estan bien*/                
                if(nombre.getText().length()==0) err.add(1);
                if(codi.getText().length()==0) err.add(2);
                try{
                    auxCost=Float.parseFloat(cost.getText());
                }catch(NumberFormatException ex){
                    /*System.out.println("Error al ingresar el costo");*/ err.add(3);
                }
                if(esta.getText().length()==0) err.add(4);                
                try{
                    auxCant=Integer.parseInt(canti.getText());
                }catch(NumberFormatException ex){
                    /*System.out.println("Error al ingresar la cantidad");*/ err.add(5);
                }
                if(preg.getText().length()==0) err.add(6); 
                
                String res="";
                if(err.size()>0){
                    if(err.size()==6){
                        res="Registro no valido";
                    }else{
                        for(Integer i:err){
                            switch(i){
                                case 1:
                                    res+="-Campo nombre vasio-";
                                break;
                                case 2:
                                    res+="-Campo codigo vasio-";
                                break;
                                case 3:
                                    res+="-Campo costo invalido-";
                                break;
                                case 4:
                                    res+="-Campo estado vasio-";
                                break;
                                case 5:
                                    res+="-Campo cantida invalida-";
                                break;
                                case 6:
                                    res+="-Campo pregunta especial vasio-";
                                break;
                            }
                        }
                    }
                    /*respuesta negativa*/
                    MessageDialog a =new MessageDialog(2,res);
                }else{
                    /*cargo el articulo por defecto animal*/
                    Articulo articulo=new Animal();
if(combo.getSelectedItem().equals("Animal"))  articulo=new Animal(nombre.getText(),
        codi.getText(),auxCost,esta.getText(),auxCant,preg.getText());

if(combo.getSelectedItem().equals("Vegetal")) articulo=new Vegetal(nombre.getText(),
        codi.getText(),auxCost,esta.getText(),auxCant,preg.getText());

if(combo.getSelectedItem().equals("Quimico")) articulo=new Quimico(nombre.getText(),
        codi.getText(),auxCost,esta.getText(),auxCant,preg.getText());
    
     /*Se revisa si ya se tiene el producto*/
    if(agro.existencia(articulo)==0){
         /*Agrego articulo a almacen*/
         agro.agregarArticulo(articulo);
                    
        /*respuesta de usuario postiva*/
         MessageDialog a =new MessageDialog(1,res);
    }else{
        /*respuesta de usuario negativa*/
        MessageDialog a =new MessageDialog(3,res);
    }

                }//condicion si se cargo bien los datos

                frameDos.dispose();
            }//actionfor
            
        });//fin evento
        btnNewButton.setBounds(380, 280, 89, 23);
        frameDos.getContentPane().add(btnNewButton);
        
        JButton volverM = new JButton("Volver menu");
        volverM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frameDos.dispose();
            }
        });
        volverM.setBounds(380, 40, 89, 23);
        frameDos.getContentPane().add(volverM);
        
        JButton Limpiar = new JButton("Limpiar");
        Limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarTxt();
            }
        });
        Limpiar.setBounds(20, 280, 89, 23);
        frameDos.getContentPane().add(Limpiar);
        
        frameDos.setVisible(true);
        frame.setVisible(false);
    }
        private void vender() {
        frameDos = new JFrame();
        frameDos.setTitle("Vender Articulo");
        frameDos.setBounds(450, 200, 450, 300);
        frameDos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDos.setContentPane(new FondoPanel());
        frameDos.getContentPane().setLayout(null);
        frameDos.setResizable(false);
        
        frameDos.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frameDos.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(true);
                frameDos.dispose();
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 1);
        frameDos.getContentPane().add(panel);
        panel.setLayout(null);      
        panel.setOpaque(false);

        JLabel lblNewLabel = new JLabel("Introduce los datos de la venta: ");
        lblNewLabel.setForeground(Color.white);
        lblNewLabel.setBounds(40, 20, 204, 14);
        frameDos.getContentPane().add(lblNewLabel);
     
        /*2-codigo--------*/
        JLabel codigo = new JLabel("Codigo: ");
        codigo.setForeground(Color.white);
        codigo.setBounds(40, 40, 100, 14);
        frameDos.getContentPane().add(codigo);
        
        codi = new JTextField();
        codi.setBounds(130, 40, 100, 20);
        frameDos.getContentPane().add(codi);
        codi.setColumns(10);
        
        /*3-cantidad--------*/
        JLabel cantidad = new JLabel("Cantidad: ");
        cantidad.setForeground(Color.white);
        cantidad.setBounds(40, 70, 100, 14);
        frameDos.getContentPane().add(cantidad);
        
        canti = new JTextField();
        canti.setBounds(130, 70, 100, 20);
        frameDos.getContentPane().add(canti);
        canti.setColumns(10);

        JButton comprar = new JButton("Vender");
        comprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                
                float auxCost=0.0f;
                int auxCant=0;
                ArrayList<Integer> err = new ArrayList();
                
                /*validar si existe los datos y si estan bien*/                
                if(codi.getText().length()==0) err.add(1);               
                try{
                    auxCant=Integer.parseInt(canti.getText());
                }catch(NumberFormatException ex){
                   /* System.out.println("Error al ingresar la cantidad");*/ err.add(1);
                }
                
                String res="";
                if(err.size()>0){
                    if(err.size()==3){
                        res="Venta no valida";
                    }else{
                        for(Integer i:err){
                            switch(i){
                                case 1:
                                    res+="-Campo codigo vasio-";
                                break;
                                case 2:
                                    res+="-Campo cantida invalida-";
                                break;
                            }
                        }
                    }
                    /*respuesta negativa*/
                    MessageDialog a =new MessageDialog(2,res);
                }else{
                    /*cargo los datos del articulo*/
                    Articulo articulo=new Animal(nombre.getText(),codi.getText(),0,"",auxCant,"");
                        /*esta registrado?*/
                        /*Se revisa si ya se tiene el producto y si hay existencia*/
                        int resp=agro.existencia(articulo);
                        if(resp!=0&&resp!=2){
                            
                            /*copio los datos del articulo en almacen*/
                            Articulo art=agro.retornarProducto(codi.getText());
                            /*estado incila*/
                            Articulo venta=new Animal();
                            if(art instanceof Animal){
                                venta = new Animal("","",0,"",0,((Animal) art).getTipo());
                            }
                            if(art instanceof Quimico){
                                venta = new Quimico("","",0,"",0,((Quimico) art).getFormulaQuimica());
                            }
                            if(art instanceof Vegetal){
                                venta = new Vegetal("","",0,"",0,((Vegetal) art).getKilaje());
                            }
                            /*registra todos los datos*/
                            venta.setNombre(art.getNombre());
                            venta.setCodigo(codi.getText());
                            /*cargo el costo de la compra*/
                            venta.setCosto(auxCant*art.getCosto());
                            venta.setEstado(art.getEstado());
                            /*guardo la cantidad carticulos vendidos*/
                            venta.setCantidadArticulo(auxCant);
                            
                            /*Agrego articulo a registro venta*/
                            agro.venta(venta);
                    
                            /*respuesta de usuario postiva*/
                            MessageDialog a =new MessageDialog(1,res);
                        }else{
                            /*respuesta de usuario negativa*/
                            if(resp==0){
                                MessageDialog a =new MessageDialog(4,res);
                            }else{
                                MessageDialog a =new MessageDialog(5,res);
                            }
                            
                        }
}//condicion si se cargo bien los datos

                frameDos.dispose();
            }
        });
        comprar.setBounds(330, 220, 89, 23);
        frameDos.getContentPane().add(comprar);
        
        JButton limpiar = new JButton("Limpiar");
        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarVenta();
            }
        });
        limpiar.setBounds(40, 220, 89, 23);   
        frameDos.getContentPane().add(limpiar);
        
        JButton volver = new JButton("Volver Menu");
        volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               frame.setVisible(true);
                frameDos.dispose();
            }//actionfor
        });
        volver.setBounds(330, 40, 89, 23);        
        frameDos.getContentPane().add(volver);
        
        frameDos.setVisible(true);
        frame.setVisible(false);
    }
    private void comprar() {
        frameDos = new JFrame();
        frameDos.setTitle("Comprar Articulo");
        frameDos.setBounds(450, 200, 450, 300);
        frameDos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDos.setContentPane(new FondoPanel());
        frameDos.getContentPane().setLayout(null);
        frameDos.setResizable(false);
        
        frameDos.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frameDos.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(true);
                frameDos.dispose();
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 1);
        frameDos.getContentPane().add(panel);
        panel.setLayout(null);      
        panel.setOpaque(false);

        JLabel lblNewLabel = new JLabel("Introduce los datos de la compra: ");
        lblNewLabel.setForeground(Color.white);
        lblNewLabel.setBounds(40, 20, 204, 14);
        frameDos.getContentPane().add(lblNewLabel);
       
        /*1-codigo--------*/
        JLabel codigo = new JLabel("Codigo: ");
        codigo.setForeground(Color.white);
        codigo.setBounds(40, 40, 100, 14);
        frameDos.getContentPane().add(codigo);
        
        codi = new JTextField();
        codi.setBounds(130, 40, 100, 20);
        frameDos.getContentPane().add(codi);
        codi.setColumns(10);
        
        /*2-cantidad--------*/
        JLabel cantidad = new JLabel("Cantidad: ");
        cantidad.setForeground(Color.white);
        cantidad.setBounds(40, 70, 100, 14);
        frameDos.getContentPane().add(cantidad);
        
        canti = new JTextField();
        canti.setBounds(130, 70, 100, 20);
        frameDos.getContentPane().add(canti);
        canti.setColumns(10);
        
        /*3-costo--------*/
        JLabel costo = new JLabel("Costo: ");
        costo.setForeground(Color.white);
        costo.setBounds(40, 100, 100, 14);
        frameDos.getContentPane().add(costo);
        
        cost = new JTextField();
        cost.setBounds(130, 100, 100, 20);
        frameDos.getContentPane().add(cost);
        cost.setColumns(10); 
        
        JButton comprar = new JButton("Registrar");
        comprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                
                float auxCost=0.0f;
                int auxCant=0;
                ArrayList<Integer> err = new ArrayList();
                
                /*validar si existe los datos y si estan bien*/                  
                if(codi.getText().length()==0) err.add(1);               
                try{
                    auxCant=Integer.parseInt(canti.getText());
                }catch(NumberFormatException ex){
                   /* System.out.println("Error al ingresar la cantidad");*/ err.add(2);
                }
                try{
                    auxCost=Float.parseFloat(cost.getText());
                }catch(NumberFormatException ex){
                   /* System.out.println("Error al ingresar la cantidad");*/ err.add(3);
                }
                
                String res="";
                if(err.size()>0){
                    if(err.size()==3){
                        res="Venta no valida";
                    }else{
                        for(Integer i:err){
                            switch(i){
                                case 1:
                                    res+="-Campo codigo vasio-";
                                break;
                                case 2:
                                    res+="-Campo cantida invalida-";
                                break;
                                case 3:
                                    res+="-Campo costo invalido-";
                                break;
                            }
                        }
                    }
                    /*respuesta negativa*/
                    MessageDialog a =new MessageDialog(2,res);
                }else{
                    /*cargo los datos del articulo*/
                    Articulo articulo=new Animal("",codi.getText(),0,"",auxCant,"");
                        /*esta registrado?*/
                        /*Se revisa si ya se tiene el producto*/
                        int resp=agro.existencia(articulo);
                        if(resp!=0){
                            
                            /*copio los datos del articulo en almacen*/
                            Articulo art=agro.retornarProducto(codi.getText());
                            /*estado incila*/
                            Articulo compra=new Animal();
                            if(art instanceof Animal){
                                compra = new Animal("","",0,"",0,((Animal) art).getTipo());
                            }
                            if(art instanceof Quimico){
                                compra = new Quimico("","",0,"",0,((Quimico) art).getFormulaQuimica());
                            }
                            if(art instanceof Vegetal){
                                compra = new Vegetal("","",0,"",0,((Vegetal) art).getKilaje());
                            }
                            /*registra todos los datos*/
                            compra.setNombre(art.getNombre());
                            compra.setCodigo(codi.getText());
                            /*cargo el costo de la compra*/
                            compra.setCosto(auxCost);
                            compra.setEstado(art.getEstado());
                            /*guardo la cantidad carticulos vendidos*/
                            compra.setCantidadArticulo(auxCant);
                            
                            /*Agrego articulo a registro venta*/
                            agro.compra(compra);
                    
                            /*respuesta de usuario postiva*/
                            MessageDialog a =new MessageDialog(1,res);
                        }else{
                            /*respuesta de usuario negativa*/
                            if(resp==0){
                                MessageDialog a =new MessageDialog(4,res);
                            }else{
                                MessageDialog a =new MessageDialog(5,res);
                            }
                            
                        }
}//condicion si se cargo bien los datos

                frameDos.dispose();
            }
        });
        comprar.setBounds(330, 220, 89, 23);
        frameDos.getContentPane().add(comprar);
        
        JButton limpiar = new JButton("Limpiar");
        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarVenta();
            }
        });
        limpiar.setBounds(40, 220, 89, 23);   
        frameDos.getContentPane().add(limpiar);
        
        JButton volver = new JButton("Volver Menu");
        volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               frame.setVisible(true);
                frameDos.dispose();
            }//actionfor
        });
        volver.setBounds(330, 40, 89, 23);        
        frameDos.getContentPane().add(volver);
        
        frameDos.setVisible(true);
        frame.setVisible(false);
    }
    private void reporte() {
        frameDos = new JFrame();
        frameDos.setTitle("Reporte Inventario");
        frameDos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDos.getContentPane().setLayout(null);
        frameDos.setResizable(false);
        
        frameDos.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frameDos.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(true);
                frameDos.dispose();
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 1);
        frameDos.getContentPane().add(panel);
        panel.setLayout(null);
        
        frameDos.setContentPane(new FondoPanel());
        panel.setOpaque(false);
        
        JLabel lblNewLabel = new JLabel("Reporte de Articulos del Almacen ");
        lblNewLabel.setBounds(48, 68, 204, 14);
        frameDos.getContentPane().add(lblNewLabel);
       
       /*genero tabla con los datos del registro*/
        frameDos.getContentPane().add( new Tabla(agro.getListaA()),BorderLayout.CENTER );
        
        
        frameDos.setBounds((pantalla.width-600)/2, (pantalla.height-600)/2, 600, 600);
        
        JButton volverM = new JButton("Volver menu");
        volverM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frameDos.dispose();
            }
        });
        volverM.setBounds(0,600, 89, 23);
        frameDos.getContentPane().add(volverM);
         
        frameDos.setVisible(true);
        frame.setVisible(false);
    }        
    private void reporteA() {
        frameDos = new JFrame();
        frameDos.setTitle("Reporte Articulo");
        frameDos.setBounds((pantalla.width-600)/2, (pantalla.height-600)/2, 600, 600);
        frameDos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDos.setContentPane(new FondoPanel());
        frameDos.getContentPane().setLayout(null);
        frameDos.setResizable(false);
        
        frameDos.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frameDos.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(true);
                frameDos.dispose();
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 1);
        frameDos.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setOpaque(false);
        
        JLabel lblNewLabel = new JLabel("Introduce el codigo del articulo: ");
        lblNewLabel.setBounds(20, 20, 204, 14);
        frameDos.getContentPane().add(lblNewLabel);

        codi= new JTextField();
        codi.setBounds(200, 20, 114, 20);
        frameDos.getContentPane().add(codi);
        codi.setColumns(10);

        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                int err=0;
                
                /*validar si existe los datos y si estan bien*/                
                if(codi.getText().length()==0) err=1;

                String res="";
                if(err!=0){
                    res="-Campo codigo vasio-" ;
                }else{
                    /*cargo los datos del articulo*/
                    Articulo articulo=new Animal("",codi.getText(),0,"",0,"");
                        
                        /*esta registrado?*/
                        /*Se revisa si ya se tiene el producto y si hay existencia*/
                        int resp=agro.existencia(articulo);
                        if(resp!=0){
                            
                            /*copio los datos del articulo en almacen*/
                            ArrayList<ArrayList<Articulo>> rep=agro.reporteArticulo(articulo);
                            frameDos.setVisible(false); 
                            reporteAD(rep);
                            
                                            
                        }else{
                            /*respuesta de usuario negativa*/
                            if(resp==0){
                                MessageDialog a =new MessageDialog(4,res);
                            }
                            
                        }
                }//condicion si se cargo bien los datos

                
            }
        });
        btnNewButton.setBounds(320, 20, 80, 20);
        frameDos.getContentPane().add(btnNewButton);
        
        JButton volverM = new JButton("Volver menu");
        volverM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frameDos.dispose();
            }
        });
        volverM.setBounds(410,20, 80, 20);
        frameDos.getContentPane().add(volverM);
        
        frameDos.setVisible(true);
        frame.setVisible(false);
    }
    private void reporteAD(ArrayList<ArrayList<Articulo>> rep) {
       frameDos = new JFrame();
        frameDos.setTitle("Historial de Articulo");
        frameDos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        frameDos.getContentPane().setLayout(null);
        frameDos.setResizable(false);
        
        frameDos.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frameDos.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(true);
                frameDos.dispose();
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 1);
        frameDos.getContentPane().add(panel);
        panel.setLayout(null);
        
        frameDos.setContentPane(new FondoPanel());
        panel.setOpaque(false);
        

          
        JLabel data = new JLabel("Reporte Actual de Articulo: ");
        frameDos.getContentPane().add(data);
        frameDos.getContentPane().add( new Tabla(rep.get(0)),BorderLayout.CENTER );
        
        JLabel data1 = new JLabel("Reporte Compra del Articulo: ");
        frameDos.getContentPane().add(data1);
        frameDos.getContentPane().add( new Tabla(rep.get(1)),BorderLayout.CENTER );
        
        JLabel data2 = new JLabel("Reporte Ventas del Articulo: ");
        frameDos.getContentPane().add(data2);      
        frameDos.getContentPane().add( new Tabla(rep.get(2)),BorderLayout.CENTER );
       frameDos.setBounds((pantalla.width-600)/2, (pantalla.height-600)/2, 600, 600);
                 
        JButton volverM = new JButton("Volver menu");
        volverM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frameDos.dispose();
            }
        });
        frameDos.getContentPane().add(volverM);
              
        frameDos.setVisible(true);
        frame.setVisible(false);
    }

}