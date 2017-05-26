package it.polito.tdp.bar.model;


public class Event implements Comparable<Event> {
	
	
	private long time ;
	
	public enum EventType { ARRIVO_GRUPPO_CLIENTI, USCITA_GRUPPO_CLIENTI } ;
	private EventType tipoEvento ;
	
	private GruppoClienti clienti;

	
	public Event(long time, EventType tipoEvento, GruppoClienti clienti) {
		
		this.time = time;
		this.tipoEvento = tipoEvento;
		this.clienti = clienti;
	}
	
	
	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * @return the tipoEvento
	 */
	public EventType getTipoEvento() {
		return tipoEvento;
	}

	/**
	 * @return the clienti
	 */
	public GruppoClienti getClienti() {
		return clienti;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}

	/**
	 * @param tipoEvento the tipoEvento to set
	 */
	public void setTipoEvento(EventType tipoEvento) {
		this.tipoEvento = tipoEvento;
	}


	/**
	 * @param clienti the clienti to set
	 */
	public void setClienti(GruppoClienti clienti) {
		this.clienti = clienti;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Event [time=%s, tipoEvento=%s, clienti=%s]", time, tipoEvento, clienti);
	}


	@Override
	public int compareTo(Event e) {
		// TODO Auto-generated method stub
		
		return Long.compare(this.time, e.time);
	}

}
