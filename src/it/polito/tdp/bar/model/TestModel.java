package it.polito.tdp.bar.model;

import java.util.Random;

public class TestModel {

	public static void main(String[] args) {
		
		Simulator simulation = new Simulator();
		
		// Creo un nuovo generatore di numeri casuali con seed iniziale 42.
		Random rn = new Random(42);
		
		
		
		
		// Aggiungo i tavoli al mio simulatore del bar
		
		// Aggiungo 2 tavoli da dieci posti
    	simulation.aggiungiTavolo(10);
    	simulation.aggiungiTavolo(10);
    	
    	// Aggiungo 4 tavoli da otto posti
    	simulation.aggiungiTavolo(8);
    	simulation.aggiungiTavolo(8);
    	simulation.aggiungiTavolo(8);
    	simulation.aggiungiTavolo(8);
    	
    	// Aggiungo 4 tavoli da sei posti
    	simulation.aggiungiTavolo(6);
    	simulation.aggiungiTavolo(6);
    	simulation.aggiungiTavolo(6);
    	simulation.aggiungiTavolo(6);
    	
    	// Aggiungo 5 tavoli da quattro posti
    	simulation.aggiungiTavolo(4);
    	simulation.aggiungiTavolo(4);
    	simulation.aggiungiTavolo(4);
    	simulation.aggiungiTavolo(4);
    	simulation.aggiungiTavolo(4);
		
    	long ultimoTempoArrivo = 0;
    	
    	// Genero in modo random 2000 eventi
    	for (int i = 0; i < 2000; i++) {
    		
    		long timeArrivo = ultimoTempoArrivo + 1 + rn.nextInt(9);
    		int num_persone =  1 + rn.nextInt(9);
	    	long durata = (long) (60 + Math.random() * 60);
	    	float tolleranza = rn.nextFloat();
	    	
	    				
	    	// Genro un nuovo gruppo di clienti
	    	GruppoClienti gruppo = new GruppoClienti(timeArrivo, num_persone, durata, tolleranza);
	    				
	    	// Creo un nuovo evento e lo inserisco nella coda.
	    	Event e = new Event(timeArrivo, Event.EventType.ARRIVO_GRUPPO_CLIENTI, gruppo);
	    	simulation.addEvent(e);
	    	
    	}
    	
    	
    	System.out.print("\n\n*** INIZIO DELLA SIMULAZIONE ***\n\n");
		
		simulation.run();

		System.out.print("\n\n*** FINE DELLA SIMULAZIONE ***\n\n");

		
		
		System.out.println("\n\n\n STATISTICHE \n");

		System.out.println(simulation.getStatistiche().toString());

	}

}
