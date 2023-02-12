package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VMain extends JFrame {

	private JPanel register, showall, showids;
	private JLabel t_tittle, t_name, t_last_name, t_id, t_age, t_rank, t_action, t_register, t_showall, t_list,
			t_delete, fondo;
	private JTextField name_candidate, last_name, id, age, rank, id_actions;
	private JButton bregister, bshowall, bdelete, bmodify, blist;
	private JTextArea showcase; // Area de texto donde se muestra informacion y la lista de IDs registradas

	public VMain() {
		setBounds(10, 10, 865, 770);
		setTitle("Recursos humanos");
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("Icono.png")).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		 
		fondo = new JLabel(); // se coloca el fondo del programa
		fondo.setBounds(0, 0, 850, 740);
		BufferedImage b11 = null;
		try {
			b11 = ImageIO.read(new File("src/panelCompleto.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image redim11 = b11.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(redim11));
		add(fondo);

		t_tittle = new JLabel(); // titulo del programa
		t_tittle.setBounds(25, 20, 800, 100);
		t_tittle.setFont(new Font("Arial", Font.BOLD, 35));
		t_tittle.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		t_tittle.setForeground(Color.white);
		t_tittle.setText("        Recursos Humanos Condenados Corp®   ");
		fondo.add(t_tittle);

		register = new JPanel(); // Paneles que tendran dentro diferentes componentes
		register.setBounds(25, 140, 500, 400);
		register.setBackground(new Color(189, 42, 46));
		register.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		register.setLayout(null);
		add(register);

		showall = new JPanel();
		showall.setBounds(25, 565, 500, 130);
		showall.setBackground(new Color(189, 42, 46));
		showall.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		showall.setLayout(null);
		add(showall);

		showids = new JPanel();
		showids.setBounds(585, 140, 240, 560);
		showids.setBackground(new Color(189, 42, 46));
		showids.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		showids.setLayout(null);
		add(showids);

		// compomnentes del primer panel
		t_name = new JLabel();
		t_name.setBounds(25, 13, 600, 100);
		t_name.setFont(new Font("Arial", Font.BOLD, 25));
		t_name.setForeground(Color.white);
		t_name.setText("Digite nombre:");
		register.add(t_name);

		name_candidate = new JTextField();
		name_candidate.setBounds(250, 50, 200, 25);
		name_candidate.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		register.add(name_candidate);

		t_last_name = new JLabel();
		t_last_name.setBounds(25, 64, 600, 100);
		t_last_name.setFont(new Font("Arial", Font.BOLD, 25));
		t_last_name.setForeground(Color.white);
		t_last_name.setText("Digite apellido:");
		register.add(t_last_name);

		last_name = new JTextField();
		last_name.setBounds(250, 100, 200, 25);
		last_name.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		register.add(last_name);

		t_id = new JLabel();
		t_id.setBounds(25, 115, 600, 100);
		t_id.setFont(new Font("Arial", Font.BOLD, 25));
		t_id.setForeground(Color.white);
		t_id.setText("Digite ID:");
		register.add(t_id);

		id = new JTextField();
		id.setBounds(250, 150, 200, 25);
		id.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		register.add(id);

		t_age = new JLabel();
		t_age.setBounds(25, 165, 600, 100);
		t_age.setFont(new Font("Arial", Font.BOLD, 25));
		t_age.setForeground(Color.white);
		t_age.setText("Digite edad:");
		register.add(t_age);

		age = new JTextField();
		age.setBounds(250, 200, 200, 25);
		age.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		register.add(age);

		t_rank = new JLabel();
		t_rank.setBounds(25, 213, 600, 100);
		t_rank.setFont(new Font("Arial", Font.BOLD, 25));
		t_rank.setForeground(Color.white);
		t_rank.setText("Digite cargo:");
		register.add(t_rank);

		rank = new JTextField();
		rank.setBounds(250, 250, 200, 25);
		rank.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		register.add(rank);

		bregister = new JButton();
		bregister.setBounds(180, 320, 100, 50);
		bregister.setText("Registrar");
		bregister.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		bregister.setBackground(Color.white);
		register.add(bregister);

		// JTextField encargado de recibir las ID que se usaran como guia para las
		// diferentes acciones, componentes segundo panel

		t_action = new JLabel();
		t_action.setBounds(30, 5, 600, 45);
		t_action.setFont(new Font("Arial", Font.BOLD, 17));
		t_action.setForeground(Color.white);
		t_action.setText("Digite ID para realizar alguna acción:");
		showall.add(t_action);

		id_actions = new JTextField();
		id_actions.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		id_actions.setBounds(330, 15, 150, 25);
		showall.add(id_actions);

		bdelete = new JButton();
		bdelete.setBounds(15, 70, 100, 50);
		bdelete.setBackground(Color.white);
		bdelete.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		bdelete.setText("Eliminar");
		showall.add(bdelete);

		bshowall = new JButton();
		bshowall.setBounds(140, 70, 100, 50);
		bshowall.setText("Mostrar ID");
		bshowall.setBackground(Color.white);
		bshowall.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		showall.add(bshowall);

		bmodify = new JButton();
		bmodify.setBounds(265, 70, 100, 50);
		bmodify.setText("Modificar");
		bmodify.setBackground(Color.white);
		bmodify.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		showall.add(bmodify);

		blist = new JButton();
		blist.setBounds(390, 70, 100, 50);
		blist.setText("Lista IDs");
		blist.setBackground(Color.white);
		blist.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		showall.add(blist);

		// Componentes tercer panel
		t_list = new JLabel();
		t_list.setBounds(45, 20, 720, 20);
		t_list.setFont(new Font("Arial", Font.BOLD, 22));
		t_list.setForeground(Color.white);
		t_list.setText("IDs Registradas");
		showids.add(t_list);

		showcase = new JTextArea();
		showcase.setEnabled(false);
		showcase.setBounds(12, 60, 215, 480);
		showcase.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		showids.add(showcase);

		fondo.add(register);
		fondo.add(showall);
		fondo.add(showids);

	}

	// getters and setters
	public JTextArea getInfo() {
		return showcase;
	}

	public void setInfo(JTextArea info) {
		this.showcase = info;
	}

	public JButton getBlist() {
		return blist;
	}

	public void setBlist(JButton blist) {
		this.blist = blist;
	}

	public JPanel getRegister() {
		return register;
	}

	public JPanel getShowids() {
		return showids;
	}

	public void setShowids(JPanel showids) {
		this.showids = showids;
	}

	public JButton getBmodify() {
		return bmodify;
	}

	public void setBmodify(JButton bmodify) {
		this.bmodify = bmodify;
	}

	public void setRegister(JPanel register) {
		this.register = register;
	}

	public JPanel getShowall() {
		return showall;
	}

	public void setShowall(JPanel showall) {
		this.showall = showall;
	}

	public JPanel getDelete() {
		return showids;
	}

	public void setDelete(JPanel delete) {
		this.showids = delete;
	}

	public JLabel getT_register() {
		return t_register;
	}

	public void setT_register(JLabel t_register) {
		this.t_register = t_register;
	}

	public JLabel getT_showall() {
		return t_showall;
	}

	public void setT_showall(JLabel t_showall) {
		this.t_showall = t_showall;
	}

	public JLabel getT_delete() {
		return t_delete;
	}

	public void setT_delete(JLabel t_delete) {
		this.t_delete = t_delete;
	}

	public JTextField getName_candidate() {
		return name_candidate;
	}

	public void setName_candidate(JTextField name_candidate) {
		this.name_candidate = name_candidate;
	}

	public JTextField getLast_name() {
		return last_name;
	}

	public void setLast_name(JTextField last_name) {
		this.last_name = last_name;
	}

	public JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
	}

	public JTextField getAge() {
		return age;
	}

	public void setAge(JTextField age) {
		this.age = age;
	}

	public JTextField getRank() {
		return rank;
	}

	public void setRank(JTextField rank) {
		this.rank = rank;
	}

	public JTextField getId_actions() {
		return id_actions;
	}

	public void setId_actions(JTextField id_actions) {
		this.id_actions = id_actions;
	}

	public JButton getBregister() {
		return bregister;
	}

	public void setBregister(JButton bregister) {
		this.bregister = bregister;
	}

	public JButton getBshowall() {
		return bshowall;
	}

	public void setBshowall(JButton bshowall) {
		this.bshowall = bshowall;
	}

	public JButton getBdelete() {
		return bdelete;
	}

	public void setBdelete(JButton bdelete) {
		this.bdelete = bdelete;
	}

	public void eraseData() { // limpiar los campos
		name_candidate.setText("");
		last_name.setText("");
		age.setText("");
		rank.setText("");
		id.setText("");
	}

}
