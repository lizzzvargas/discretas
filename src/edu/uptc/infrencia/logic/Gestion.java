package edu.uptc.infrencia.logic;

import java.util.ArrayList;
import java.util.Vector;

public class Gestion {

    private ArrayList<Vector<Proposicion>> premisas;
    private ArrayList<String> conclusiones;

    public Gestion() {
	premisas = new ArrayList<>();
	conclusiones = new ArrayList<>();
    }

    public void addPremisa(Proposicion preA, Proposicion preB, Proposicion con) {
	Vector<Proposicion> temp = new Vector<Proposicion>();
	temp.add(preA);
	temp.add(con);
	temp.add(preB);
	premisas.add(temp);
    }

    public String inferir() {
	conclusiones.clear();
	ponendoPonens();
	tollendoTollens();
//	adjuncion();

	String temp = "";
	for (int i = 0; i < conclusiones.size(); i++) {
	    temp += conclusiones.get(i) + "\n";
	}

	return temp;
    }

    private void ponendoPonens() {
	ArrayList<Vector<Proposicion>> temp = new ArrayList<Vector<Proposicion>>();
	ArrayList<Vector<Proposicion>> temp2 = new ArrayList<Vector<Proposicion>>();
	for (int i = 0; i < premisas.size(); i++) {
	    if (premisas.get(i).get(2).getValor().equals("unica")) {
		temp.add(premisas.get(i));
	    }
	}
	for (int i = 0; i < premisas.size(); i++) {
	    if (premisas.get(i).get(1).getPreposicion().equals("ENTONCES")) {
		temp2.add(premisas.get(i));
	    }
	}
	for (int i = 0; i < temp.size(); i++) {
	    for (int j = 0; j < temp2.size(); j++) {
		if (temp2.get(j).get(0).getPreposicion()
			.equals(temp.get(i).get(0).getPreposicion())
			&& temp2.get(j).get(0).isNegacion() == temp.get(i)
				.get(0).isNegacion()) {
		    conclusiones.add(temp2.get(j).get(2).getPreposicion()
			    + " - Ponendo Ponens ("
			    + temp2.get(j).get(1).getValor() + ","
			    + temp.get(i).get(1).getValor() + ").");
		} else if (temp2.get(j).get(2).getPreposicion()
			.equals(temp.get(i).get(0).getPreposicion())
			&& temp2.get(j).get(0).isNegacion() == temp.get(i)
				.get(0).isNegacion()) {
		    conclusiones.add(temp2.get(j).get(0).getPreposicion()
			    + " - Ponendo Ponens ("
			    + temp2.get(j).get(1).getValor() + ","
			    + temp.get(i).get(1).getValor() + ").");
		}
	    }
	}
    }

    private void adjuncion() {
	ArrayList<Vector<Proposicion>> temp = new ArrayList<Vector<Proposicion>>();
	for (int i = 0; i < premisas.size(); i++) {
	    if (premisas.get(i).get(2).getValor().equals("unica")) {
		temp.add(premisas.get(i));
	    }
	}

	for (int i = 0; i < temp.size(); i++) {
	    for (int j = 0; j < temp.size(); j++) {
		if (temp.get(i).get(0).getPreposicion() != temp.get(j).get(0)
			.getPreposicion()) {
		    conclusiones.add(temp.get(i).get(0).getPreposicion()
			    + " y " + temp.get(j).get(0).getPreposicion()
			    + " - Adjunción (" + temp.get(i).get(1).getValor()
			    + "," + temp.get(j).get(1).getValor() + ").");
		}
	    }
	}
    }

    private void tollendoTollens() {
	ArrayList<Vector<Proposicion>> temp = new ArrayList<Vector<Proposicion>>();
	ArrayList<Vector<Proposicion>> temp2 = new ArrayList<Vector<Proposicion>>();
	for (int i = 0; i < premisas.size(); i++) {
	    if (premisas.get(i).get(2).getValor().equals("unica")) {
		temp.add(premisas.get(i));
	    }
	}
	for (int i = 0; i < premisas.size(); i++) {
	    if (premisas.get(i).get(1).getPreposicion().equals("ENTONCES")) {
		temp2.add(premisas.get(i));
	    }
	}
	for (int i = 0; i < temp.size(); i++) {
	    for (int j = 0; j < temp2.size(); j++) {
		if (temp2.get(j).get(0).getPreposicion()
			.equals(temp.get(i).get(0).getPreposicion())) {

		    if (temp2.get(j).get(0).isNegacion() != temp.get(i).get(0)
			    .isNegacion()) {
			if (temp2.get(j).get(2).isNegacion()) {
			    conclusiones.add(temp2.get(j).get(2)
				    .getPreposicion()
				    + " - Tollendo Tollens ("
				    + temp2.get(j).get(1).getValor()
				    + ","
				    + temp.get(i).get(1).getValor() + ").");
			} else {
			    conclusiones.add("~ "
				    + temp2.get(j).get(2).getPreposicion()
				    + " - Tollendo Tollens ("
				    + temp2.get(j).get(1).getValor() + ","
				    + temp.get(i).get(1).getValor() + ").");
			}

		    }

		} else if (temp2.get(j).get(2).getPreposicion()
			.equals(temp.get(i).get(0).getPreposicion())
			&& temp2.get(j).get(0).isNegacion() != temp.get(i)
				.get(0).isNegacion()) {

		    if (temp2.get(j).get(0).isNegacion()) {
			conclusiones.add(temp2.get(j).get(0).getPreposicion()
				+ " - Tollendo Tollens ("
				+ temp2.get(j).get(1).getValor() + ","
				+ temp.get(i).get(1).getValor() + ").");
		    } else {
			conclusiones.add("~ "
				+ temp2.get(j).get(0).getPreposicion()
				+ " - Tollendo Tollens ("
				+ temp2.get(j).get(1).getValor() + ","
				+ temp.get(i).get(1).getValor() + ").");
		    }
		}
	    }
	}
    }

}
