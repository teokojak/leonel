package Convertidores;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {
	
		/*
	 	Creamos los paneles de la Tasa de Cambio / Temperatura.
		 */
	
		private JPanel contentPane1, contentPane2;

		private JTextField textFieldCantidad, textFieldCantidadT; 
		private JTextField textField_1Tasa;
		private JTextField textField_2Resultado;
		static String captura;
		static double nOperacion;
		static String valorFormateado;
		private JTextField textField;
		 
		String[] variosPaisesTC = {"Seleccione T/C","Cambio Yen a Dollar", "Cambio Dollar a Yen","Cambio Dollar a Euros", "Cambio Euros a Dollar",	"Cambio Dollar a Rublos", "Cambio Rublos a Dollar",
			 "Cambio Cordoba a Dollar","Cambio Dollar a Cordoba", "Cambio Cordoba a Euro", "Cambio Euro a Cordoba"};
		
		String[] variosTiposDeTemperaturas= {"Seleccione","Grados Centigrados -> Grados Fharenheit", "Grados Fharenheit -> Grados Centigrados","Grados Centigrados -> Grados Kelvin",
			     "Grados Kelvin -> Grados Centigrados", "Grados Fharenheit -> Grados Kelvin"};
	
	public VentanaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CONVERSOR DE MEDIDAS Y MONEDAS");
		setSize(600, 365);
		setLayout(null);
		
		setLocationRelativeTo(null);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		
		String Opcion = JOptionPane.showInputDialog("*** CONVERTIR: ELIJA SU OPCION ***\n" 
				+ "1. Convertir Monedas - Tasa de Cambios \n" 
				+ "2. Convertir - Temperaturas \n"
				+ "3. Salir");
		switch (Opcion) {
			case "1": 
				contentPane1 = new JPanel();
				TasasDeCambios();
				break;
			case "2": 
				contentPane2 = new JPanel();
				Temperatura();
				break;
			case "3":
				JOptionPane.showMessageDialog(null, "Hasta Pronto");
				System.exit(0);
		}
	}

	private void TasasDeCambios() {
		
		// Inicio con la creacion de los componentes del primer JPanel, en este caso "Tasas de Cambio"

		JLabel lblNewLabel = new JLabel("¿ Cuanto desea Cambiar ?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblNewLabel.setBounds(99, 11, 206, 17);
		
		JLabel lblNewLabel_1 = new JLabel("Monedas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(45, 77, 61, 14);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de Cambios");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(20, 91, 97, 14);
		
		JComboBox monedas = new JComboBox(variosPaisesTC);
		
		JButton btnNewButton = new JButton("LISTO ");
		btnNewButton.setBackground(new Color(128, 128, 64));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(170, 210, 89, 23);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\teoko\\eclipse-workspace\\jPanelMultiple\\src\\Imagenes\\1551294109_3.jpg"));
		lblNewLabel_4.setBounds(269, 110, 254, 140);
		
		monedas.setForeground(new Color(255, 255, 255));
		monedas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		monedas.setBackground(new Color(0, 0, 255));
		monedas.setBounds(116, 77, 177, 22);
		
		JLabel lblNewLabel_2 = new JLabel("TASA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(298, 81, 36, 14);
		
		textField_1Tasa = new JTextField();
		textField_1Tasa.setBounds(338, 78, 119, 20);
		textField_1Tasa.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("La Cantidad a recibir es:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(20, 116, 144, 14);
		
		textField_2Resultado = new JTextField();
		textField_2Resultado.setBounds(173, 110, 86, 20);
		textField_2Resultado.setColumns(10);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(134, 39, 171, 20);
		textFieldCantidad.setColumns(10);
		
		// Agrego todos estos componentes a la Ventana Principal
		
		add(lblNewLabel);
		add(lblNewLabel_1);
		add(lblNewLabel_5);
		add(monedas);
		add(btnNewButton);
		add(lblNewLabel_4);
		add(lblNewLabel_2);
		add(textField_1Tasa);
		add(lblNewLabel_3);
		add(textField_2Resultado);
		add(textFieldCantidad);
		
		// Aqui se inician las opciones que hara el usuario en cuanto al cambio de moneda desde un ComboBox, al mismo tiempo trabajamos con condicionales
		// if else para controlar la eleccion del usuario
		
		monedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				String seleccion = (String) monedas.getSelectedItem();
				String resultado = (String) textFieldCantidad.getText();				
				if (resultado.isBlank()) { // Aqui controlamos que no vayan valores en en Blanco/Vacios
					JOptionPane.showMessageDialog(null, "Disculpe Debe usar \n NUMEROS \n Intente de Nuevo");
					textFieldCantidad.setText(null);
					textField_1Tasa.setText(null);
					textField_2Resultado.setText(null);
					return;}
				else if (Integer.parseInt(resultado) > 0) {  // Aqui controlamos que no vayan valores en 0
				    if ((seleccion) == "Cambio Yen a Dollar") {
						textField_1Tasa.setText("de Cambio: 0.0073");	
						nOperacion = Integer.parseInt(resultado)*0.0075;
					} else if ((seleccion) == "Cambio Dollar a Yen") {
						textField_1Tasa.setText("de Cambio: 136.12");
						nOperacion = Integer.parseInt(resultado)*136.12;
					} else if ((seleccion) == "Cambio Dollar a Euros") {
						textField_1Tasa.setText("de Cambio: 0.94");
						nOperacion = Integer.parseInt(resultado)*0.94;
					} else if ((seleccion) == "Cambio Euros a Dollar") {
						textField_1Tasa.setText("de Cambio: 1.07");
						nOperacion = Integer.parseInt(resultado)*1.07;
					} else if ((seleccion) == "Cambio Dollar a Rublos") {
						captura = "Cambio Dollar a Rublos";
						textField_1Tasa.setText("de Cambio: 75.26");
						nOperacion = Integer.parseInt(resultado)*75.26;
					} else if ((seleccion) == "Cambio Rublos a Dollar") {
						textField_1Tasa.setText("de Cambio: 0.013");
						nOperacion = Integer.parseInt(resultado)*0.013;
					} else if ((seleccion) == "Cambio Cordoba a Dollar") {
						textField_1Tasa.setText("de Cambio: 0.02745");
						nOperacion = Integer.parseInt(resultado)*0.02745;
					} else if ((seleccion) == "Cambio Dollar a Cordoba") {
						textField_1Tasa.setText("de Cambio: 36.00");
						nOperacion = Integer.parseInt(resultado)*36.00;
					} else if ((seleccion) == "Cambio Cordoba a Euro") {
						textField_1Tasa.setText("de Cambio: 0.026");
						nOperacion = Integer.parseInt(resultado)*0.026;
					} else if ((seleccion) == "Cambio Euro a Cordoba") {
						textField_1Tasa.setText("de Cambio: 38.86");
						nOperacion = Integer.parseInt(resultado)*38.86;
					} 
				} else { 
					JOptionPane.showMessageDialog(null, "Disculpe Debe usar \n Valores Mayores a 0.00 \n Intente de Nuevo");
					textFieldCantidad.setText(null);
					textField_1Tasa.setText(null);
					textField_2Resultado.setText(null);
					return;
				}
				
				// Aqui damos formatos al número de salida después de la operación del Usuario
				
				DecimalFormat df = new DecimalFormat("#,###.00"); //formato al valor de salida
				valorFormateado = df.format(nOperacion);	    				
				captura = (valorFormateado);
				textField_2Resultado.setText(captura);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Desea Continuar");
				if (i == 0) {
					textFieldCantidad.setText(null);
					textField_1Tasa.setText(null);
					textField_2Resultado.setText(null);
					return;
				} else if (i == 1) {
					JOptionPane.showMessageDialog(null, "Programa Finalizado,\n Hasta la Próxima");
					System.exit(0);
				}  else if (i == 2) { 
					JOptionPane.showMessageDialog(null, "Programa Finalizado,\n Hasta la Próxima");
					System.exit(0);
				} else { System.out.println(i);
								
			}
		}});
	}
	
	private void Temperatura() {
		
		JLabel lblNewLabel_6 = new JLabel("Conversion Unidades de Temperatura");
		lblNewLabel_6.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 22, 249, 14);
		
		JComboBox temperaturas = new JComboBox(variosTiposDeTemperaturas);
		temperaturas.setBounds(87, 81, 229, 22);
		
		JButton btnNewTT = new JButton("SALIR");
		btnNewTT.setBackground(new Color(128, 128, 64));
		btnNewTT.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewTT.setForeground(new Color(0, 0, 0));
		btnNewTT.setBounds(170, 210, 89, 23);
		
		JLabel lblNewLabel_7 = new JLabel("¿ Que Cantidad desea Convertir ?");
		lblNewLabel_7.setBounds(10, 42, 169, 14);
		
		textFieldCantidadT = new JTextField();
		textFieldCantidadT.setBounds(187, 39, 100, 20);
		textFieldCantidadT.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Elija Abajo la Temperatura a convertir");
		lblNewLabel_8.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblNewLabel_8.setBounds(10, 60, 280, 22);
		
		JTextArea txtrElResultadoDe = new JTextArea();
		txtrElResultadoDe.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtrElResultadoDe.setText("El Resultado de lo Solicitado es:");
		txtrElResultadoDe.setBounds(10, 117, 306, 22);
		
		textField = new JTextField(); /// este es el del resultado
		textField.setBounds(10, 147, 306, 20);
		textField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\teoko\\Pictures\\Temperatura.png"));
		lblNewLabel_9.setBounds(330, 15, 291, 190);
		
		JLabel lblNewLabel_10 = new JLabel("Grados");
		lblNewLabel_10.setBounds(31, 85, 46, 14);
		
		add(lblNewLabel_6);
		add(temperaturas);
		add(btnNewTT);
		add(lblNewLabel_7);
		add(textFieldCantidadT);
		add(lblNewLabel_8);
		add(txtrElResultadoDe);
		add(textField);
		add(lblNewLabel_9);
		add(lblNewLabel_10);
		
		temperaturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				String seleccion = (String) temperaturas.getSelectedItem();
				String resultado = (String) textFieldCantidadT.getText();
				if (resultado.isBlank()) {
					JOptionPane.showMessageDialog(null, "Disculpe Debe usar \n NUMEROS \n Intente de Nuevo");
					textFieldCantidadT.setText(null);
					textField.setText(null);
					return;}
				if (Integer.parseInt(resultado) > 0) {
					if ((seleccion) == "Grados Centigrados -> Grados Fharenheit") {
						nOperacion = Integer.parseInt(resultado)*1.8+32;
					} else if ((seleccion) == "Grados Fharenheit -> Grados Centigrados") {
						nOperacion = (Integer.parseInt(resultado)-32)/1.8;
					} else if ((seleccion) == "Grados Centigrados -> Grados Kelvin") {
						nOperacion = Integer.parseInt(resultado)+273;
					} else if ((seleccion) == "Grados Kelvin -> Grados Centigrados" ) {
						nOperacion = Integer.parseInt(resultado)-273;
					} else if ((seleccion) == "Grados Fharenheit -> Grados Kelvin") {
						nOperacion = Integer.parseInt(resultado)-(32/1.8)+273;
					} 
				} else { 
						JOptionPane.showMessageDialog(null, "Disculpe Debe usar \n Valores Mayores a 0.00 \n Intente de Nuevo");
						textFieldCantidadT.setText(null);
						return;
			}
				DecimalFormat df = new DecimalFormat("#,###.00"); //formato al valor de salida
				valorFormateado = df.format(nOperacion);	    				
				captura = (valorFormateado);
				textField.setText(captura);
			}
		});
		
		btnNewTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Desea Continuar");
				if (i == 0) {
					textFieldCantidadT.setText(null);
					textField.setText(null);
//					System.exit(0);
					return;
				} else if (i == 1) {
					JOptionPane.showMessageDialog(null, "Programa Finalizado,\n Hasta la Próxima");
					System.exit(0);
				}  else if (i == 2) { 
					JOptionPane.showMessageDialog(null, "Programa Finalizado,\n Hasta la Próxima");
					System.exit(0);
				} else { System.out.println(i);
								
			}
		}});
		
		
	}
}
