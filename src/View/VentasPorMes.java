package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import Controller.Supermercado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentasPorMes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField año;
	private JTextField mes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentasPorMes frame = new VentasPorMes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentasPorMes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseAo = new JLabel("Ingrese Año:");
		lblIngreseAo.setBounds(30, 40, 96, 14);
		contentPane.add(lblIngreseAo);
		
		JLabel lblIngreseMes = new JLabel("Ingrese Mes:");
		lblIngreseMes.setBounds(30, 83, 96, 14);
		contentPane.add(lblIngreseMes);
		
		año = new JTextField();
		año.setBounds(120, 37, 86, 20);
		contentPane.add(año);
		año.setColumns(10);
		
		mes = new JTextField();
		mes.setBounds(120, 80, 86, 20);
		contentPane.add(mes);
		mes.setColumns(10);
		
		JButton btnObtenerTotal = new JButton("Obtener Total");
		btnObtenerTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				float total = Supermercado.getInstancia().getTotal(Integer.parseInt(año.getText()), Integer.parseInt(mes.getText()));
				JOptionPane.showMessageDialog(null,"El total del mes es: " + total, "Total Mensual",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnObtenerTotal.setBounds(166, 145, 133, 23);
		contentPane.add(btnObtenerTotal);
	}
}
