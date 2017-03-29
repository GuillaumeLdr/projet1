package com.vue;

import java.util.*;

import javax.swing.JPanel;

import com.util.InsertionLevee;
import com.util.Parametre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLevee extends JPanel {
	private JLabel lblNewLabel;
	private JButton btnLancer;

	/**
	 * Create the panel.
	 */
	public PanelLevee() {
		setLayout(null);
		add(getLblNewLabel());
		add(getBtnLancer());
		
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Il y a "+ Parametre.nbLevee() +" fichier(s) \u00E0 traiter");
			lblNewLabel.setBounds(136, 11, 168, 14);
		}
		return lblNewLabel;
	}
	private JButton getBtnLancer() {
		if (btnLancer == null) {
			btnLancer = new JButton("lancer");
			btnLancer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					InsertionLevee.TraitementLevee();
					afficheMessage("Mise à jour effectuée");
				}
			});
			btnLancer.setBounds(161, 66, 89, 23);
			// désactivation du bouton si pas de fichier à traiter
			if (Parametre.nbLevee() == 0) {
				btnLancer.setEnabled(false);
			}
		}
		return btnLancer;
	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
}
