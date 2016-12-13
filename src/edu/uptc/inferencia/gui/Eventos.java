package edu.uptc.inferencia.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventos implements ActionListener{
    
    private Ventana ventana;
    public static final String ADD = "Añadir";
    public static final String INF = "Inferir";
    
    

    public Eventos(Ventana ventana) {
	super();
	this.ventana = ventana;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
	
	switch (e.getActionCommand()) {
	case ADD:
	    ventana.addPre();
	    break;

	case INF:
	    ventana.inferir();
	    break;
	}
	
	
    }

}
