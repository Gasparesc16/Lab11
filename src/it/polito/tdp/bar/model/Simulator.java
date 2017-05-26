package it.polito.tdp.bar.model;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;


public class Simulator {
	
	// Parametri di simulazione
	
	
	private Random rd;
	
	
	// Stato del modello
	private Map<Integer, Tavolo> tavoli;
	
	
	// Variabili di interesse
	private Statistica statistiche;
	
	// Lista degli eventi
	private PriorityQueue<Event> listaEventi;
	
	
	public Simulator() {
		
		this.tavoli = new HashMap<Integer,Tavolo>();
		this.listaEventi = new PriorityQueue<Event>();
		this.statistiche = new Statistica();
		
		this.rd = new Random(42);
	}
	
	public void addEvent(Event e) {
		// TODO Auto-generated method stub
		
		this.listaEventi.add(e);
		
	}
	
	public void run() {
		
		while(!listaEventi.isEmpty()) {
			Event e = listaEventi.poll() ;
			
			// process event
			switch(e.getTipoEvento()) {
			
			case ARRIVO_GRUPPO_CLIENTI:
				
				// Cerco un tavolo disponibile
				Tavolo t = cercaTavoloDisponibile(e.getClienti().getNum_persone());
				
				if(t != null){
					
					// Assegno il tavolo al gruppo arrivato (clienti soddisfatti)
					t.setIdGruppoClienti(e.getClienti().getIdGruppoClienti());
					t.setLibero(false);
					tavoli.put(t.getIdTavolo(), t);
					e.getClienti().setSoddisfatti(true);
					
					// Creo un nuovo evento per simulare i clienti che escono dal bar
					Event eNew = new Event(e.getTime() + e.getClienti().getDurata(), Event.EventType.USCITA_GRUPPO_CLIENTI, e.getClienti() );
					listaEventi.add(eNew);
					
					
				} else {
					
					float tolleranza = e.getClienti().getTolleranza();
					float probabilita = rd.nextFloat();
					
					if(probabilita <= tolleranza){
						
						// I clienti vengono serviti al bancone
						e.getClienti().setSoddisfatti(true);
						
						
					} else {
						
						// I clienti escono dal bar non soddisfatti.
						e.getClienti().setSoddisfatti(false);
						
						
					}
					
					
					
				}
				
				statistiche.aggiungiClienti(e.getClienti());
				
				break ;
				
			case USCITA_GRUPPO_CLIENTI:
				// Il gruppo di clienti lasciano il locale ---> libero il tavolo occupato
				
				Tavolo tLibero = trovaTavolo(e.getClienti().getIdGruppoClienti());
				
				tLibero.setLibero(true);
				
				e.getClienti().setSoddisfatti(false);
				
				tavoli.put(tLibero.getIdTavolo(), tLibero);

				break ;
				
			default:
				throw new IllegalArgumentException();
				
			}
		}
	}
	

	private Tavolo trovaTavolo(int idGruppoClienti) {
		
		for(Tavolo temp: tavoli.values()){
			
			if(temp.getIdGruppoClienti() == idGruppoClienti)
				return temp;
			
		}
		return null;
	}

	private Tavolo cercaTavoloDisponibile(int num_persone) {
		// TODO Auto-generated method stub
		
		int postiTavoloMin = Integer.MAX_VALUE;
		Tavolo temp = null;

		// Itero su tutti i tavoli
		for (Tavolo t : tavoli.values()) {

			// Controllo i requisiti minimi
			if (t.isLibero() && num_persone >= 0.5 * t.getNumPostiASedere()) {

				// Cerco il tavolo con il minimo numero di posti a sedere.
				if (postiTavoloMin > t.getNumPostiASedere()) {
					temp = t;
					postiTavoloMin = t.getNumPostiASedere();
				}
			}
		}

		return temp;
		
		
		
	}

	public void aggiungiTavolo(int numPostiASedere) {
		
		Tavolo t = new Tavolo(numPostiASedere);
		
		tavoli.put(t.getIdTavolo(), t);
		
		statistiche.setNumTavoli(tavoli.size());
		
		
		
	}
	
	
	
	/**
	 * @return the statistiche
	 */
	public Statistica getStatistiche() {
		return statistiche;
	}
	
	



	
}
