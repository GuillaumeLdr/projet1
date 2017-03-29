package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.metier.TypeDechet;
import com.persistance.AccesData;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelDechet extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textCode;
	private JTextField textLibelle;
	private JTextField textTarif;
	private JButton btnValider;
	private JButton btnAnnuler;
	//
	private String codeD = "";
	private String libelleD = "";
	private double tarifD = 0;
	private TypeDechet t;

	/**
	 * Create the panel.
	 */
	public PanelDechet() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getTextCode());
		add(getTextLibelle());
		add(getTextTarif());
		add(getBtnValider());
		add(getBtnAnnuler());
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Saisie d'un nouveau type d\u00E9chet");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setBounds(135, 11, 193, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Code type d\u00E9chet :");
			lblNewLabel_1.setBounds(49, 84, 101, 14);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Libell\u00E9 d\u00E9chet :");
			lblNewLabel_2.setBounds(49, 134, 89, 14);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Tarif au kg :");
			lblNewLabel_3.setBounds(49, 188, 89, 14);
		}
		return lblNewLabel_3;
	}
	private JTextField getTextCode() {
		if (textCode == null) {
			textCode = new JTextField();
			textCode.setBounds(185, 81, 121, 20);
			textCode.setColumns(10);
		}
		return textCode;
	}
	private JTextField getTextLibelle() {
		if (textLibelle == null) {
			textLibelle = new JTextField();
			textLibelle.setBounds(185, 131, 164, 20);
			textLibelle.setColumns(10);
		}
		return textLibelle;
	}
	private JTextField getTextTarif() {
		if (textTarif == null) {
			textTarif = new JTextField();
			textTarif.setBounds(185, 185, 121, 20);
			textTarif.setColumns(10);
		}
		return textTarif;
	}
	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					codeD = textCode.getText();
					libelleD = textLibelle.getText();
					if (verifSaisie()){
						tarifD = Double.parseDouble(textTarif.getText());
						t = new TypeDechet(codeD, libelleD, tarifD);
						if (AccesData.ajoutTypeDechet(t)){
							JOptionPane.showMessageDialog(null,"Insertion effectué");
							textCode.setText("");
							textLibelle.setText("");
							textTarif.setText("");
							textCode.requestFocus();
						}
						else{
							JOptionPane.showMessageDialog(null,"Erreur insertion type déchet : ce code existe déjà");
							textCode.requestFocus();
						}
					}
				}
			});
			btnValider.setBounds(88, 246, 89, 23);
		}
		return btnValider;
	}
	
	private boolean verifSaisie(){
		boolean ok = false;
		codeD = textCode.getText();
		libelleD = textLibelle.getText();
		if ((codeD.equals("")) || (codeD.length() != 3)){
			JOptionPane.showMessageDialog(null,"Saisit du code Obligatoire avec une Longueur de 3");
			textCode.requestFocus();
		} else {
			if (libelleD.equals("")) {
				JOptionPane.showMessageDialog(null,"Saisit du libellé Obligatoire");
				textLibelle.requestFocus();
			} else {
				if(textTarif.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Saisit du tarif obligatoire");
					textTarif.requestFocus();
				} else {
					try {
						tarifD = Double.parseDouble(textTarif.getText());
						ok = true;
					} catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(null,"Le tarif doit être un nombre");
						textTarif.requestFocus();
					}
				}
			}
		}
		return ok;
	}
	
	
	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textCode.setText("");
					textLibelle.setText("");
					textTarif.setText("");
					textCode.requestFocus();
				}
			});
			btnAnnuler.setBounds(267, 246, 89, 23);
		}
		return btnAnnuler;
	}
}
