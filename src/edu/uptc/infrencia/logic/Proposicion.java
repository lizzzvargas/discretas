package edu.uptc.infrencia.logic;

public class Proposicion {
    
    private String preposicion;
    private String valor;
    private boolean negacion;
   
    public Proposicion(String preposicion, String valor, boolean negacion) {
	super();
	this.preposicion = preposicion;
	this.valor = valor;
	this.negacion = negacion;
    }

    public String getPreposicion() {
        return preposicion;
    }

    public void setPreposicion(String preposicion) {
        this.preposicion = preposicion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isNegacion() {
        return negacion;
    }

    public void setNegacion(boolean negacion) {
        this.negacion = negacion;
    }

    
    

}
