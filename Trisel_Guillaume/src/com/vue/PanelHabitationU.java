package com.vue;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;

import com.metier.Usager;
import com.persistance.AccesData;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PanelHabitationU extends JPanel {
	private JLabel lblNewLabel;
	
	private String idUsag;
	private String nomUsag;
	private String prenomUsag;
	private JComboBox comboBox;
	private int indexComboBox;
	private String idUsager;
	private JScrollPane scrollPane;
	private JTable table;
	private ModelData modele;
	private List<Usager> listU;

	/**
	 * Create the panel.
	 */
	public PanelHabitationU() {
		listU = AccesData.getLesUsagers();
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
		add(getComboBox());
		
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("S\u00E9lectionner un usager :");
			lblNewLabel.setBounds(22, 50, 162, 14);
		}
		return lblNewLabel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			for(Usager usag : listU){
				idUsag = usag.getIdUsager();
				nomUsag = usag.getNom();
				prenomUsag = usag.getPrenom();
				comboBox.addItem(idUsag + "-" + nomUsag + " " + prenomUsag);
			}
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					indexComboBox = comboBox.getSelectedIndex();
					if(indexComboBox != -1){
						modele = new ModelData(listU.get(indexComboBox).getIdUsager());
						table.setModel(modele);
						if (AccesData.getLesHabitationsUsager(listU.get(indexComboBox).getIdUsager()).size() == 0){
							JOptionPane.showMessageDialog(null,"Aucune(s) Habitation");
						}
						table.revalidate();
					}
				}
			});
			comboBox.setSelectedIndex(0);
			comboBox.setBounds(168, 47, 171, 20);
		}
		return comboBox;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 98, 418, 162);
			scrollPane.setColumnHeaderView(getTable());
			scrollPane.setViewportView(table);
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
}
