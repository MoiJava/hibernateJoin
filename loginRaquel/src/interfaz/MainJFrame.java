/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Dimension;

import business.Person;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

/**
 *
 * @author ankit
 */
public class MainJFrame extends javax.swing.JFrame {

	static public List<Person> empleados = new ArrayList<>();

	/**
	 * Creates new form MainJFrame
	 */

	Person person;
	int incArray = 0;
	
	public MainJFrame() {
		initComponents();
		person = new Person();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated
// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jSplitPane1 = new javax.swing.JSplitPane();
		controlJPanel = new javax.swing.JPanel();
		controlJPanel.setPreferredSize(new Dimension(600, 700));
		createPerson = new javax.swing.JButton();
		viewPerson = new javax.swing.JButton();
		displayJPanel = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		createPerson.setText("Create Profile");
		createPerson.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				createPersonActionPerformed(evt);
			}
		});

		viewPerson.setText("Display Profile");
		viewPerson.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewPersonActionPerformed(evt);
			}
		});

		JButton cargarPerfil = new JButton();
		cargarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				empleados.clear();
				try {
					FileReader fr = new FileReader("usuarios.txt");
					BufferedReader br = new BufferedReader(fr);
					Scanner s = new Scanner(br);

					if (!s.hasNext()) {
						JOptionPane.showMessageDialog(null, "No hay perfiles");
					} else {
						while (s.hasNext()) {
							empleados.add(new Person(s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(),
									s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextInt(),
									s.nextLine(), s.nextDouble()));
						}
					}
					try {
						br.close();
					} catch (IOException e) {
						System.out.println("No se puede leer en disco");
					}
					JOptionPane.showMessageDialog(null, "Perfil cargado correctamente");

				} catch (FileNotFoundException e) {
					System.out.println("No se puede encontrar el archivo");
				}
			}
		});
		cargarPerfil.setText("Cargar Perfil");

		JButton guardarPerfil = new JButton();
		guardarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (person.getName() == null) {
						JOptionPane.showMessageDialog(null, "No ningún usuario creado");
					} else {
						FileWriter fw = new FileWriter("usuarios.txt", true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						for (int i = 0; i < empleados.size(); i++) {
							pw.println(empleados.get(i).getName());
							pw.println(empleados.get(i).getGeographic_data());
							pw.println(empleados.get(i).getDob());
							pw.println(empleados.get(i).getPhone());
							pw.println(empleados.get(i).getEmail());
							pw.println(empleados.get(i).getSsn());
							pw.println(empleados.get(i).getImagetxt());
							pw.println(empleados.get(i).getBankAccNum());
							pw.println(empleados.get(i).getDepartamento());
							pw.println(empleados.get(i).getIncorporacion());
							pw.println(empleados.get(i).getEmpcode());
							pw.println(empleados.get(i).getSueldo());

						}
						pw.close();
						JOptionPane.showMessageDialog(null, "Se ha guardado perfectamente");
					}
				} catch (IOException i) {
					JOptionPane.showMessageDialog(null, "No se ha podido crear el fichero");
				}
			}
		});
		guardarPerfil.setText("Guardar Perfil");

		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (incArray == 0) {
					JOptionPane.showMessageDialog(null, "No hay perfiles anteriores");
				}else {
					incArray --;
					viewPersonActionPerformed(e);
				}
			}
		});

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incArray ++;
				if (incArray >= empleados.size()) {
					JOptionPane.showMessageDialog(null, "Estás en el último perfil");
				}else {
					viewPersonActionPerformed(e);
				}
			}
		});

		javax.swing.GroupLayout controlJPanelLayout = new javax.swing.GroupLayout(controlJPanel);
		controlJPanelLayout.setHorizontalGroup(controlJPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(controlJPanelLayout.createSequentialGroup().addContainerGap().addGroup(controlJPanelLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(controlJPanelLayout.createSequentialGroup().addComponent(createPerson)
								.addContainerGap(493, Short.MAX_VALUE))
						.addGroup(controlJPanelLayout.createSequentialGroup()
								.addComponent(viewPerson, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(493))
						.addGroup(controlJPanelLayout.createSequentialGroup()
								.addComponent(cargarPerfil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(495))
						.addGroup(Alignment.TRAILING, controlJPanelLayout.createSequentialGroup()
								.addGroup(controlJPanelLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnSiguiente, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95,
												Short.MAX_VALUE)
										.addComponent(btnAtras, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95,
												Short.MAX_VALUE)
										.addComponent(guardarPerfil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addGap(495)))));
		controlJPanelLayout.setVerticalGroup(controlJPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(controlJPanelLayout.createSequentialGroup().addGap(123).addComponent(createPerson).addGap(77)
						.addComponent(viewPerson).addGap(74).addComponent(cargarPerfil).addGap(80)
						.addComponent(guardarPerfil).addGap(72).addComponent(btnAtras).addGap(64)
						.addComponent(btnSiguiente).addContainerGap(84, Short.MAX_VALUE)));
		controlJPanel.setLayout(controlJPanelLayout);

		jSplitPane1.setLeftComponent(controlJPanel);

		javax.swing.GroupLayout displayJPanelLayout = new javax.swing.GroupLayout(displayJPanel);
		displayJPanel.setLayout(displayJPanelLayout);
		displayJPanelLayout.setHorizontalGroup(displayJPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 515, Short.MAX_VALUE));
		displayJPanelLayout.setVerticalGroup(displayJPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 472, Short.MAX_VALUE));

		jSplitPane1.setRightComponent(displayJPanel);

		getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void createPersonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_createPersonActionPerformed
// TODO add your handling code here:
		CreateJPanel createJPanel = new CreateJPanel(person);
		jSplitPane1.setRightComponent(createJPanel);

	}// GEN-LAST:event_createPersonActionPerformed

	private void viewPersonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_viewPersonActionPerformed
// TODO add your handling code here:

		DisplayJPanel viewJPanel = new DisplayJPanel(empleados, incArray);
		jSplitPane1.setRightComponent(viewJPanel);

	}// GEN-LAST:event_viewPersonActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainJFrame().setVisible(true);
			}
		});
	}

// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel controlJPanel;
	private javax.swing.JButton createPerson;
	private javax.swing.JPanel displayJPanel;
	private javax.swing.JSplitPane jSplitPane1;
	private javax.swing.JButton viewPerson;
}