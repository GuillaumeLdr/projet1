package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.metier.TypeDechet;
import com.persistance.AccesData;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelTarifTD extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox comboBoxTD;
	private JTextField textTActuel;
	private JTextField textTNouveau;
	private JButton btnValider;
	private JButton btnAnnuler;
	//
	private List<TypeDechet> listeTD;
	private double nouveauTarif = 0;
	private String id;
	private String libelle;
	private double tarif;
	private int indexCbx;
	private String text;
	private TypeDechet typeD;

	/**
	 * Create the panel.
	 */
	public PanelTarifTD() {
		listeTD = AccesData.getLesTypeDechet();
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getComboBoxTD());
		add(getTextTActuel());
		add(getTextTNouveau());
		add(getBtnValider());
		add(getBtnAnnuler());
		textTActuel.setEnabled(false);

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Mise \u00E0 jour tarif par type de d\u00E9chet");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(94, 11, 257, 25);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Type d\u00E9chet :");
			lblNewLabel_1.setBounds(58, 71, 101, 14);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Tarif actuel :");
			lblNewLabel_2.setBounds(58, 116, 76, 14);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Nouveau tarif :");
			lblNewLabel_3.setBounds(58, 163, 88, 14);
		}
		return lblNewLabel_3;
	}
	private JComboBox getComboBoxTD() {
		if (comboBoxTD == null) {
			comboBoxTD = new JComboBox();
			comboBoxTD.setBounds(169, 68, 182, 20);
			for (TypeDechet td : listeTD){
				id = td.getIdTypeDechet();
				libelle = td.getLibelle();
				tarif = td.getTarif();
				comboBoxTD.addItem(id + " : " + libelle);
			}
			comboBoxTD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					indexCbx = comboBoxTD.getSelectedIndex();
					if(indexCbx != -1){
						afficheTarifActuel(indexCbx);
					}
				}
			});
		}
		return comboBoxTD;
	}
	private JTextField getTextTActuel() {
		if (textTActuel == null) {
			textTActuel = new JTextField();
			textTActuel.setBounds(169, 113, 108, 20);
			textTActuel.setColumns(10);
		}
		return textTActuel;
	}
	private JTextField getTextTNouveau() {
		if (textTNouveau == null) {
			textTNouveau = new JTextField();
			textTNouveau.setBounds(169, 160, 108, 20);
			textTNouveau.setColumns(10);
		}
		return textTNouveau;
	}
	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						nouveauTarif = Double.parseDouble(textTNouveau.getText());
						typeD = listeTD.get(comboBoxTD.getSelectedIndex());
						typeD.setTarif(nouveauTarif);
						if(AccesData.updateTarif(typeD)){
							JOptionPane.showMessageDialog(null,"Tarif mis à jour");
							textTNouveau.setText("");
							afficheTarifActuel(indexCbx);
						}
						else{
							JOptionPane.showMessageDialog(null,"Erreur mise à jour tarif");
							textTNouveau.requestFocus();
						}
					} catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(null,"Le tarif doit être un nombre");
						textTNouveau.setText("");
						textTNouveau.requestFocus();
					}
				}
			});
			btnValider.setBounds(94, 236, 89, 23);
		}
		return btnValider;
	}
	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textTNouveau.setText("");
					comboBoxTD.requestFocus();
				}
			});
			btnAnnuler.setBounds(246, 236, 89, 23);
		}
		return btnAnnuler;
	}
	public void afficheTarifActuel(int index){
		textTActuel.setText(String.valueOf(listeTD.get(indexCbx).getTarif()));
	}
}
