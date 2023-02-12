package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.CandidateDAO;
import co.edu.unbosque.view.VMain;

public class Controller implements ActionListener {

	private CandidateDAO can_dao;
	private VMain v_principal; // Ventana principal

	public Controller() {
		can_dao = new CandidateDAO();
		v_principal = new VMain();

		v_principal.getBdelete().addActionListener(this);
		v_principal.getBdelete().setActionCommand("erase");

		v_principal.getBshowall().addActionListener(this);
		v_principal.getBshowall().setActionCommand("show");

		v_principal.getBregister().addActionListener(this);
		v_principal.getBregister().setActionCommand("register");

		v_principal.getBmodify().addActionListener(this);
		v_principal.getBmodify().setActionCommand("modify");

		v_principal.getBlist().addActionListener(this);
		v_principal.getBlist().setActionCommand("list");
	}

	// Inicio de ventana
	public void start() {
		v_principal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Try para capturar errores en lo botones
		try {
			// Boton encargado de eliminar registros
			if (e.getActionCommand().equals("erase")) {
				if (v_principal.getId_actions().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debes llenar el campo con la respectiva ID.");
				} else if (can_dao.erase(Integer.valueOf(v_principal.getId_actions().getText()))) { // Busca la id dada
																									// en la lista del
																									// DAO y si es
																									// verdadero la
																									// elimina
					JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
				} else {
					JOptionPane.showMessageDialog(null, "La ID que buscas no se ha encontrado.");
				}
				v_principal.getId_actions().setText(""); // Borra el contenido del JTextField de la ID a buscar/eliminar
				v_principal.getInfo().setText(can_dao.idlist()); // Actualizar la ventana de informacion mostrando las
																	// IDs restantes
			}

			// Boton encargado de desplegar la informacion de un solo registro en el
			// JTextArea
			if (e.getActionCommand().equals("show")) {
				if (v_principal.getId_actions().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debes llenar el campo con la respectiva ID.");

				} else {
					v_principal.getInfo()
							.setText(can_dao.showID(Integer.valueOf(v_principal.getId_actions().getText())).toString());
				}
			}
			// Boton encargado de modificar un registro
			if (e.getActionCommand().equals("modify")) {
				if (v_principal.getId_actions().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debes llenar el campo con la respectiva ID.");
				} else if (can_dao.modify(v_principal.getName_candidate().getText(),
						v_principal.getLast_name().getText(), Integer.valueOf(v_principal.getId().getText()),
						Integer.valueOf(v_principal.getAge().getText()), v_principal.getRank().getText(),
						Integer.valueOf(v_principal.getId_actions().getText()))) { // Busca si el registro existe, si es
																					// true modificara sus datos con los
																					// brindados
					JOptionPane.showMessageDialog(null, "El registro ha sido actualizado correctamente.");
				} else {
					JOptionPane.showMessageDialog(null, "La ID que buscas modificar no existe.");
				}
				v_principal.eraseData();// Vacia todos los TextField del panel de registro
				v_principal.getId_actions().setText("");
				v_principal.getInfo().setText(can_dao.idlist());
			}

			// Boton encargado de guardar nuevos registros
			if (e.getActionCommand().equals("register")) {
				if (v_principal.getName_candidate().getText().isEmpty()
						|| v_principal.getLast_name().getText().isEmpty() || v_principal.getId().getText().isEmpty()
						|| v_principal.getAge().getText().isEmpty() || v_principal.getRank().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos.");
				} else {
					can_dao.register(can_dao.create(v_principal.getName_candidate().getText(),
							v_principal.getLast_name().getText(), Integer.valueOf(v_principal.getId().getText()),
							Integer.valueOf(v_principal.getAge().getText()), v_principal.getRank().getText()));
					v_principal.eraseData();
					JOptionPane.showMessageDialog(null, "Registro realizado.");
					v_principal.getInfo().setText(can_dao.idlist());
				}
			}
			if (e.getActionCommand().equals("list")) {
				if (can_dao.idlist().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay candidatos registrados.");
				} else {
					v_principal.getInfo().setText(can_dao.idlist());
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Revisa los datos que has ingresado.");
		}
	}
}