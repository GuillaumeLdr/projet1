package com.vue;

import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import com.pdf.EditionFacturePdf;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class PanelFacture extends JPanel implements PropertyChangeListener{
	private JYearChooser yearChooser;
	private JMonthChooser monthChooser;
	private JButton btnGenrateFacture;
	private int an;
	private int mois;
	private Calendar calendar;

	/**
	 * Create the panel.
	 */
	public PanelFacture() {
		setLayout(null);
		add(getYearChooser());
		add(getMonthChooser());
		add(getBtnGenrateFacture());
		
		// récupération année et mois actuel
		calendar = Calendar.getInstance();
		an = getYear();
		mois  = getMonth() + 1;// + 1 car mois de 0 à 11 et non pas de 1 = 12
	}
	// méthodes utilitaires qui ramène l'année et le mois courant
	public int getYear(){
			return calendar.get(Calendar.YEAR);
	}
	public int getMonth(){
			return calendar.get(Calendar.MONTH);
	}
	private JYearChooser getYearChooser() {
		if (yearChooser == null) {
			yearChooser = new JYearChooser();
			yearChooser.addPropertyChangeListener(this);
			yearChooser.setBounds(124, 27, 47, 20);
		}
	return yearChooser;
	}
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("year")){
			an = (Integer)evt.getNewValue();
		}
		if(evt.getPropertyName().equals("month")){
			mois  = (Integer)evt.getNewValue() + 1;
		}
	}
	private JMonthChooser getMonthChooser() {
		if (monthChooser == null) {
			monthChooser = new JMonthChooser();
			monthChooser.addPropertyChangeListener(this);
			monthChooser.setBounds(17, 27, 97, 20);
		}
		return monthChooser;
	}
	private JButton getBtnGenrateFacture() {
		if (btnGenrateFacture == null) {
			btnGenrateFacture = new JButton("G\u00E9n\u00E9r\u00E9 facture(s)");
			btnGenrateFacture.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EditionFacturePdf.generateFacture(an, mois);
					JOptionPane.showMessageDialog(null,"Création facture effectué");
				}
			});
			btnGenrateFacture.setBounds(124, 125, 158, 23);
		}
		return btnGenrateFacture;
	}
}
