package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.metier.Utilisateur;
import com.persistance.AccesData;

import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Form1 extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFichier;
	private JMenuItem mntmQuitter;
	private JMenu mnLevee;
	private JMenuItem mntmInsertionL;
	private JMenu mnFacture;
	private JMenuItem mntmGenrateFacture;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textLogin;
	private JPasswordField passwordField;
	private JButton btnValider;
	private String login;
	private String mdp;
	private int niveau;
	private String nomUtilisateur;
	private Utilisateur u;
	private JMenu mnConsultation;
	private JMenuItem mntmHabitation;
	private JMenu mnDonneeBase;
	private JMenuItem mntmAjoutTypeD;
	private JMenuItem mntmMiseaJourTTD;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form1 frame = new Form1();
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
	public Form1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		setTitle("Gestion poubelles");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		this.setJMenuBar(getMenuBar_1());
		mntmInsertionL.setEnabled(false);
		mntmGenrateFacture.setEnabled(false);
		mntmHabitation.setEnabled(false);
		mntmAjoutTypeD.setEnabled(false);
		mntmMiseaJourTTD.setEnabled(false);
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 434, 21);
			menuBar.add(getMnFichier());
			menuBar.add(getMnLevee());
			menuBar.add(getMnFacture());
			menuBar.add(getMnConsultation());
			menuBar.add(getMnDonneeBase());
		}
		return menuBar;
	}
	private JMenu getMnFichier() {
		if (mnFichier == null) {
			mnFichier = new JMenu("Fichier");
			mnFichier.add(getMntmQuitter());
		}
		return mnFichier;
	}
	private JMenuItem getMntmQuitter() {
		if (mntmQuitter == null) {
			mntmQuitter = new JMenuItem("Quitter");
			mntmQuitter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmQuitter;
	}
	private JMenu getMnLevee() {
		if (mnLevee == null) {
			mnLevee = new JMenu("Lev\u00E9e");
			mnLevee.add(getMntmInsertionL());
		}
		return mnLevee;
	}
	private JMenuItem getMntmInsertionL() {
		if (mntmInsertionL == null) {
			mntmInsertionL = new JMenuItem("Insertion Lev\u00E9e");
			mntmInsertionL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertionLevee();
				}
			});
		}
		return mntmInsertionL;
	}
	private JMenu getMnFacture() {
		if (mnFacture == null) {
			mnFacture = new JMenu("Facture");
			mnFacture.add(getMntmGenrateFacture());
		}
		return mnFacture;
	}
	private JMenuItem getMntmGenrateFacture() {
		if (mntmGenrateFacture == null) {
			mntmGenrateFacture = new JMenuItem("G\u00E9n\u00E9r\u00E9 facture");
			mntmGenrateFacture.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					editionFacture();
				}
			});
		}
		return mntmGenrateFacture;
	}
	private void insertionLevee() {
		// on affecte le panel de la fenêtre
		// avec une instance de PanelLevee
		this.setContentPane(new PanelLevee());
		// mets à jour le formulaire
		this.revalidate();
	}
	private void editionFacture() {
		// on affecte le panel de la fenêtre
		// avec une instance de PanelFacture
		this.setContentPane(new PanelFacture());
		// mets à jour le formulaire
		this.revalidate();
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(10, 11, 414, 218);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getTextLogin());
			panel.add(getPasswordField());
			panel.add(getBtnValider());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Login");
			lblNewLabel.setBounds(83, 44, 46, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Mot de passe");
			lblNewLabel_1.setBounds(83, 85, 78, 14);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextLogin() {
		if (textLogin == null) {
			textLogin = new JTextField();
			textLogin.setBounds(185, 41, 86, 20);
			textLogin.setColumns(10);
		}
		return textLogin;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(185, 82, 86, 20);
		}
		return passwordField;
	}
	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					login = textLogin.getText();
					mdp = new String(passwordField.getPassword());
					u = AccesData.utilisateur(login, mdp);
					if (u != null){
						niveau = u.getNiveau();
						nomUtilisateur = u.getNom();
					switch(niveau){
						case 1:{ fondEcran(nomUtilisateur);
								 mntmInsertionL.setEnabled(true);
								 mntmGenrateFacture.setEnabled(true);
								 mntmHabitation.setEnabled(true);
								 mntmAjoutTypeD.setEnabled(true);
								 mntmMiseaJourTTD.setEnabled(true);
								 break;
						}
						case 2:{ fondEcran(nomUtilisateur);
								 mntmGenrateFacture.setEnabled(true);
								 break;
						}
						case 3:{ fondEcran(nomUtilisateur);
								 mntmInsertionL.setEnabled(true);
						 		 break;
						}
						default : break;
					}
					}
					else{
						JOptionPane.showMessageDialog(null,"Erreur identification");
						textLogin.setText("");
						passwordField.setText("");
						textLogin.requestFocus();
					}
					
				}
			});
			btnValider.setBounds(185, 138, 89, 23);
		}
		return btnValider;
	}
	private void fondEcran(String nomUtilisateur){
		this.setContentPane(new PanelFondEcran(nomUtilisateur));
		this.revalidate();
	}
	private JMenu getMnConsultation() {
		if (mnConsultation == null) {
			mnConsultation = new JMenu("Consultation");
			mnConsultation.add(getMntmHabitation());
		}
		return mnConsultation;
	}
	private JMenuItem getMntmHabitation() {
		if (mntmHabitation == null) {
			mntmHabitation = new JMenuItem("Habitation par usager");
			mntmHabitation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					habitationParUsager();
				}
			});
		}
		return mntmHabitation;
	}
	private void habitationParUsager(){
		this.setContentPane(new PanelHabitationU());
		this.revalidate();
	}
	private JMenu getMnDonneeBase() {
		if (mnDonneeBase == null) {
			mnDonneeBase = new JMenu("Donn\u00E9es de base");
			mnDonneeBase.add(getMntmAjoutTypeD());
			mnDonneeBase.add(getMntmMiseaJourTTD());
		}
		return mnDonneeBase;
	}
	private JMenuItem getMntmAjoutTypeD() {
		if (mntmAjoutTypeD == null) {
			mntmAjoutTypeD = new JMenuItem("Ajout type d\u00E9chet");
			mntmAjoutTypeD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ajoutTypeD();
				}
			});
		}
		return mntmAjoutTypeD;
	}
	private void ajoutTypeD(){
		this.setContentPane(new PanelDechet());
		this.revalidate();
	}
	private JMenuItem getMntmMiseaJourTTD() {
		if (mntmMiseaJourTTD == null) {
			mntmMiseaJourTTD = new JMenuItem("Mise \u00E0 jour tarif type d\u00E9chet");
			mntmMiseaJourTTD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					miseajourTTD();
				}
			});
		}
		return mntmMiseaJourTTD;
	}
	
	private void miseajourTTD(){
		this.setContentPane(new PanelTarifTD());
		this.revalidate();
	}
}
