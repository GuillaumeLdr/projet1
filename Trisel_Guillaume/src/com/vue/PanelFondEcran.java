package com.vue;

import javax.swing.JPanel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import com.metier.*;

public class PanelFondEcran extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelFondEcran(String nomUtilisateur) {
		setForeground(Color.WHITE);
		setBackground(Color.CYAN);
		setLayout(null);
		JLabel lblBienvenueSurTrisel = new JLabel("Bienvenue " + nomUtilisateur);
		lblBienvenueSurTrisel.setIcon(new ImageIcon("Trisel.jpg"));
		lblBienvenueSurTrisel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblBienvenueSurTrisel.setBounds(220, 69, 371, 146);
		add(lblBienvenueSurTrisel);
	}

}
