package practica;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Principal implements KeyListener{

	private JFrame frame;
	private JTable table;
	public int pidGestion;
	public int pidJuego;
	public TextField textField;
	public TextArea textArea_1;
	private JButton btnNewButton_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
			table.setBounds(350, 177, 228, 95);
			frame.getContentPane().add(table);
		
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		JButton btnNewButton = new JButton("Bloc de Notas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime bdn = Runtime.getRuntime();
					bdn.exec("notepad "+System.getProperty("user.dir")+"\\BlocDeNotas.txt");
					modelo.addRow(new Object[]{"Bloc de Notas"});
					btnNewButton.setEnabled(false);
					
				}
				catch (IOException ex) {
					System.out.println("IOException "+ex.getMessage());
				}
		}});
		btnNewButton.setBounds(533, 28, 103, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Paint");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime paint = Runtime.getRuntime();
					paint.exec("mspaint");
					modelo.addRow(new Object[]{"Paint"});
					btnNewButton_1.setEnabled(false);
				}
				catch(Exception ex) {
					System.out.println("Exception "+ex.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(533, 62, 103, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Gesti\u00F3n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String arg1 = "java";
					String arg2 = "-jar";
					String arg3 = "C:\\Users\\Grupo Studium\\Desktop\\DAM\\PSP\\Runnables\\Gestion.jar";
					String[] param = { arg1, arg2, arg3 };
					Process gestion = Runtime.getRuntime().exec(param);
					pidGestion = (int) gestion.pid();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				modelo.addRow(new Object[]{"Gestión"});
				btnNewButton_2.setEnabled(false);
			}
		});
		btnNewButton_2.setBounds(533, 96, 103, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Juego");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String arg1 = "java";
				String arg2 = "-jar";
				String arg3 = "C:\\Users\\Grupo Studium\\Desktop\\DAM\\PSP\\Runnables\\Ajedrez.jar";
				String[] param = { arg1, arg2, arg3 };
				Process gestion;
				try {
					gestion = Runtime.getRuntime().exec(param);
					pidJuego = (int) gestion.pid();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				btnNewButton_3.setEnabled(false);
				modelo.addRow(new Object[]{"Juego"});
			}
		});
		btnNewButton_3.setBounds(533, 130, 103, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Terminar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
				
				String prgSelect = table.getValueAt(index, 0).toString();
				if (prgSelect=="Bloc de Notas") {
					try {
						Runtime closeBN = Runtime.getRuntime();
						closeBN.exec("cmd /c taskkill /f /im notepad.exe");
						btnNewButton.setEnabled(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("Exception " + e1.getMessage());
					}
				}
				if (prgSelect == "Paint") {
					try {
						Runtime closeBN = Runtime.getRuntime();
						closeBN.exec("cmd /c taskkill /f /im mspaint.exe");
						btnNewButton_1.setEnabled(true);
					}  catch (IOException e2) {
						// TODO Auto-generated catch block
						System.out.println("Exception " + e2.getMessage());
					}
				}
				if (prgSelect=="Gestión") {
					try {
						Runtime closeBN = Runtime.getRuntime();
						closeBN.exec("cmd /c taskkill /f /pid " + pidGestion);
						btnNewButton_2.setEnabled(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("Exception " + e1.getMessage());
					}
				}
				if (prgSelect=="Juego") {
					try {
						Runtime closeBN = Runtime.getRuntime();
						closeBN.exec("cmd /c taskkill /f /pid " + pidJuego);
						btnNewButton_3.setEnabled(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("Exception " + e1.getMessage());
					}
				}
				
				modelo.removeRow(index);
			}
		});
		btnNewButton_4.setBounds(588, 177, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Procesos activos");
		lblNewLabel.setBounds(350, 157, 138, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textArea_1 = new TextArea();
		textArea_1.setBounds(10, 80, 306, 192);
		textArea_1.getScrollbarVisibility();
		textArea_1.setEditable(false);
		frame.getContentPane().add(textArea_1);
		
		textField = new TextField();
		textField.setBounds(10, 28, 176, 23);
		textField.addKeyListener(this);;
		frame.getContentPane().add(textField);
		
		btnNewButton_5 = new JButton("Ejecutar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Process cmd = Runtime.getRuntime().exec("cmd /c " + textField.getText());
					InputStream is = cmd.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					String line;
					textArea_1.setText("");
					while ((line = br.readLine()) != null) {
						
						textArea_1.append(line + "\n");
						
					}
					is.close();
					textField.setText("");
					
				}
				catch (Exception ex){
					System.out.println("Exception " + ex.getMessage());
				}
			}
		
		});
		btnNewButton_5.setBounds(227, 28, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		
		
		
		
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			try {
				btnNewButton_5.doClick();	
			}
			catch (Exception ex){
				System.out.println("Exception " + ex.getMessage());
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
