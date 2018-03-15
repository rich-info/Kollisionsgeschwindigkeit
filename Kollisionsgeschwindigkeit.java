import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.plaf.DesktopIconUI;

import org.omg.CORBA.TIMEOUT;
import org.w3c.dom.UserDataHandler;

public class Kollisionsgeschwindigkeit extends JFrame {


	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JMenuBar jJMenuBar = null;

	private JMenu jMenuDatei = null;

	private JMenu Hilfe = null;

	private JMenuItem jMenuItemBeenden = null;

	private JMenuItem jMenuItemHilfe = null;

	private JMenuItem jMenuItemInfo = null;
	
	private JButton jButtonBerechnen = null;

	private JButton jButtonNeu = null;
	
	
	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenuDatei());
			jJMenuBar.add(getHilfe());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenuDatei	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuDatei() {
		if (jMenuDatei == null) {
			jMenuDatei = new JMenu();
			jMenuDatei.setText("Datei");
			jMenuDatei.add(getJMenuItemBeenden());
		}
		return jMenuDatei;
	}

	/**
	 * This method initializes Hilfe	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHilfe() {
		if (Hilfe == null) {
			Hilfe = new JMenu();
			Hilfe.setText("Hilfe");
			Hilfe.add(getJMenuItemHilfe());
			Hilfe.add(getJMenuItemInfo());
		}
		return Hilfe;
	}

	/**
	 * This method initializes jMenuItemBeenden	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemBeenden() {
		if (jMenuItemBeenden == null) {
			jMenuItemBeenden = new JMenuItem("Beenden");
			
			jMenuItemBeenden.addActionListener(exitAction);
			
		}
		return jMenuItemBeenden;
	}
	

	/**
	 * This method initializes jMenuItemHilfe	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemHilfe() {
		if (jMenuItemHilfe == null) {
			jMenuItemHilfe = new JMenuItem("Hilfe anzeigen");
			
			jMenuItemHilfe.addActionListener(hilfeAnzeigenAction);
		}
		return jMenuItemHilfe;
	}

	/**
	 * This method initializes jMenuItemInfo	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemInfo() {
		if (jMenuItemInfo == null) {
			jMenuItemInfo = new JMenuItem("Info");
			
			jMenuItemInfo.addActionListener(infoAction);
		}
		return jMenuItemInfo;
	}
	
	Action exitAction = new AbstractAction() { 
		  public void actionPerformed( ActionEvent e ) { 
		    System.exit( 0 );  //  @jve:decl-index=0:
		  } 
	};
		
	Action infoAction = new AbstractAction() { 
		public void actionPerformed( ActionEvent e ) { 
			 JOptionPane.showMessageDialog( null, "Kollisionsgeschwindigkeits- und Bremswegberechnung. \n\nCopyright (c) 2007 Ridvan Chasan. \ninfo@rich-informatik.de", "About", JOptionPane.INFORMATION_MESSAGE);  //  @jve:decl-index=0:
			
		} 
	};
	
	
	Action hilfeAnzeigenAction = new AbstractAction() { 
		public void actionPerformed( ActionEvent e ) { 
			//try {
				 displayURL("help.html");
				//Runtime.getRuntime().exec("cmd /c start "+fileLocation);
				//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"javascript:lacation.href='file://help.html'");
				//} catch( IOException ex) {
				//  ex.printStackTrace();
				//}
				
		} 
	};
	
	private JPanel jPanelGeschwindigkeit = null;

	private JLabel jLabelGeschdigkeit = null; 
	
	private JLabel jLabelVerzoegerung = null;

	private JTextField jTextFieldGeschwindigkeit = null;

	private JTextField jTextFieldVerzoegerung = null;
	
	private JTextField jTextFieldKollisionsgeschwindigkeit = null;

	private JLabel jLabelVerzoegerungEinheit = null;

	private JComboBox jComboBoxGeschwindigkeitEinheit = null;
	
	private JLabel jLabelKollisionsgeschwindigkeit = null;

	private JComboBox jComboBoxKollisionsgeschwindigkeitEinheit = null;

	private JLabel jLabelBremsweg = null;

	private JTextField jTextFieldBremsweg = null;

	private JLabel jLabelBremswegEinheit = null;

	private JPanel jPanelVorbremszeit = null;

	private JRadioButton jRadioButtonVorbremszeit1s = null;

	private JRadioButton jRadioButtonVorbremszeit2 = null;

	private JLabel jLabelReaktionszeit = null;

	private JLabel jLabelAnsprechzeit = null;

	private JTextField jTextFieldReaktionszeit = null;

	private JTextField jTextFieldAnsprechzeit = null;

	private JLabel jLabelSek = null;

	private JLabel jLabelSek2 = null;

	private JPanel jPanelAusgabe = null;

	private JLabel jLabelKollison = null;

	private JLabel jLabelSpurbeginn = null;

	private JLabel jLabelBremsbeginn = null;

	private JLabel jLabelGefahrmoment = null;

	private JLabel jLabelGesamt = null;

	private JLabel jLabelStecke = null;

	private JLabel jLabelZeit = null;

	private JLabel jLabelGeschwindigkeit = null;

	private JLabel jLabelKollisionStrecke = null;

	private JLabel jLabelKollisionZeit = null;

	private JLabel jLabelKollisionkmh = null;

	private JLabel jLabelSpurbeginnStrecke = null;

	private JLabel jLabelSpurbeginnZeit = null;

	private JLabel jLabelSpurbeginnkmh = null;

	private JLabel jLabelBremsbeginnStrecke = null;

	private JLabel jLabelBremsbeginnZeit = null;

	private JLabel jLabelBremsbeginnkmh = null;

	private JLabel jLabelGefahrStrecke = null;

	private JLabel jLabelGefahrZeit = null;

	private JLabel jLabelGefahrkmh = null;

	private JLabel jLabelGesamtZeit = null;

	private JLabel jLabelGesamtStrecke = null;

	
	/**
	 * This method initializes jPanelGeschwindigkeit	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelGeschwindigkeit() {
		if (jPanelGeschwindigkeit == null) {
			
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 3;
			gridBagConstraints15.gridy = 0;
			gridBagConstraints15.gridheight = 3;
			gridBagConstraints15.insets = new Insets(0,6,0,0);
			
			jLabelInfoFrei = new JLabel();
			jLabelInfoFrei.setText("<html>Die zu berechnende Größe<br>freilassen.</html>");
			
			GridBagConstraints gbcBremsweg2 = new GridBagConstraints();
			gbcBremsweg2.gridx = 2;
			gbcBremsweg2.gridy = 2;
			gbcBremsweg2.anchor = gbcBremsweg2.WEST;
			
			jLabelBremswegEinheit = new JLabel();
			jLabelBremswegEinheit.setText("m");
			
			GridBagConstraints gbcBremsweg1 = new GridBagConstraints();
			gbcBremsweg1.fill = GridBagConstraints.VERTICAL;
			gbcBremsweg1.gridy = 2;
			gbcBremsweg1.weightx = 1.0;
			gbcBremsweg1.gridx = 1;
			
			GridBagConstraints gbcBremsweg = new GridBagConstraints();
			gbcBremsweg.gridx = 0;
			gbcBremsweg.gridy = 2;
			gbcBremsweg.anchor = gbcBremsweg.WEST;
			
			jLabelBremsweg = new JLabel();
			jLabelBremsweg.setText("Bremsweg");
			
			GridBagConstraints gbcKollisionCombo = new GridBagConstraints();
			gbcKollisionCombo.fill = GridBagConstraints.VERTICAL;
			gbcKollisionCombo.gridy = 1;
			gbcKollisionCombo.weightx = 1.0;
			gbcKollisionCombo.gridx = 2;
			
			GridBagConstraints gbcKollision = new GridBagConstraints();
			gbcKollision.fill = GridBagConstraints.VERTICAL;
			gbcKollision.gridy = 1;
			gbcKollision.weightx = 1.0;
			gbcKollision.gridx = 1;
			
			GridBagConstraints gbcKollision1 = new GridBagConstraints();
			gbcKollision1.gridx = 0;
			gbcKollision1.gridy = 1;
			
			GridBagConstraints gbcGeschwindigkeitCombo = new GridBagConstraints();
			gbcGeschwindigkeitCombo.fill = GridBagConstraints.VERTICAL;
			gbcGeschwindigkeitCombo.gridy = 0;
			gbcGeschwindigkeitCombo.weightx = 1.0;
			gbcGeschwindigkeitCombo.gridx = 2;
			gbcGeschwindigkeitCombo.anchor = gbcGeschwindigkeitCombo.WEST;
			
			GridBagConstraints gbcVerzoegerung2 = new GridBagConstraints();
			gbcVerzoegerung2.gridx = 2;
			gbcVerzoegerung2.gridy = 3;
			gbcVerzoegerung2.anchor = gbcVerzoegerung2.WEST;
			
			jLabelVerzoegerungEinheit = new JLabel();
			jLabelVerzoegerungEinheit.setText("m / s^2");
			
			GridBagConstraints gbcVerzoegerungTextfield = new GridBagConstraints();
			gbcVerzoegerungTextfield.fill = GridBagConstraints.VERTICAL;
			gbcVerzoegerungTextfield.gridy = 3;
			gbcVerzoegerungTextfield.weightx = 1.0;
			gbcVerzoegerungTextfield.gridx = 1;
			gbcVerzoegerungTextfield.insets = new Insets(2,4,2,4);
			
			GridBagConstraints gbcGeschwindigkeitTextfield = new GridBagConstraints();
			gbcGeschwindigkeitTextfield.fill = GridBagConstraints.VERTICAL;
			gbcGeschwindigkeitTextfield.gridy = 0;
			gbcGeschwindigkeitTextfield.weightx = 1.0;
			gbcGeschwindigkeitTextfield.gridx = 1;
			gbcGeschwindigkeitTextfield.insets = new Insets(2,4,2,4);
			
			GridBagConstraints gbcGeschwindigkeit = new GridBagConstraints();
			gbcGeschwindigkeit.gridx = 0;
			gbcGeschwindigkeit.gridy = 0;
			gbcGeschwindigkeit.anchor = gbcGeschwindigkeit.WEST;
			//gbcGeschwindigkeit.anchor = gbcGeschwindigkeit.NORTHWEST;
			//gbcGeschwindigkeit.insets = new Insets(2,1,2,1);
			
			jLabelGeschdigkeit = new JLabel();
			jLabelGeschdigkeit.setText("Geschwindigkeit:");
			
			GridBagConstraints gbcVerzoegerung = new GridBagConstraints();
			gbcVerzoegerung.gridx = 0;
			gbcVerzoegerung.gridy = 3;
			gbcVerzoegerung.anchor = gbcVerzoegerung.WEST;
			//gbcVerzoegerung.anchor = gbcVerzoegerung.NORTHWEST;
			//gbcVerzoegerung.insets = new Insets(2,1,2,1);
			
			
			jLabelVerzoegerung = new JLabel();
			jLabelVerzoegerung.setText("Verzögerung:");
			
			jLabelKollisionsgeschwindigkeit = new JLabel();
			jLabelKollisionsgeschwindigkeit.setText("Kollisionsgeschwindigkeit:");
			
			jPanelGeschwindigkeit = new JPanel();
			jPanelGeschwindigkeit.setLayout(new GridBagLayout());
			jPanelGeschwindigkeit.add(jLabelGeschdigkeit, gbcGeschwindigkeit);
			jPanelGeschwindigkeit.add(jLabelVerzoegerung, gbcVerzoegerung);
			jPanelGeschwindigkeit.add(getJTextFieldGeschwindigkeit(), gbcGeschwindigkeitTextfield);
			jPanelGeschwindigkeit.add(getJTextFieldVerzoegerung(), gbcVerzoegerungTextfield);
			jPanelGeschwindigkeit.add(jLabelVerzoegerungEinheit, gbcVerzoegerung2);
			jPanelGeschwindigkeit.add(getJComboBoxGeschwindigkeitEinheit(), gbcGeschwindigkeitCombo);
			jPanelGeschwindigkeit.add(jLabelKollisionsgeschwindigkeit, gbcKollision1);
			jPanelGeschwindigkeit.add(getJTextFieldKollisionsgeschwindigkeit(), gbcKollision);
			jPanelGeschwindigkeit.add(getJComboBoxKollisionsgeschwindigkeitEinheit(), gbcKollisionCombo);
			jPanelGeschwindigkeit.add(jLabelBremsweg, gbcBremsweg);
			jPanelGeschwindigkeit.add(getJTextFieldBremsweg(), gbcBremsweg1);
			jPanelGeschwindigkeit.add(jLabelBremswegEinheit, gbcBremsweg2);
			jPanelGeschwindigkeit.add(jLabelInfoFrei, gridBagConstraints15);
			
			
			
			
		}
		return jPanelGeschwindigkeit;
	}

	/**
	 * This method initializes jTextFieldGeschwindigkeit	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldGeschwindigkeit() {
		if (jTextFieldGeschwindigkeit == null) {
			jTextFieldGeschwindigkeit = new JTextField();
			jTextFieldGeschwindigkeit.setPreferredSize(new Dimension(50, 22));
			
			/*
			jTextFieldGeschwindigkeit.addActionListener( new ActionListener() { 
		        public void actionPerformed( ActionEvent e ) { 
		        	if (jTextFieldGeschwindigkeit.getText() != "") {
			          jLabelGefahrkmh.setText(jTextFieldGeschwindigkeit.getText());
		        	}
			        } 
			      } );*/
			
		}
		return jTextFieldGeschwindigkeit;
	}

	/**
	 * This method initializes jTextFieldVerzoegerung	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldVerzoegerung() {
		if (jTextFieldVerzoegerung == null) {
			jTextFieldVerzoegerung = new JTextField();
			jTextFieldVerzoegerung.setPreferredSize(new Dimension(50, 22));
			
			jTextFieldVerzoegerung.setToolTipText("<html>PKW,nasse Fahrbahn     6.0<br>PKW, trockene Fahrbahn  6.5<br>PKW, ABS    7.5</html>");
		}
		return jTextFieldVerzoegerung;
	}

	/**
	 * This method initializes jComboBoxGeschwindigkeitEinheit	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxGeschwindigkeitEinheit() {
		if (jComboBoxGeschwindigkeitEinheit == null) {
			
			String[] einheiten = { "km / h", "m / s"};
			jComboBoxGeschwindigkeitEinheit = new JComboBox(einheiten);
			jComboBoxGeschwindigkeitEinheit.setPreferredSize(new Dimension(110, 27));
			jComboBoxGeschwindigkeitEinheit.setSelectedIndex(0);
			
		}
		return jComboBoxGeschwindigkeitEinheit;
	}
	
	/**
	 * This method initializes jTextFieldKollisionsgeschwindigkeit
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldKollisionsgeschwindigkeit() {
		if (jTextFieldKollisionsgeschwindigkeit == null) {
			jTextFieldKollisionsgeschwindigkeit = new JTextField();
			jTextFieldKollisionsgeschwindigkeit.setPreferredSize(new Dimension(50, 22));
		}
		return jTextFieldKollisionsgeschwindigkeit;
	}
	
	/**
	 * This method initializes jComboBoxKollisionsgeschwindigkeitEinheit	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxKollisionsgeschwindigkeitEinheit() {
		if (jComboBoxKollisionsgeschwindigkeitEinheit == null) {
			
			String[] einheiten2 = { "km / h", "m / s"};
			jComboBoxKollisionsgeschwindigkeitEinheit = new JComboBox(einheiten2);
			jComboBoxKollisionsgeschwindigkeitEinheit.setPreferredSize(new Dimension(110, 27));
			jComboBoxKollisionsgeschwindigkeitEinheit.setSelectedIndex(0);
		}
		return jComboBoxKollisionsgeschwindigkeitEinheit;
	}
	
	
	/**
	 * This method initializes jTextFieldBremsweg	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldBremsweg() {
		if (jTextFieldBremsweg == null) {
			jTextFieldBremsweg = new JTextField();
			jTextFieldBremsweg.setPreferredSize(new Dimension(50, 22));
		}
		return jTextFieldBremsweg;
	}
	

	/**
	 * This method initializes jButtonBerechnen	
	 * 	
	 * @return javax.swing.JButton	
	 */
	
	double kollisionsgeschwindigkeit = 0;
	double geschwindigkeit = 0;
	double bremsweg = 0;
	double verzoegerung = 0;
	double reaktionszeit = 0;
	double bremsansprechzeit = 0;

	private JLabel jLabelInfoFrei = null;
	
	private JButton getJButtonBerechnen() {
		if (jButtonBerechnen == null) {
			jButtonBerechnen = new JButton();
			jButtonBerechnen.setText("Berechnen");
			
			// m/s in kmh umwandeln bevor übergeben
			// ARBEITET mit KMH ----------------
			
			jButtonBerechnen.addActionListener( new ActionListener() { 
		        public void actionPerformed( ActionEvent e ) { 
		        	
		        	DecimalFormat df = new DecimalFormat( "0.00" );
		        	
		        	// Alle 3 Größen dürfen nicht eingegeben sein. Eine Größe muss leer sein, um berechnet zu werden.
		        	if (!getJTextFieldKollisionsgeschwindigkeit().getText().equals("") && !getJTextFieldGeschwindigkeit().getText().equals("") && !getJTextFieldBremsweg().getText().equals("")) {
		        		
		        		JOptionPane.showMessageDialog( null, "Bitte die zu berechnende Größe freilassen. \nSie können die (Ausgangs-)Geschwindigkeit, die Kollisionsgeschwindigkeit, \noder den Bremsweg berechnen lassen. \nDer zu berechnende Wert muss freigelassen werden.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
						return;
		        	}
		        	
		        	
		        	 // Falls nur eine Größe definiert wurde, Fehlermeldung (unvollständige Eingabe) ausgeben. Benötigt werden 2 Größen.
		        	
		        	if (getJTextFieldKollisionsgeschwindigkeit().getText().equals("") && getJTextFieldGeschwindigkeit().getText().equals("") || getJTextFieldBremsweg().getText().equals("") && getJTextFieldGeschwindigkeit().getText().equals("") || getJTextFieldBremsweg().getText().equals("") && getJTextFieldKollisionsgeschwindigkeit().getText().equals(""))  {
		        		
		        		JOptionPane.showMessageDialog( null, "Eine erforderliche Größe für die Berechnung fehlt. \nSie können die (Ausgangs-)Geschwindigkeit, die Kollisionsgeschwindigkeit, \noder den Bremsweg berechnen lassen. \nDer zu berechnende Wert muss freigelassen werden.", "Unvollständige Eingabe", JOptionPane.ERROR_MESSAGE);
						return;
		        	}
		        	
		        	if (getJTextFieldVerzoegerung().getText().equals("")) {
		        		
		        		JOptionPane.showMessageDialog( null, "Bitte (Brems-)Verzögerung eingeben. Die verschiedenen Werte können Sie unter Hilfe finden.", "Unvollständige Eingabe", JOptionPane.ERROR_MESSAGE);
		        		jTextFieldVerzoegerung.setBackground(Color.yellow);
						return;
		        	}
		        	
		        	
		        	// Geschwindigkeit Feld leer? Dann berechnen.
		        	if (getJTextFieldGeschwindigkeit().getText().equals("") && !getJTextFieldKollisionsgeschwindigkeit().getText().equals("") && !getJTextFieldBremsweg().getText().equals("")) {
		        		
		        		if (!getJTextFieldKollisionsgeschwindigkeit().getText().equals("")) {
			        		
			        		try {
			        			kollisionsgeschwindigkeit = Double.parseDouble(jTextFieldKollisionsgeschwindigkeit.getText());
				        		
				        		if (jComboBoxKollisionsgeschwindigkeitEinheit.getSelectedIndex()==1) {
					        		kollisionsgeschwindigkeit = kollisionsgeschwindigkeit*3.6;
					        		
					        	}
			        			
							} catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Kollisionsgeschwindigkeit.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldKollisionsgeschwindigkeit.setBackground(Color.yellow);
								return;
							}
			        		
			        	}
			        
			        	
			        	if (!getJTextFieldBremsweg().getText().equals("")) {		        		
			        		try {
				        		bremsweg = Double.parseDouble(jTextFieldBremsweg.getText());	
					        	}
			        			
							 catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Bremsweg.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldBremsweg.setBackground(Color.yellow);
								return;
							}
			        		
			        	}
			        
			        	if (!getJTextFieldVerzoegerung().getText().equals("")) {		        		
			        		try {
				        		verzoegerung = Double.parseDouble(jTextFieldVerzoegerung.getText());	
					        	}
			        			
							 catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Verzögerung.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldVerzoegerung.setBackground(Color.yellow);
								return;
								
							}
			        		
			        	}
			        	
			        	// Vorbremszeit von 1 Sekunde ohne Bremsverzögerung berücksichtigen.
			        	// Geschwindigkeit leer.
			        	if (getJRadioButtonVorbremszeit1s().isSelected()) {
			        		
					        getJTextFieldGeschwindigkeit().setBackground(Color.white);
					        getJTextFieldKollisionsgeschwindigkeit().setBackground(Color.white);
					        getJTextFieldBremsweg().setBackground(Color.white);
					        getJTextFieldVerzoegerung().setBackground(Color.white);
			        		    
				        	double ausgangsgeschwindigkeit = calcAusgangsgeschwindigkeit(verzoegerung, bremsweg, kollisionsgeschwindigkeit);
					        jTextFieldGeschwindigkeit.setText(String.valueOf(df.format(ausgangsgeschwindigkeit)));
					        jTextFieldGeschwindigkeit.setForeground(Color.blue);
					        
				        	jLabelSpurbeginnkmh.setText(String.valueOf(df.format(ausgangsgeschwindigkeit)));
				        	jLabelSpurbeginnkmh.setForeground(Color.blue);
				        	
					        jLabelKollisionkmh.setText(String.valueOf(df.format(kollisionsgeschwindigkeit)));
					        
					        double zeit = calcZeitKollision(ausgangsgeschwindigkeit, bremsweg, kollisionsgeschwindigkeit);
					        jLabelKollisionZeit.setText(String.valueOf(df.format(zeit)));
				        	jLabelKollisionZeit.setForeground(Color.blue); 
				        	
				        	jLabelKollisionStrecke.setText(String.valueOf(df.format(bremsweg)));
				        	
				        	jLabelGefahrkmh.setText(String.valueOf(df.format(ausgangsgeschwindigkeit)));
				        	jLabelGefahrkmh.setForeground(Color.blue);
				        	
				        	jLabelBremsbeginn.setVisible(false);
				        	
				        	jLabelBremsbeginnStrecke.setText(String.valueOf(df.format(ausgangsgeschwindigkeit/3.6)));
				        	jLabelBremsbeginnStrecke.setForeground(Color.blue);
				        	jLabelBremsbeginnZeit.setText("1.0");
				        	
				        	double strecke = bremsweg;
				        	double strecke2 = ausgangsgeschwindigkeit/3.6;
				        	double streckeGesamt = strecke+strecke2;
				        	
				        	jLabelGesamtStrecke.setText(String.valueOf(df.format(streckeGesamt)));
				        	jLabelGesamtStrecke.setForeground(Color.blue);
				        	
				        	jLabelGesamtZeit.setText(String.valueOf(df.format((zeit)+1)));
				        	jLabelGesamtZeit.setForeground(Color.blue);
				        	        
			        	}
			        	
			        	// Vorbremszeit selber definieren, indem Reaktionszeit und Bremsansprechzeit selber festlegen.
			        	// Dazu muss Reaktionsweg ausgelesen werden -> keine Bremsverzögerung.
			        	// Bremsansprechzeit -> Bremsverzögerung ist Hälfte von der Verzögerung.
			        	// Geschwindigkeit leer.
			        	if (getJRadioButtonVorbremszeit2().isSelected()) {
			        		
			        		try {
				        		reaktionszeit = Double.parseDouble(jTextFieldReaktionszeit.getText());	
					        	}
			        			
							 catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Reaktionszeit.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldReaktionszeit.setBackground(Color.yellow);
								return;
							}
							
				        	try {
					       		bremsansprechzeit = Double.parseDouble(jTextFieldAnsprechzeit.getText());	
						       	}
				        			
							 catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Bremsansprechzeit.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldAnsprechzeit.setBackground(Color.yellow);
								return;
							}
							 
					        getJTextFieldGeschwindigkeit().setBackground(Color.white);
					        getJTextFieldKollisionsgeschwindigkeit().setBackground(Color.white);
					        getJTextFieldBremsweg().setBackground(Color.white);
					        getJTextFieldVerzoegerung().setBackground(Color.white);
		        		    
							jLabelBremsbeginn.setVisible(true);
							 
				        	double ausgangsgeschwindigkeit = calcAusgangsgeschwindigkeit(verzoegerung, bremsweg, kollisionsgeschwindigkeit);
					        					        
					        jLabelKollisionkmh.setText(getJTextFieldKollisionsgeschwindigkeit().getText());
					        
					        double zeit = calcZeitKollision(ausgangsgeschwindigkeit, bremsweg, kollisionsgeschwindigkeit);
					        
					        jLabelKollisionZeit.setText(String.valueOf(df.format(zeit)));
				        	jLabelKollisionZeit.setForeground(Color.blue); 
				        	
				        	jLabelKollisionStrecke.setText(String.valueOf(df.format(bremsweg)));
				        	
				        	jLabelSpurbeginnkmh.setText(String.valueOf(df.format(ausgangsgeschwindigkeit)));
				        	jLabelSpurbeginnkmh.setForeground(Color.blue);
				        					        	
				        	double bremsbeginnkmh = ((verzoegerung/2)*3.6*bremsansprechzeit)+ausgangsgeschwindigkeit;
				        	
				        	jLabelBremsbeginnkmh.setText(String.valueOf(df.format(bremsbeginnkmh)));
				        	jLabelBremsbeginnkmh.setForeground(Color.blue);				        	
				        	
				        	double bremsbeginnStrecke = calcBremsweg(bremsbeginnkmh, (verzoegerung/2), ausgangsgeschwindigkeit);
				        	
				        	jLabelBremsbeginnStrecke.setText(String.valueOf(df.format(bremsbeginnStrecke)));
				        	jLabelBremsbeginnStrecke.setForeground(Color.blue);
				        	jLabelBremsbeginnZeit.setText(String.valueOf(df.format(bremsansprechzeit)));
				        	
				        	jLabelGefahrkmh.setText(String.valueOf(df.format(bremsbeginnkmh)));
				        	jLabelGefahrkmh.setForeground(Color.blue);
				        	
				        	jLabelGefahrZeit.setText(String.valueOf(df.format(reaktionszeit)));
				        	
				        	double reaktionsweg = (bremsbeginnkmh/3.6)*reaktionszeit;
				        	
				        	jLabelGefahrStrecke.setText(String.valueOf(df.format(reaktionsweg)));
				        	jLabelGefahrStrecke.setForeground(Color.blue);
				        	
				        	double gesamtStrecke = bremsweg+bremsbeginnStrecke+reaktionsweg;
				        	
				        	jLabelGesamtStrecke.setText(String.valueOf(df.format(gesamtStrecke)));
				        	jLabelGesamtStrecke.setForeground(Color.blue);
				        	
				        	double gesamtZeit = zeit+reaktionszeit+bremsansprechzeit;
				        	
				        	jLabelGesamtZeit.setText(String.valueOf(df.format(gesamtZeit)));
				        	jLabelGesamtZeit.setForeground(Color.blue);
				        	
				        	jTextFieldGeschwindigkeit.setText(String.valueOf(df.format(bremsbeginnkmh)));
					        jTextFieldGeschwindigkeit.setForeground(Color.blue);
				        	        
			        	}
		        		
		        	}
		        	
		        	
		        	// Kollisionsgeschwindigkeit Feld leer? Dann berechnen.
		        	if (!getJTextFieldGeschwindigkeit().getText().equals("") && getJTextFieldKollisionsgeschwindigkeit().getText().equals("") && !getJTextFieldBremsweg().getText().equals("")) {
		        		

			        	if (!getJTextFieldGeschwindigkeit().getText().equals("")) {		        		
			        		try {
				        		geschwindigkeit = Double.parseDouble(jTextFieldGeschwindigkeit.getText());
				        		
				        		if (jComboBoxKollisionsgeschwindigkeitEinheit.getSelectedIndex()==1) {
					        		geschwindigkeit = geschwindigkeit*3.6;	
					        	}
			        			
							} catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Geschwindigkeit.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldGeschwindigkeit.setBackground(Color.yellow);
								return;
							}
			        		
			        	}
			        	
			        	
			        	if (!getJTextFieldBremsweg().getText().equals("")) {		        		
			        		try {
				        		bremsweg = Double.parseDouble(jTextFieldBremsweg.getText());	
					        	}
			        			
							 catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Bremsweg.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldBremsweg.setBackground(Color.yellow);
								return;
							}
			        		
			        	}
			        
			        	if (!getJTextFieldVerzoegerung().getText().equals("")) {		        		
			        		try {
				        		verzoegerung = Double.parseDouble(jTextFieldVerzoegerung.getText());	
					        	}
			        			
							 catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Verzögerung.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldVerzoegerung.setBackground(Color.yellow);
								return;
								
							}
			        		
			        	}
			        	
			        	// Vorbremszeit von 1 Sekunde ohne Bremsverzögerung berücksichtigen.
			        	// Kollisionsgeschwindigkeit leer.
			        	if (getJRadioButtonVorbremszeit1s().isSelected()) {
			        		
					        getJTextFieldGeschwindigkeit().setBackground(Color.white);
					        getJTextFieldKollisionsgeschwindigkeit().setBackground(Color.white);
					        getJTextFieldBremsweg().setBackground(Color.white);
					        getJTextFieldVerzoegerung().setBackground(Color.white);
			        		    
				        	double kollisionsgeschwindigkeit = calcKollisionsgeschwindigkeit(verzoegerung, bremsweg, geschwindigkeit);
					        jTextFieldGeschwindigkeit.setText(String.valueOf(df.format(geschwindigkeit)));
					        jTextFieldGeschwindigkeit.setForeground(Color.blue);
					        
				        	jLabelSpurbeginnkmh.setText(String.valueOf(df.format(geschwindigkeit)));
				        	jLabelSpurbeginnkmh.setForeground(Color.blue);
				        	
					        jLabelKollisionkmh.setText(String.valueOf(df.format(kollisionsgeschwindigkeit)));
					        
					        double zeit = calcZeitKollision(geschwindigkeit, bremsweg, kollisionsgeschwindigkeit);
					        jLabelKollisionZeit.setText(String.valueOf(df.format(zeit)));
				        	jLabelKollisionZeit.setForeground(Color.blue); 
				        	
				        	jLabelKollisionStrecke.setText(String.valueOf(df.format(bremsweg)));
				        	
				        	jLabelGefahrkmh.setText(String.valueOf(df.format(geschwindigkeit)));
				        	jLabelGefahrkmh.setForeground(Color.blue);
				        	
				        	jLabelBremsbeginn.setVisible(false);
				        	
				        	jLabelBremsbeginnStrecke.setText(String.valueOf(df.format(geschwindigkeit/3.6)));
				        	jLabelBremsbeginnZeit.setText("1.0");
				        	
				        	double strecke = Double.parseDouble(jLabelKollisionStrecke.getText());
				        	double strecke2 = geschwindigkeit/3.6;
				        	double streckeGesamt = strecke+strecke2;
				        	
				        	jLabelGesamtStrecke.setText(String.valueOf(df.format(streckeGesamt)));
				        	jLabelGesamtStrecke.setForeground(Color.blue);
				        	
				        	jLabelGesamtZeit.setText(String.valueOf(df.format(zeit)+1));
				        	jLabelGesamtZeit.setForeground(Color.blue);
				        	        
			        	}
			        	
			        	// Vorbremszeit selber definieren, indem Reaktionszeit und Bremsansprechzeit selber festlegen.
			        	// Dazu muss Reaktionsweg ausgelesen werden -> keine Bremsverzögerung.
			        	// Bremsansprechzeit -> Bremsverzögerung ist Hälfte von der Verzögerung.
			        	// Kollisonsgeschwindigkeit leer.
			        	if (getJRadioButtonVorbremszeit2().isSelected()) {
			        		
			        		try {
				        		reaktionszeit = Double.parseDouble(jTextFieldReaktionszeit.getText());	
					        	}
			        			
							 catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Reaktionszeit.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldReaktionszeit.setBackground(Color.yellow);
								return;
							}
							
				        	try {
					       		bremsansprechzeit = Double.parseDouble(jTextFieldAnsprechzeit.getText());	
						       	}
				        			
							 catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Bremsansprechzeit.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldAnsprechzeit.setBackground(Color.yellow);
								return;
							}
							 
					        getJTextFieldGeschwindigkeit().setBackground(Color.white);
					        getJTextFieldKollisionsgeschwindigkeit().setBackground(Color.white);
					        getJTextFieldBremsweg().setBackground(Color.white);
					        getJTextFieldVerzoegerung().setBackground(Color.white);
		        		    
							jLabelBremsbeginn.setVisible(true);
							
							jLabelGefahrkmh.setText(String.valueOf(df.format(geschwindigkeit)));
				        	
				        	jLabelGefahrZeit.setText(String.valueOf(df.format(reaktionszeit)));
				        	
				        	double reaktionsweg = (geschwindigkeit/3.6)*reaktionszeit;
				        	
				        	jLabelGefahrStrecke.setText(String.valueOf(df.format(reaktionsweg)));
				        	jLabelGefahrStrecke.setForeground(Color.blue);
				        	
				        	//double bremsbeginnkmh = ((verzoegerung/2)*3.6*bremsansprechzeit)+geschwindigkeit;
				        	
				        	jLabelBremsbeginnkmh.setText(String.valueOf(df.format(geschwindigkeit)));	
				        	
				        	jLabelBremsbeginnZeit.setText(String.valueOf(df.format(bremsansprechzeit)));
				        	
				        	double spurbeginnkmh = ((geschwindigkeit/3.6)-(bremsansprechzeit*(verzoegerung/2)))*3.6;
				        	
				        	jLabelSpurbeginnkmh.setText(String.valueOf(df.format(spurbeginnkmh)));
				        	jLabelSpurbeginnkmh.setForeground(Color.blue);
				        	
				        	double bremsbeginnStrecke = calcBremsweg(geschwindigkeit, (verzoegerung/2), spurbeginnkmh);
				        	
				        	jLabelBremsbeginnStrecke.setText(String.valueOf(df.format(bremsbeginnStrecke)));
				        	jLabelBremsbeginnStrecke.setForeground(Color.blue);
							 
				        	double kollisionsgeschwindigkeit = calcKollisionsgeschwindigkeit(verzoegerung, bremsweg, spurbeginnkmh);
					        					        
					        jLabelKollisionkmh.setText(String.valueOf(df.format(kollisionsgeschwindigkeit)));
					        jLabelKollisionkmh.setForeground(Color.blue);
					        
					        double zeit = calcZeitKollision(geschwindigkeit, bremsweg, kollisionsgeschwindigkeit);
					        
					        jLabelKollisionZeit.setText(String.valueOf(df.format(zeit)));
				        	jLabelKollisionZeit.setForeground(Color.blue); 
				        	
				        	jLabelKollisionStrecke.setText(String.valueOf(df.format(bremsweg)));

				        	double gesamtStrecke = bremsweg+bremsbeginnStrecke+reaktionsweg;
				        	
				        	jLabelGesamtStrecke.setText(String.valueOf(df.format(gesamtStrecke)));
				        	jLabelGesamtStrecke.setForeground(Color.blue);
				        	
				        	double gesamtZeit = zeit+reaktionszeit+bremsansprechzeit;
				        	
				        	jLabelGesamtZeit.setText(String.valueOf(df.format(gesamtZeit)));
				        	jLabelGesamtZeit.setForeground(Color.blue);
				        	
				        	jTextFieldKollisionsgeschwindigkeit.setText(String.valueOf(df.format(kollisionsgeschwindigkeit)));
					        jTextFieldKollisionsgeschwindigkeit.setForeground(Color.blue);
				        	        
			        	}
		        		
		        	}
		        	
		        	
		        	// Bremsweg Feld leer? Dann berechnen.
		        	if (getJTextFieldBremsweg().getText().equals("") && !getJTextFieldKollisionsgeschwindigkeit().getText().equals("") && !getJTextFieldGeschwindigkeit().getText().equals("")) {
		        		
		        		if (!getJTextFieldKollisionsgeschwindigkeit().getText().equals("")) {
			        		
			        		try {
			        			kollisionsgeschwindigkeit = Double.parseDouble(jTextFieldKollisionsgeschwindigkeit.getText());
				        		
				        		if (jComboBoxKollisionsgeschwindigkeitEinheit.getSelectedIndex()==1) {
					        		kollisionsgeschwindigkeit = kollisionsgeschwindigkeit*3.6;
					        		
					        	}
			        			
							} catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Kollisionsgeschwindigkeit.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldKollisionsgeschwindigkeit.setBackground(Color.yellow);
								return;
							}
			        		
			        	}
			        	
			        	
			        	if (!getJTextFieldGeschwindigkeit().getText().equals("")) {		        		
			        		try {
				        		geschwindigkeit = Double.parseDouble(jTextFieldGeschwindigkeit.getText());
				        		
				        		if (jComboBoxKollisionsgeschwindigkeitEinheit.getSelectedIndex()==1) {
					        		geschwindigkeit = geschwindigkeit*3.6;	
					        	}
			        			
							} catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Geschwindigkeit.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldGeschwindigkeit.setBackground(Color.yellow);
								return;
							}
			        		
			        	}
			        	
			        
			        	if (!getJTextFieldVerzoegerung().getText().equals("")) {		        		
			        		try {
				        		verzoegerung = Double.parseDouble(jTextFieldVerzoegerung.getText());	
					        	}
			        			
							 catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Verzögerung.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldVerzoegerung.setBackground(Color.yellow);
								return;
								
							}
			        		
			        	}
			        	
			        	if (geschwindigkeit<kollisionsgeschwindigkeit) {
			        		JOptionPane.showMessageDialog( null, "(Ausgangs-)Geschwindigkeit ist größer als Kollisionsgeschwindigkeit. \nEingabe überprüfen.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
			        		return;
			        	}
			        	
			        	// Vorbremszeit von 1 Sekunde ohne Bremsverzögerung berücksichtigen.
			        	// Bremswegfeld leer
			        	if (getJRadioButtonVorbremszeit1s().isSelected()) {

					        getJTextFieldGeschwindigkeit().setBackground(Color.white);
					        getJTextFieldKollisionsgeschwindigkeit().setBackground(Color.white);
					        getJTextFieldBremsweg().setBackground(Color.white);
					        getJTextFieldVerzoegerung().setBackground(Color.white);
					        
					        jLabelBremsbeginn.setVisible(false);
			        		
				        	jLabelSpurbeginnkmh.setText(String.valueOf(df.format(geschwindigkeit)));
				        	
				        	double bremsweg = calcBremsweg(geschwindigkeit, verzoegerung, kollisionsgeschwindigkeit);
				        	
				        	jLabelKollisionStrecke.setText(String.valueOf(df.format(bremsweg)));
				        	jLabelKollisionStrecke.setForeground(Color.blue);
				        	
				        	jTextFieldBremsweg.setText(String.valueOf(df.format(bremsweg)));
				        	jTextFieldBremsweg.setForeground(Color.blue);
				        	
				        	jLabelKollisionkmh.setText(String.valueOf(df.format(kollisionsgeschwindigkeit)));
					        
					        double zeit = calcZeitKollision(geschwindigkeit, bremsweg, kollisionsgeschwindigkeit);
					        
					        jLabelKollisionZeit.setText(String.valueOf(df.format(zeit)));
				        	jLabelKollisionZeit.setForeground(Color.blue); 
				        	
				        	jLabelGefahrkmh.setText(String.valueOf(df.format(geschwindigkeit)));
				        	
				        	jLabelBremsbeginnStrecke.setText(String.valueOf(df.format(geschwindigkeit/3.6)));
				        	jLabelBremsbeginnStrecke.setForeground(Color.blue);
				        	
				        	jLabelBremsbeginnZeit.setText("1.0");
				        	
				        	double strecke = bremsweg;
				        	double strecke2 = geschwindigkeit/3.6;
				        	double streckeGesamt = strecke+strecke2;
				        	
				        	jLabelGesamtStrecke.setText(String.valueOf(df.format(streckeGesamt)));
				        	jLabelGesamtStrecke.setForeground(Color.blue);
				        	
				        	jLabelGesamtZeit.setText(String.valueOf(df.format(zeit+1)));
				        	jLabelGesamtZeit.setForeground(Color.blue);
				        	        
			        	}
			        	
			        	// Vorbremszeit selber definieren, indem Reaktionszeit und Bremsansprechzeit selber festlegen.
			        	// Dazu muss Reaktionsweg ausgelesen werden -> keine Bremsverzögerung.
			        	// Bremsansprechzeit -> Bremsverzögerung ist Hälfte von der Verzögerung.
			        	// Bremswegfeld leer
			        	if (getJRadioButtonVorbremszeit2().isSelected()) {
			        		
			        		try {
				        		reaktionszeit = Double.parseDouble(jTextFieldReaktionszeit.getText());	
					        	}
			        			
							 catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Reaktionszeit.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldReaktionszeit.setBackground(Color.yellow);
								return;
							}
							
				        	try {
					       		bremsansprechzeit = Double.parseDouble(jTextFieldAnsprechzeit.getText());	
						       	}
				        			
							 catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog( null, "Ungültige Eingabe für Bremsansprechzeit.", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
								jTextFieldAnsprechzeit.setBackground(Color.yellow);
								return;
							}
							 
					        getJTextFieldGeschwindigkeit().setBackground(Color.white);
					        getJTextFieldKollisionsgeschwindigkeit().setBackground(Color.white);
					        getJTextFieldBremsweg().setBackground(Color.white);
					        getJTextFieldVerzoegerung().setBackground(Color.white);
		        		    
							jLabelBremsbeginn.setVisible(true);
					        					        
					        jLabelKollisionkmh.setText(String.valueOf(df.format(kollisionsgeschwindigkeit)));
					        
				        	double geschwindigkeitNachAnprechzeit = ((geschwindigkeit/3.6)-(bremsansprechzeit*(verzoegerung/2)))*3.6;
					        
				        	double bremsweg = calcBremsweg(geschwindigkeitNachAnprechzeit, verzoegerung, kollisionsgeschwindigkeit);
				        	
				        	jLabelKollisionStrecke.setText(String.valueOf(df.format(bremsweg)));
				        	jLabelKollisionStrecke.setForeground(Color.blue);
					        
					        double zeit = calcZeitKollision(geschwindigkeit, bremsweg, kollisionsgeschwindigkeit);
					        jLabelKollisionZeit.setText(String.valueOf(df.format(zeit)));
				        	jLabelKollisionZeit.setForeground(Color.blue); 
				        	
				        	jLabelSpurbeginnkmh.setText(String.valueOf(df.format(geschwindigkeitNachAnprechzeit)));
				        	jLabelSpurbeginnkmh.setForeground(Color.blue);
				        					        	
				        	double bremsbeginnkmh = geschwindigkeit; // Reaktionsphase ohne Bremsverz�gerung
				        	
				        	jLabelBremsbeginnkmh.setText(String.valueOf(df.format(bremsbeginnkmh)));    	
				        	
				        	double bremsbeginnStrecke = calcBremsweg(bremsbeginnkmh, (verzoegerung/2), geschwindigkeitNachAnprechzeit);
				        	
				        	jLabelBremsbeginnStrecke.setText(String.valueOf(df.format(bremsbeginnStrecke)));
				        	jLabelBremsbeginnStrecke.setForeground(Color.blue);
				        	jLabelBremsbeginnZeit.setText(String.valueOf(df.format(bremsansprechzeit)));
				        	
				        	jLabelGefahrkmh.setText(String.valueOf(df.format(bremsbeginnkmh)));
				        	
				        	jLabelGefahrZeit.setText(String.valueOf(df.format(reaktionszeit)));
				        	
				        	double reaktionsweg = (bremsbeginnkmh/3.6)*reaktionszeit;
				        	
				        	jLabelGefahrStrecke.setText(String.valueOf(df.format(reaktionsweg)));
				        	jLabelGefahrStrecke.setForeground(Color.blue);
				        	
				        	double gesamtStrecke = bremsweg+bremsbeginnStrecke+reaktionsweg;
				        	
				        	jLabelGesamtStrecke.setText(String.valueOf(df.format(gesamtStrecke)));
				        	jLabelGesamtStrecke.setForeground(Color.blue);
				        	
				        	double gesamtZeit = zeit+reaktionszeit+bremsansprechzeit;
				        	
				        	jLabelGesamtZeit.setText(String.valueOf(df.format(gesamtZeit)));
				        	jLabelGesamtZeit.setForeground(Color.blue);
				        	
				        	jTextFieldBremsweg.setText(String.valueOf(df.format(bremsweg)));
					        jTextFieldBremsweg.setForeground(Color.blue);
				        	        
			        	}
		        		
		        	}
		        	
				          
				 } 
			} );
			
					
		}
		return jButtonBerechnen;
	}

	/**
	 * This method initializes jButtonNeu	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNeu() {
		if (jButtonNeu == null) {
			jButtonNeu = new JButton();
			jButtonNeu.setText("Neu");
			
			jButtonNeu.addActionListener( new ActionListener() { 
		        public void actionPerformed( ActionEvent e ) { 
		        	
			          getJTextFieldGeschwindigkeit().setText("");
			          getJTextFieldKollisionsgeschwindigkeit().setText(""); 
			          getJTextFieldVerzoegerung().setText(""); 
			          getJTextFieldBremsweg().setText("");
			          
			          getJTextFieldReaktionszeit().setText("0.8");
			          getJTextFieldAnsprechzeit().setText("0.2");
			          
			          getJTextFieldGeschwindigkeit().setBackground(Color.white);
			          getJTextFieldKollisionsgeschwindigkeit().setBackground(Color.white);
			          getJTextFieldBremsweg().setBackground(Color.white);
			          getJTextFieldVerzoegerung().setBackground(Color.white);
			          
			          getJTextFieldGeschwindigkeit().setForeground(Color.black);
			          getJTextFieldKollisionsgeschwindigkeit().setForeground(Color.black);
			          getJTextFieldBremsweg().setForeground(Color.black);
			          getJTextFieldVerzoegerung().setForeground(Color.black);
			          
			          jLabelSpurbeginnkmh.setText("");
			          jLabelKollisionkmh.setText("");
			          jLabelKollisionStrecke.setText("");
			          jLabelKollisionZeit.setText("");
			          jLabelBremsbeginnkmh.setText("");
			          jLabelBremsbeginnStrecke.setText("");
			          jLabelBremsbeginnZeit.setText("");
			          jLabelGefahrStrecke.setText("");
			          jLabelGefahrZeit.setText("");
			          jLabelGefahrkmh.setText("");
			          jLabelGesamtStrecke.setText("");
			          jLabelGesamtZeit.setText("");
			        } 
			      } );
			
			
		}
		return jButtonNeu;
	}
	
	/**
	 * This method initializes jPanelVorbremszeit	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelVorbremszeit() {
		if (jPanelVorbremszeit == null) {
			
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 2;
			gridBagConstraints5.gridy = 3;
			
			jLabelSek2 = new JLabel();
			jLabelSek2.setText("s");
			
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 2;
			gridBagConstraints4.gridy = 2;
			
			jLabelSek = new JLabel();
			jLabelSek.setText("s");
			
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints3.gridy = 3;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.gridx = 1;
			
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = 2;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.gridx = 1;
			
			GridBagConstraints gbcVorbremszeitAnsprechzeit = new GridBagConstraints();
			gbcVorbremszeitAnsprechzeit.gridx = 0;
			gbcVorbremszeitAnsprechzeit.gridy = 3;
			gbcVorbremszeitAnsprechzeit.anchor = gbcVorbremszeitAnsprechzeit.WEST;
			gbcVorbremszeitAnsprechzeit.insets = new Insets(0,20,0,0);
			
			jLabelAnsprechzeit = new JLabel();
			jLabelAnsprechzeit.setText("Bremsansprechzeit");
			
			GridBagConstraints gbcVorbremszeit22 = new GridBagConstraints();
			gbcVorbremszeit22.gridx = 0;
			gbcVorbremszeit22.gridy = 2;
			gbcVorbremszeit22.anchor = gbcVorbremszeit22.WEST;
			gbcVorbremszeit22.insets = new Insets(0,20,0,0);
			
			jLabelReaktionszeit = new JLabel();
			jLabelReaktionszeit.setText("Reaktionszeit");
			
			GridBagConstraints gbcVorbremszeit2 = new GridBagConstraints();
			gbcVorbremszeit2.gridx = 0;
			gbcVorbremszeit2.gridy = 1;
			gbcVorbremszeit2.gridwidth = 2;
			gbcVorbremszeit2.anchor = gbcVorbremszeit2.WEST;
			
			GridBagConstraints gbcVorbremszeit1s = new GridBagConstraints();
			gbcVorbremszeit1s.gridx = 0;
			gbcVorbremszeit1s.gridy = 0;
			gbcVorbremszeit1s.gridwidth = 2;
			gbcVorbremszeit1s.anchor = gbcVorbremszeit1s.WEST;
			
			jPanelVorbremszeit = new JPanel();
			jPanelVorbremszeit.setLayout(new GridBagLayout());
			
		
			jPanelVorbremszeit.add(getJRadioButtonVorbremszeit1s(), gbcVorbremszeit1s);
			jPanelVorbremszeit.add(getJRadioButtonVorbremszeit2(), gbcVorbremszeit2);
			jPanelVorbremszeit.add(jLabelReaktionszeit, gbcVorbremszeit22);
			jPanelVorbremszeit.add(jLabelAnsprechzeit, gbcVorbremszeitAnsprechzeit);
			jPanelVorbremszeit.add(getJTextFieldReaktionszeit(), gridBagConstraints);
			jPanelVorbremszeit.add(getJTextFieldAnsprechzeit(), gridBagConstraints3);
			jPanelVorbremszeit.add(jLabelSek, gridBagConstraints4);
			jPanelVorbremszeit.add(jLabelSek2, gridBagConstraints5);
		}
		return jPanelVorbremszeit;
	}

	/**
	 * This method initializes jRadioButtonVorbremszeit1s	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonVorbremszeit1s() {
		if (jRadioButtonVorbremszeit1s == null) {
			jRadioButtonVorbremszeit1s = new JRadioButton("<html>Vorbremszeit von 1,0 Sekunden<br> berücksichtigen. (Ohne Bremsverzögerung)</html>");
			jRadioButtonVorbremszeit1s.setSelected(true);
			
			jLabelReaktionszeit.setEnabled(false);
			jLabelAnsprechzeit.setEnabled(false);
			getJTextFieldReaktionszeit().setEnabled(false);
			getJTextFieldAnsprechzeit().setEnabled(false);
			jLabelSek.setEnabled(false);
			jLabelSek2.setEnabled(false);
			
			jRadioButtonVorbremszeit1s.addActionListener( new ActionListener() { 
		        public void actionPerformed( ActionEvent e ) { 
		        	
			        	jLabelReaktionszeit.setEnabled(false);
						jLabelAnsprechzeit.setEnabled(false);
						getJTextFieldReaktionszeit().setEnabled(false);
						getJTextFieldAnsprechzeit().setEnabled(false);
						jLabelSek.setEnabled(false);
						jLabelSek2.setEnabled(false);
			          
			        } 
			      } );
		}
		return jRadioButtonVorbremszeit1s;
	}

	/**
	 * This method initializes jRadioButtonVorbremszeit2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonVorbremszeit2() {
		if (jRadioButtonVorbremszeit2 == null) {
			jRadioButtonVorbremszeit2 = new JRadioButton("<html>Vorbremszeit ändern");
			
			ButtonGroup g = new ButtonGroup(); 
			g.add( jRadioButtonVorbremszeit1s ); g.add( jRadioButtonVorbremszeit2 ); 
			
			jRadioButtonVorbremszeit2.addActionListener( new ActionListener() { 
		        public void actionPerformed( ActionEvent e ) { 
		        	
		        	  jLabelReaktionszeit.setEnabled(true);
					  jLabelAnsprechzeit.setEnabled(true);
			          getJTextFieldReaktionszeit().setEnabled(true);
			          getJTextFieldAnsprechzeit().setEnabled(true);
			          jLabelSek.setEnabled(true);
					  jLabelSek2.setEnabled(true);
			        } 
			      } );
		}
		return jRadioButtonVorbremszeit2;
	}
	
	

	/**
	 * This method initializes jTextFieldReaktionszeit	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldReaktionszeit() {
		if (jTextFieldReaktionszeit == null) {
			jTextFieldReaktionszeit = new JTextField();
			jTextFieldReaktionszeit.setPreferredSize(new Dimension(50, 22));
			jTextFieldReaktionszeit.setText("0.8");
		}
		return jTextFieldReaktionszeit;
	}

	/**
	 * This method initializes jTextFieldAnsprechzeit	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAnsprechzeit() {
		if (jTextFieldAnsprechzeit == null) {
			jTextFieldAnsprechzeit = new JTextField();
			jTextFieldAnsprechzeit.setPreferredSize(new Dimension(50, 22));
			jTextFieldAnsprechzeit.setText("0.2");
		}
		return jTextFieldAnsprechzeit;
	}

	/**
	 * This method initializes jPanelAusgabe	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelAusgabe() {
		if (jPanelAusgabe == null) {
			
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.gridx = 5;
			gridBagConstraints25.gridy = 1;
			
			jLabelGesamtStrecke = new JLabel();
			jLabelGesamtStrecke.setText("");
			
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.gridx = 5;
			gridBagConstraints24.gridy = 2;
			
			jLabelGesamtZeit = new JLabel();
			jLabelGesamtZeit.setText("");
			
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.gridx = 4;
			gridBagConstraints23.gridy = 3;
			
			jLabelGefahrkmh = new JLabel();
			jLabelGefahrkmh.setText("");
			
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 4;
			gridBagConstraints22.gridy = 2;
			gridBagConstraints22.anchor = gridBagConstraints22.WEST;
			
			jLabelGefahrZeit = new JLabel();
			jLabelGefahrZeit.setText("");
			
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 4;
			gridBagConstraints21.gridy = 1;
			gridBagConstraints21.anchor = gridBagConstraints21.WEST;
			
			jLabelGefahrStrecke = new JLabel();
			jLabelGefahrStrecke.setText("");
			
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.gridx = 3;
			gridBagConstraints20.gridy = 3;
			
			jLabelBremsbeginnkmh = new JLabel();
			jLabelBremsbeginnkmh.setText("");
			
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 3;
			gridBagConstraints19.gridy = 2;
			gridBagConstraints19.anchor = gridBagConstraints19.WEST;
			gridBagConstraints19.insets = new Insets(0,1,0,0);
			
			jLabelBremsbeginnZeit = new JLabel();
			jLabelBremsbeginnZeit.setText("");
			
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 3;
			gridBagConstraints18.gridy = 1;
			gridBagConstraints18.anchor = gridBagConstraints18.WEST;
			gridBagConstraints18.insets = new Insets(0,1,0,0);
			
			jLabelBremsbeginnStrecke = new JLabel();
			jLabelBremsbeginnStrecke.setText("");
			
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 2;
			gridBagConstraints17.gridy = 3;
			
			jLabelSpurbeginnkmh = new JLabel();
			jLabelSpurbeginnkmh.setText("");
			
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 1;
			gridBagConstraints14.gridy = 3;
			
			jLabelKollisionkmh = new JLabel();
			jLabelKollisionkmh.setText("");
			
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 2;
			gridBagConstraints13.gridy = 2;
			gridBagConstraints13.anchor = gridBagConstraints13.WEST;
			
			jLabelKollisionZeit = new JLabel();
			jLabelKollisionZeit.setText("");
			
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 2;
			gridBagConstraints12.gridy = 1;
			gridBagConstraints12.anchor = gridBagConstraints12.WEST;
			
			jLabelKollisionStrecke = new JLabel();
			jLabelKollisionStrecke.setText("");
			
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridy = 3;
			gridBagConstraints11.anchor = gridBagConstraints11.WEST;
			gridBagConstraints11.insets = new Insets(0,0,4,0);
			
			jLabelGeschwindigkeit = new JLabel();
			jLabelGeschwindigkeit.setText("Geschw. (km/h)");
			
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.gridy = 2;
			gridBagConstraints10.anchor = gridBagConstraints10.WEST;
			gridBagConstraints10.insets = new Insets(0,0,8,0);
			
			jLabelZeit = new JLabel();
			jLabelZeit.setText("Zeit (s)");
			
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 0;
			gridBagConstraints9.gridy = 1;
			gridBagConstraints9.anchor = gridBagConstraints9.WEST;
			gridBagConstraints9.insets = new Insets(0,0,8,0);
			
			jLabelStecke = new JLabel();
			jLabelStecke.setText("Strecke (m)");
			
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 5;
			gridBagConstraints8.gridy = 0;
			gridBagConstraints8.insets = new Insets(0,4,0,4);
			
			jLabelGesamt = new JLabel();
			jLabelGesamt.setText("| Gesamt");
			
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 4;
			gridBagConstraints7.gridy = 0;
			gridBagConstraints7.insets = new Insets(0,4,0,4);
			
			jLabelGefahrmoment = new JLabel();
			jLabelGefahrmoment.setText("| Gefahrmoment");
			
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 3;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.insets = new Insets(0,4,0,4);
			
			jLabelBremsbeginn = new JLabel();
			jLabelBremsbeginn.setText("| Bremsbeginn");
			
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.insets = new Insets(0,4,0,4);
			
			jLabelSpurbeginn = new JLabel();
			jLabelSpurbeginn.setText("| Spurbeginn");
			
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.insets = new Insets(0,4,0,4);
			
			jLabelKollison = new JLabel();
			jLabelKollison.setText("Kollision");
			
			
			jPanelAusgabe = new JPanel();
			jPanelAusgabe.setLayout(new GridBagLayout());
			
			jPanelAusgabe.add(jLabelKollison, gridBagConstraints1);
			jPanelAusgabe.add(jLabelSpurbeginn, gridBagConstraints2);
			jPanelAusgabe.add(jLabelBremsbeginn, gridBagConstraints6);
			jPanelAusgabe.add(jLabelGefahrmoment, gridBagConstraints7);
			jPanelAusgabe.add(jLabelGesamt, gridBagConstraints8);
			jPanelAusgabe.add(jLabelStecke, gridBagConstraints9);
			jPanelAusgabe.add(jLabelZeit, gridBagConstraints10);
			jPanelAusgabe.add(jLabelGeschwindigkeit, gridBagConstraints11);
			jPanelAusgabe.add(jLabelKollisionStrecke, gridBagConstraints12);
			jPanelAusgabe.add(jLabelKollisionZeit, gridBagConstraints13);
			jPanelAusgabe.add(jLabelKollisionkmh, gridBagConstraints14);

			jPanelAusgabe.add(jLabelSpurbeginnkmh, gridBagConstraints17);
			jPanelAusgabe.add(jLabelBremsbeginnStrecke, gridBagConstraints18);
			jPanelAusgabe.add(jLabelBremsbeginnZeit, gridBagConstraints19);
			jPanelAusgabe.add(jLabelBremsbeginnkmh, gridBagConstraints20);
			jPanelAusgabe.add(jLabelGefahrStrecke, gridBagConstraints21);
			jPanelAusgabe.add(jLabelGefahrZeit, gridBagConstraints22);
			jPanelAusgabe.add(jLabelGefahrkmh, gridBagConstraints23);
			jPanelAusgabe.add(jLabelGesamtZeit, gridBagConstraints24);
			jPanelAusgabe.add(jLabelGesamtStrecke, gridBagConstraints25);
		}
		return jPanelAusgabe;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Kollisionsgeschwindigkeit thisClass = new Kollisionsgeschwindigkeit();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public Kollisionsgeschwindigkeit() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(530, 470);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Kollisionsgeschwindigkeits- und Bremswegberechnungen");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			
			GridBagConstraints gbcAusgabe = new GridBagConstraints();
			gbcAusgabe.gridx = 0;
			gbcAusgabe.gridy = 2;
			gbcAusgabe.weightx = 1.0;
			gbcAusgabe.gridwidth = 4;
			gbcAusgabe.anchor = gbcAusgabe.NORTHWEST;
			gbcAusgabe.insets = new Insets(0,3,15,0);
			
			GridBagConstraints gbcVorbremszeit = new GridBagConstraints();
			gbcVorbremszeit.gridx = 0;
			gbcVorbremszeit.gridy = 1;
			gbcVorbremszeit.weighty = 1.0;
			gbcVorbremszeit.gridwidth = 4;
			gbcVorbremszeit.anchor = gbcVorbremszeit.NORTHWEST;
			
			GridBagConstraints gbcBerechnen = new GridBagConstraints();
			gbcBerechnen.gridx = 0;
			gbcBerechnen.gridy = 3;
			
			gbcBerechnen.insets = new Insets(0,10,5,0);
			
			
			GridBagConstraints gbcNeu = new GridBagConstraints();
			gbcNeu.gridx = 1;
			gbcNeu.gridy = 3;
			gbcNeu.insets = new Insets(0,10,5,0);
			
			
			GridBagConstraints gbcGeschwindigkeit = new GridBagConstraints();
			gbcGeschwindigkeit.gridx = 0;
			gbcGeschwindigkeit.gridy = 0;
			gbcGeschwindigkeit.weighty = 0.5;
			gbcGeschwindigkeit.insets = new Insets(12,10,0,0);
			gbcGeschwindigkeit.gridwidth = 3;
			gbcGeschwindigkeit.anchor = gbcGeschwindigkeit.NORTHWEST;
			
			
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJPanelGeschwindigkeit(), gbcGeschwindigkeit);
			jContentPane.add(getJButtonNeu(), gbcNeu);
			jContentPane.add(getJButtonBerechnen(), gbcBerechnen);
			jContentPane.add(getJPanelVorbremszeit(), gbcVorbremszeit);
			jContentPane.add(getJPanelAusgabe(), gbcAusgabe);
			
		}
		return jContentPane;
	}
	
	public static double calcAusgangsgeschwindigkeit (double bremsverzoegerung, double bremsweg, double kollisionsgeschwindigkeit) {
		
		kollisionsgeschwindigkeit = kollisionsgeschwindigkeit/3.6;
		double ausgansgsgeschwindigkeit = Math.sqrt(2*bremsverzoegerung*bremsweg + kollisionsgeschwindigkeit*kollisionsgeschwindigkeit);
		
		return ausgansgsgeschwindigkeit*3.6;
	}
	
	public static double calcKollisionsgeschwindigkeit (double bremsverzoegerung, double bremsweg, double geschwindigkeit) {
		
		geschwindigkeit = geschwindigkeit/3.6;
		double kollisionsgeschwindigkeit = Math.sqrt((geschwindigkeit*geschwindigkeit)-(2*bremsverzoegerung*bremsweg));
		
		return kollisionsgeschwindigkeit*3.6;
	}
	
	public static double calcZeitKollision (double geschwindigkeit, double bremsweg, double kollisionsgeschwindigkeit) {
		
		kollisionsgeschwindigkeit = kollisionsgeschwindigkeit/3.6;
		geschwindigkeit = geschwindigkeit/3.6;
		double zeit = (bremsweg/((kollisionsgeschwindigkeit+geschwindigkeit)/2));
		
		return zeit;
	}
	
	public static double calcBremsweg (double geschwindigkeit, double bremsverzoegerung, double kollisionsgeschwindigkeit) {
		
		kollisionsgeschwindigkeit = kollisionsgeschwindigkeit/3.6;
		geschwindigkeit = geschwindigkeit/3.6;
		double bremsweg = ((geschwindigkeit*geschwindigkeit)-(kollisionsgeschwindigkeit*kollisionsgeschwindigkeit))/(2*bremsverzoegerung);
		
		return bremsweg;
	}
	
/******************************************************************************************/
	
	/**
     * Display a file in the system browser.  If you want to display a
     * file, you must include the absolute path name.
     *
     * @param url the file's url (the url must start with either "http://"
or
     * "file://").
     */
    public static void displayURL(String url)
    {
        boolean windows = isWindowsPlatform();
        String cmd = null;
        try
        {
            if (windows)
            {
                // cmd = 'rundll32 url.dll,FileProtocolHandler http://...'
                cmd = WIN_PATH + " " + WIN_FLAG + " " + url;
                Process p = Runtime.getRuntime().exec(cmd);
            }
            else
            {
                // Under Unix, Netscape has to be running for the "-remote"
                // command to work.  So, we try sending the command and
                // check for an exit value.  If the exit command is 0,
                // it worked, otherwise we need to start the browser.
                // cmd = 'netscape -remote openURL(http://www.javaworld.com)'
                cmd = UNIX_PATH + " " + UNIX_FLAG + "(" + url + ")";
                Process p = Runtime.getRuntime().exec(cmd);
                try
                {
                    // wait for exit code -- if it's 0, command worked,
                    // otherwise we need to start the browser up.
                    int exitCode = p.waitFor();
                    if (exitCode != 0)
                    {
                        // Command failed, start up the browser
                        // cmd = 'netscape http://www.javaworld.com'
                        cmd = UNIX_PATH + " "  + url;
                        p = Runtime.getRuntime().exec(cmd);
                    }
                }
                catch(InterruptedException x)
                {
                    System.err.println("Error bringing up browser, cmd='" +
                                       cmd + "'");
                    System.err.println("Caught: " + x);
                }
            }
        }
        catch(IOException x)
        {
            // couldn't exec browser
            System.err.println("Could not invoke browser, command=" + cmd);
            System.err.println("Caught: " + x);
        }
    }
    
    
    /**
     * Try to determine whether this application is running under Windows
     * or some other platform by examing the "os.name" property.
     *
     * @return true if this application is running under a Windows OS
     */
    public static boolean isWindowsPlatform()
    {
        String os = System.getProperty("os.name");
        if ( os != null && os.startsWith(WIN_ID))
            return true;
        else
            return false;
    }
    
    // Used to identify the windows platform.
    private static final String WIN_ID = "Windows";
    // The default system browser under windows.
    private static final String WIN_PATH = "rundll32";
    // The flag to display a url.
    private static final String WIN_FLAG = "url.dll,FileProtocolHandler";
    // The default browser under unix.
    private static final String UNIX_PATH = "open";
    // The flag to display a url.
    private static final String UNIX_FLAG = "-remote openURL";
    
	
	
}
