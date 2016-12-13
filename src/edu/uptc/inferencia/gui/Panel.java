package edu.uptc.inferencia.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel extends JPanel {
    
    private JTextField premisaA, premisaB;
    private JComboBox<String> regla;
    private JTextArea premisas, conclusiones;
    private JButton add, inferir;
    private Ventana ventana;
    
    public Panel(Ventana ventana){
	this.ventana = ventana;
	premisaA = new JTextField();
	premisaB = new JTextField();
	regla = new JComboBox<String>();
	premisas = new JTextArea();
	conclusiones = new JTextArea();
	add = new JButton("Añadir");
	inferir = new JButton("Inferir");
	regla.addItem("ENTONCES");
	regla.addItem("Y");
	regla.addItem("Ó");
	
	setLayout(null);
	JLabel texto1 = new JLabel("Proposición A");
	JLabel texto2 = new JLabel("Proposición B");
	JLabel texto3 = new JLabel("Premisas");
	JLabel texto4 = new JLabel("Conclusiones");
	texto1.setBounds(20, 45, 250, 20);
	texto2.setBounds(ventana.getWidth()-275, 45, 250, 20);
	texto3.setBounds(20, 145, 250, 20);
	texto4.setBounds(((ventana.getWidth()-48)/2)+40, 145, 250, 20);
	premisaA.setBounds(20, 70,250, 20);
	premisaB.setBounds(ventana.getWidth()-275, 70, 250, 20);
	regla.setBounds(280, 70, 135, 20);
	add.setBounds((ventana.getWidth()/2)-50, 110, 100, 23);
	add.addActionListener(ventana.getEventos());
	add.setActionCommand(Eventos.ADD);
	inferir.setBounds((ventana.getWidth()/2)-50, ventana.getHeight()-73, 100, 23);
	inferir.addActionListener(ventana.getEventos());
	inferir.setActionCommand(Eventos.INF);
	premisas.setBounds(20, 170, ((ventana.getWidth()-48)/2)-20, 200);
	conclusiones.setBounds((((ventana.getWidth()-48)/2)+40), 170, ((ventana.getWidth()-48)/2)-20, 200);
	add(premisaA);
	add(texto1);
	add(texto2);
	add(texto3);
	add(texto4);
	add(premisaB);
	add(regla);
	add(premisas);
	add(conclusiones);
	add(add);
	add(inferir);
	
    }

    public JTextField getPremisaA() {
        return premisaA;
    }

    public void setPremisaA(JTextField premisaA) {
        this.premisaA = premisaA;
    }

    public JTextField getPremisaB() {
        return premisaB;
    }

    public void setPremisaB(JTextField premisaB) {
        this.premisaB = premisaB;
    }

    public JComboBox<String> getRegla() {
        return regla;
    }

    public void setRegla(JComboBox<String> regla) {
        this.regla = regla;
    }

    public JTextArea getPremisas() {
        return premisas;
    }

    public void setPremisas(JTextArea premisas) {
        this.premisas = premisas;
    }

    public JTextArea getConclusiones() {
        return conclusiones;
    }

    public void setConclusiones(JTextArea conclusiones) {
        this.conclusiones = conclusiones;
    }

    public JButton getAdd() {
        return add;
    }

    public void setAdd(JButton add) {
        this.add = add;
    }

    public JButton getInferir() {
        return inferir;
    }

    public void setInferir(JButton inferir) {
        this.inferir = inferir;
    }
    
    
    

}
