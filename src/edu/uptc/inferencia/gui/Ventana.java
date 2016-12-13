package edu.uptc.inferencia.gui;

import javax.swing.JFrame;

import edu.uptc.infrencia.logic.Gestion;
import edu.uptc.infrencia.logic.Proposicion;

public class Ventana extends JFrame {

    private Panel panel;
    private Eventos eventos;
    private Gestion gestion;
    private int premisas = 0;

    public Ventana() {
	super();
	setTitle("Matemáticas Discretas");
	setSize(700, 480);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	inicializarComponentes();
	add(panel);
    }

    private void inicializarComponentes() {
	gestion = new Gestion();
	eventos = new Eventos(this);
	panel = new Panel(this);
    }

    public void addPre() {
	premisas += 1;
	if (panel.getPremisaB().getText().isEmpty()) {
	    String premisa = premisas + ". " + panel.getPremisaA().getText()
		    + "\n";
	    panel.getPremisas().append(premisa);
	    Proposicion preA;
	    if (panel.getPremisaA().getText().length() > 2) {
		if (panel.getPremisaA().getText().substring(0, 2).equals("no")) {
		    String premisaA = panel.getPremisaA().getText()
			    .substring(2);
		    preA = new Proposicion(premisaA, "", true);
		} else {
		    preA = new Proposicion(panel.getPremisaA().getText(), "",
			    false);
		}
	    } else {
		preA = new Proposicion(panel.getPremisaA().getText(), "", false);
	    }
	    Proposicion con = new Proposicion("", premisas + "", true);
	    Proposicion preB = new Proposicion("", "unica", true);
	    gestion.addPremisa(preA, preB, con);
	}
	else {
	    String premisa = premisas + ". " + panel.getPremisaA().getText()
		    + " " + panel.getRegla().getSelectedItem() + " "
		    + panel.getPremisaB().getText() + "\n";
	    panel.getPremisas().append(premisa);
	    Proposicion preA, preB;
	    if (panel.getPremisaB().getText().length() > 2) {
		if (panel.getPremisaB().getText().substring(0, 2).equals("no")) {
		    String premisaB = panel.getPremisaB().getText()
			    .substring(2);
		    preB = new Proposicion(premisaB, "", true);
		} else {
		    preB = new Proposicion(panel.getPremisaB().getText(), "",
			    false);
		}
	    } else {
		preB = new Proposicion(panel.getPremisaB().getText(), "", false);
	    }

	    if (panel.getPremisaA().getText().length() > 2) {
		if (panel.getPremisaA().getText().substring(0, 2).equals("no")) {
		    String premisaA = panel.getPremisaA().getText()
			    .substring(2);
		    preA = new Proposicion(premisaA, "", true);
		} else {
		    preA = new Proposicion(panel.getPremisaA().getText(), "",
			    false);
		}
	    } else {
		preA = new Proposicion(panel.getPremisaA().getText(), "", false);
	    }

	    Proposicion con = new Proposicion(panel.getRegla()
		    .getSelectedItem() + "", premisas + "", true);
	    gestion.addPremisa(preA, preB, con);
	}
	panel.getPremisaA().setText("");
	panel.getPremisaB().setText("");
    }

    public void inferir() {
	panel.getConclusiones().setText(gestion.inferir());
    }

    public Eventos getEventos() {
	return eventos;
    }

    public static void main(String[] args) {
	Ventana ventana = new Ventana();
	ventana.setVisible(true);
    }

}
