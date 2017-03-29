package com.vue;

import javax.swing.table.AbstractTableModel;
import java.util.*;
import com.metier.*;
import com.persistance.AccesData;

public class ModelData extends AbstractTableModel {
	private String[] entetes = { "idHabitation", "Adresse Rue", "Code Postal", "Adresse Ville", "Nombre de poubellles"};
	private List<Habitation> listehabiattion;

	public ModelData(String idUsager) {
		listehabiattion = AccesData.getLesHabitationsUsager(idUsager);
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		return listehabiattion.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int ColumnIndex) {
		switch (ColumnIndex) {
		case 0:
			return listehabiattion.get(rowIndex).getIdHabitation();
		case 1:
		return listehabiattion.get(rowIndex).getAdrRueHab();
		case 2:
			return listehabiattion.get(rowIndex).getCpHab();
		case 3:
		return listehabiattion.get(rowIndex).getAdrVilleHab();
		case 4:
			return listehabiattion.get(rowIndex).getCountLesPoubelles();
			
		default:
			throw new IllegalArgumentException();
		}
	}
	@Override
	public String getColumnName(int ColumnIndex) {
		return entetes[ColumnIndex];
	}
}
