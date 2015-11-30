package dreieck;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

/**
 * Dies ist die einzige Klasse des Dreiecksprojektes, welche sowohl die Rechenalgorithmen als auch das Design steuert.
 * 
 * @author Lukas Schramm
 * @version 1.0
 * 
 */
public class Dreieck {

	private JFrame frame1 = new JFrame("Dreiecksberechnung");
	private NumberFormat format1 = NumberFormat.getInstance(); 
	private NumberFormat format2 = NumberFormat.getInstance();
	private NumberFormat format3 = NumberFormat.getInstance();
	private NumberFormatter formatter1 = new NumberFormatter(format1);
    private NumberFormatter formatter2 = new NumberFormatter(format2);
    private NumberFormatter formatter3 = new NumberFormatter(format3);
	private JFormattedTextField feldSeiteA = new JFormattedTextField(formatter1);
	private JFormattedTextField feldSeiteB = new JFormattedTextField(formatter2);
	private JFormattedTextField feldWinkelGamma = new JFormattedTextField(formatter3);
	private JButton buttonRechnen = new JButton("Berechne");
	private JLabel labelSeiteA = new JLabel(" Seite a:");
	private JLabel labelSeiteB = new JLabel(" Seite b:");
	private JLabel labelWinkelGamma = new JLabel(" Gamma:");
	private JLabel labelLE1 = new JLabel("LE");
	private JLabel labelLE2 = new JLabel("LE");
	private JLabel labelGrad = new JLabel("°");
	private JLabel labelFlaeche = new JLabel();
	private JLabel labelUmfang = new JLabel();
	private JLabel labelSeiteC = new JLabel();
	private JLabel labelAlpha = new JLabel();
	private JLabel labelBeta = new JLabel();
	
	public Dreieck() {
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setPreferredSize(new Dimension(400,200));
		frame1.setMinimumSize(new Dimension(400,200));
		frame1.setMaximumSize(new Dimension(600,400));
		frame1.setResizable(true);
		Container cp = frame1.getContentPane();
		cp.setLayout(new GridBagLayout());
		
		JPanel paneleingabe = new JPanel();
		paneleingabe.setLayout(new GridBagLayout());
		JPanel paneleingabelinks = new JPanel();
		paneleingabelinks.setLayout(new GridBagLayout());
		paneleingabelinks.add(labelSeiteA,new GridBagFelder(0,0,1,1,0.3,0.33));
		paneleingabelinks.add(feldSeiteA,new GridBagFelder(1,0,1,1,0.5,0.33));
		paneleingabelinks.add(labelLE1,new GridBagFelder(2,0,1,1,0.2,0.33));
		paneleingabelinks.add(labelSeiteB,new GridBagFelder(0,1,1,1,0.3,0.33));
		paneleingabelinks.add(feldSeiteB,new GridBagFelder(1,1,1,1,0.5,0.33));
		paneleingabelinks.add(labelLE2,new GridBagFelder(2,1,1,1,0.2,0.33));
		paneleingabelinks.add(labelWinkelGamma,new GridBagFelder(0,2,1,1,0.3,0.33));
		paneleingabelinks.add(feldWinkelGamma,new GridBagFelder(1,2,1,1,0.5,0.33));
		paneleingabelinks.add(labelGrad,new GridBagFelder(2,2,1,1,0.2,0.33));
		
		paneleingabe.add(paneleingabelinks,new GridBagFelder(0,0,1,1,0.7,1));
		paneleingabe.add(buttonRechnen,new GridBagFelder(1,0,1,1,0.3,1));
		paneleingabelinks.setPreferredSize(new Dimension(0,0));
		buttonRechnen.setPreferredSize(new Dimension(0,0));
		
		JPanel panelausgabe = new JPanel();
		panelausgabe.setLayout(new GridBagLayout());
		JLabel nameC = new JLabel(" Seite c:");
		JLabel namealpha = new JLabel(" Alpha:");
		JLabel namebeta = new JLabel(" Beta:");
		JLabel nameUmfang = new JLabel(" Umfang:");
		JLabel nameFlaeche = new JLabel(" Fläche:");
		panelausgabe.add(nameC,new GridBagFelder(0,0,1,1,0.3,0.2));
		panelausgabe.add(labelSeiteC,new GridBagFelder(1,0,1,1,0.7,0.2));
		panelausgabe.add(namealpha,new GridBagFelder(0,1,1,1,0.4,0.2));
		panelausgabe.add(labelAlpha,new GridBagFelder(1,1,1,1,0.6,0.2));
		panelausgabe.add(namebeta,new GridBagFelder(0,2,1,1,0.4,0.2));
		panelausgabe.add(labelBeta,new GridBagFelder(1,2,1,1,0.6,0.2));
		panelausgabe.add(nameUmfang,new GridBagFelder(0,3,1,1,0.4,0.2));
		panelausgabe.add(labelUmfang,new GridBagFelder(1,3,1,1,0.6,0.2));
		panelausgabe.add(nameFlaeche,new GridBagFelder(0,4,1,1,0.4,0.2));
		panelausgabe.add(labelFlaeche,new GridBagFelder(1,4,1,1,0.6,0.2));
		nameC.setPreferredSize(new Dimension(0,0));
		labelSeiteC.setPreferredSize(new Dimension(0,0));
		namealpha.setPreferredSize(new Dimension(0,0));
		labelAlpha.setPreferredSize(new Dimension(0,0));
		namebeta.setPreferredSize(new Dimension(0,0));
		labelBeta.setPreferredSize(new Dimension(0,0));
		nameUmfang.setPreferredSize(new Dimension(0,0));
		labelUmfang.setPreferredSize(new Dimension(0,0));
		nameFlaeche.setPreferredSize(new Dimension(0,0));
		labelFlaeche.setPreferredSize(new Dimension(0,0));
		
	    feldSeiteA.setText("");
	    feldSeiteB.setText("");
	    feldWinkelGamma.setText("");
	    feldSeiteA.setHorizontalAlignment(SwingConstants.RIGHT);
	    feldSeiteB.setHorizontalAlignment(SwingConstants.RIGHT);
	    feldWinkelGamma.setHorizontalAlignment(SwingConstants.RIGHT);
	    labelSeiteC.setHorizontalAlignment(SwingConstants.LEFT);
	    labelAlpha.setHorizontalAlignment(SwingConstants.LEFT);
	    labelBeta.setHorizontalAlignment(SwingConstants.LEFT);
	    labelUmfang.setHorizontalAlignment(SwingConstants.LEFT);
	    labelFlaeche.setHorizontalAlignment(SwingConstants.LEFT);
	    buttonRechnen.setMargin(new Insets(2, 2, 2, 2));
	    buttonRechnen.addActionListener(new ActionListener() { 
	    	public void actionPerformed(ActionEvent evt) { 
	    		berechnen();
	    	}
	    });
	    
	    format1.setGroupingUsed(false);
	    format2.setGroupingUsed(false);
	    format3.setGroupingUsed(false);
	    formatter1.setAllowsInvalid(false);
	    formatter2.setAllowsInvalid(false);
	    formatter3.setAllowsInvalid(false);
	    
	    frame1.add(paneleingabe,new GridBagFelder(0,0,1,1,1,0.5));
	    frame1.add(panelausgabe,new GridBagFelder(0,1,1,1,1,0.5));
	    paneleingabe.setPreferredSize(new Dimension(0,0));
	    panelausgabe.setPreferredSize(new Dimension(0,0));
		frame1.pack();
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}
	
	/**
	 * Diese Methode liest die Strings ein, loest die Gleichungen und gibt die Ergebnisse aus.<br>
	 * Das Einlesen von Kommazahlen geht etwas komplizierter von statten, weil Java zu bloed dafuer ist.
	 */
	private void berechnen() {
		try {
			String stra[] = feldSeiteA.getText().split(",");
			String strb[] = feldSeiteB.getText().split(",");
			String strgamma[] = feldWinkelGamma.getText().split(",");
			double seitea;
			double seiteb;
			double gamma;
			if(stra.length==1) {
				seitea = Double.valueOf(stra[0]);
			} else {
				seitea = Double.valueOf(stra[0])+Double.valueOf(stra[1])/Math.pow(10,stra[1].length());
			}
			if(strb.length==1) {
				seiteb = Double.valueOf(strb[0]);
			} else {
				seiteb = Double.valueOf(strb[0])+Double.valueOf(strb[1])/Math.pow(10,strb[1].length());
			}
			if(strgamma.length==1) {
				gamma = Double.valueOf(strgamma[0]);
			} else {
				gamma = Double.valueOf(strgamma[0])+Double.valueOf(strgamma[1])/Math.pow(10,strgamma[1].length());
			}
			if(seitea<0 || seiteb<0 || gamma<0) {
				JOptionPane.showMessageDialog(null, "Du hast negative Werte eingetragen."+System.getProperty("line.separator")+"Wenn Du dies nicht korrigierst"+System.getProperty("line.separator")+"bekommst Du kein Ergebnis!", "Falscheingabe", JOptionPane.WARNING_MESSAGE);
			} else if(gamma>=180) {
				JOptionPane.showMessageDialog(null, "Dein Winkel ist größer als 180°."+System.getProperty("line.separator")+"Wenn Du dies nicht korrigierst"+System.getProperty("line.separator")+"bekommst Du kein Ergebnis!", "Falscheingabe", JOptionPane.WARNING_MESSAGE);
			} else {
				double seitec = Math.sqrt(Math.pow(seitea,2) + Math.pow(seiteb,2) - 2*seitea*seiteb*Math.cos(gamma/180*Math.PI));
				double alpha = 180/3.14*Math.acos((Math.pow(seiteb,2)+Math.pow(seitec,2)-Math.pow(seitea,2))/(2*seiteb*seitec));
				double beta = 180-gamma-alpha;
				double umfang = seitea+seiteb+seitec;
				double flaeche = 0.5*seitea*seiteb*Math.sin(gamma/180*Math.PI);
				
			    labelSeiteC.setText(Math.round(seitec*1000)/1000.0+" LE");
			    labelAlpha.setText(Math.round(alpha*1000)/1000.0+" °");
			    labelBeta.setText(Math.round(beta*1000)/1000.0+" °");
			    labelUmfang.setText(Math.round(umfang*1000)/1000.0+" LE");
			    labelFlaeche.setText(Math.round(flaeche*1000)/1000.0+" FE");
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Du hast falsche Werte eingetragen."+System.getProperty("line.separator")+"Wenn Du dies nicht korrigierst"+System.getProperty("line.separator")+"bekommst Du kein Ergebnis!", "Falscheingabe", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		new Dreieck();
	}
}