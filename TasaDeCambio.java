package Convertir;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import java.awt.event.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class TasaDeCambio extends JFrame {
	

    static JButton jb1= new JButton("OK");
    static JButton jb2= new JButton("Calcular"); 
	static JButton jb3= new JButton("Si");
	static JButton jb4= new JButton("No");
	static JButton jb5= new JButton("Cancelar");
	static JButton jb6= new JButton("Aceptar");
	static JTextField jt1=new JTextField(20); 
	static JTextField jt2=new JTextField(15); 
	static JTextField jt4=new JTextField(10); 
	static JTextField jt3=new JTextField(10);
	static JLabel jl1 = new JLabel();
	static String valorFormateado;
	static String captura;
 	static String[] variosPaisesTC = {"Seleccione T/C","Cambio Yen a Dollar", "Cambio Dollar a Yen","Cambio Dollar a Euros", "Cambio Euros a Dollar",
			"Cambio Dollar a Rublos", "Cambio Rublos a Dollar","Cambio Cordoba a Dollar","Cambio Dollar a Cordoba", "Cambio Cordoba a Euro", "Cambio Euro a Cordoba"};
	static JComboBox monedas = new JComboBox(variosPaisesTC );
	static double nOperacion;
	JFrame ventana= new JFrame();
	
	public TasaDeCambio() {
		
		
		ventana.setTitle("CAMBIO DE MONEDA");
		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
		ventana.setSize(600,300); //Dimensiones del JFrame
		ventana.getContentPane().setLayout(new GridLayout(2,0));
		 ventana.setLocationRelativeTo(null);
	 
		 JPanel panelSuperior = new JPanel();
	     panelSuperior.setBackground(Color.RED);
	     panelSuperior.setSize(600,300);
	     panelSuperior.add(monedas);
	     panelSuperior.add(jb1);
	     panelSuperior.add(jt1);
	     panelSuperior.add(jl1);  panelSuperior.add(jt3); panelSuperior.add(jb2); panelSuperior.add(jt4); panelSuperior.add(jb6);
		 jl1.setText("¿Cantidad a Covertir?");
  	     add(panelSuperior,BorderLayout.CENTER);
	     ventana.add(panelSuperior);
	     ventana.setVisible(true);  
     	     
	     jb1.addActionListener(new ActionListener() {    // evento Botón OK
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jt1.setText(String.valueOf(monedas.getSelectedItem()));
				String seleccion = (String) monedas.getSelectedItem();
				if ((seleccion) == "Cambio Yen a Dollar") {
					captura = "Cambio Yen a Dollar";
					jt1.setText("Tasa de Cambio: 0.0073");
				} else if ((seleccion) == "Cambio Dollar a Yen") {
					captura = "Cambio Dollar a Yen";
					jt1.setText("Tasa de Cambio: 136.12");
				} else if ((seleccion) == "Cambio Dollar a Euros") {
					captura = "Cambio Dollar a Euros";
					jt1.setText("Tasa de Cambio: 0.94");
				} else if ((seleccion) == "Cambio Euros a Dollar") {
					captura = "Cambio Euros a Dollar";
					jt1.setText("Tasa de Cambio: 1.07");
				} else if ((seleccion) == "Cambio Dollar a Rublos") {
					captura = "Cambio Dollar a Rublos";
					jt1.setText("Tasa de Cambio: 75.26");
				} else if ((seleccion) == "Cambio Rublos a Dollar") {
					captura = "Cambio Rublos a Dollar";
					jt1.setText("Tasa de Cambio: 0.013");
				} else if ((seleccion) == "Cambio Cordoba a Dollar") {
					captura = "Cambio Cordoba a Dollar";
					jt1.setText("Tasa de Cambio: 36.50");
				} else if ((seleccion) == "Cambio Dollar a Cordoba") {
					captura = "Cambio Dollar a Cordoba";
					jt1.setText("Tasa de Cambio: 36.00");
				} else if ((seleccion) == "Cambio Cordoba a Euro") {
					captura = "Cambio Cordoba a Euro";
					jt1.setText("Tasa de Cambio: 0.026");
				} else if ((seleccion) == "Cambio Euro a Cordoba") {
					captura = "Cambio Euro a Cordoba";
					jt1.setText("Tasa de Cambio: 38.86");
				}
			}
		});   // Fin del Evento llamado  por el Boton OK
	     
	     jb2.addMouseListener( new MouseAdapter()    /// Boton Calcular
	    			
	    			{ public void mousePressed(MouseEvent e){
	    				// la propiedad getText() regresa un objeto
	    				jt3.setText(String.valueOf(jt3.getText()));
	    				String resultado = (String) jt3.getText();
	    				if ((captura) == "Cambio Yen a Dollar") {
	    					nOperacion = Integer.parseInt(resultado)*0.0075;
	    				} else if ((captura) == "Cambio Dollar a Yen") {
	    					nOperacion = Integer.parseInt(resultado)*136.80;
	    				} else if ((captura) == "Cambio Dollar a Euros") {
	    					nOperacion = Integer.parseInt(resultado)*0.94;
	    				} else if ((captura) == "Cambio Euros a Dollar") {
	    					nOperacion = Integer.parseInt(resultado)*1.07;
	    				} else if ((captura) == "Cambio Dollar a Rublos") {
	    					nOperacion = Integer.parseInt(resultado)*75.50;
	    				} else if ((captura) == "Cambio Rublos a Dollar") {
	    					nOperacion = Integer.parseInt(resultado)*0.013;
	    				} else if ((captura) == "Cambio Cordoba a Dollar") {
	    					nOperacion = Integer.parseInt(resultado)*0.02745;
	    				} else if ((captura) == "Cambio Dollar a Cordoba") {
	    					nOperacion = Integer.parseInt(resultado)*36.40;
	    				} else if ((captura) == "Cambio Cordoba a Euro") {
	    					nOperacion = Integer.parseInt(resultado)*0.026;
	    				} else if ((captura) == "Cambio Euro a Cordoba") {
	    					nOperacion = Integer.parseInt(resultado)*38.58;
	    				}
	    				
	    				DecimalFormat df = new DecimalFormat("#,###.00"); //formato al valor de salida
	    				valorFormateado = df.format(nOperacion);	    				
	    				captura = (valorFormateado);
	    				jt4.setText(captura);
	    				jb6.addMouseListener(new MouseAdapter() {        // Boton Aceptar
	    					public void mousePressed(MouseEvent e) {
	    						int i = JOptionPane.showConfirmDialog(null, "Desea Continuar");
	    						if (i == 0) {
	    										jt1.setText(null);
	    										jt2.setText(null);
	    										jt3.setText(null);
	    										jt4.setText(null);
	    										return;
//	    										main(null);
	    									} else if (i == 1) {
	    										JOptionPane.showMessageDialog(null, "Programa Finalizado, \n Hasta la Proxima");
	    										System.exit(0);
	    									}  else if (i == 2) { 
	    										JOptionPane.showMessageDialog(null, "Programa Finalizado, \n Hasta la Proxima");
	    										System.exit(0);
	    									} else { System.out.println(i);
	    										
	    									}
	    										
	    									
	    					}
	    				});	// Fin del Evento llamado  por el Boton Aceptar
	    			}

	    			});  // Fin del Evento llamado  por el Boton Calcular
	}
	
	
	public static void main(String[] args) {
	    new TasaDeCambio();
	}
}

