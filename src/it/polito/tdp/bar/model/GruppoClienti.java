package it.polito.tdp.bar.model;

public class GruppoClienti {
	
	
	private int idGruppoClienti;
	private int cont =0;
	
	private long timeArrivo;
	private int num_persone;
	private long durata;
	private float tolleranza;
	
	private boolean soddisfatti;
	
	public GruppoClienti(long timeArrivo, int num_persone, long durata, float tolleranza) {
		
		this.idGruppoClienti = cont++;
		
		this.timeArrivo = timeArrivo;
		this.num_persone = num_persone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		
		this.soddisfatti = false;
		
		
	}

	/**
	 * @return the idGruppoClienti
	 */
	public int getIdGruppoClienti() {
		return idGruppoClienti;
	}



	/**
	 * @param idGruppoClienti the idGruppoClienti to set
	 */
	public void setIdGruppoClienti(int idGruppoClienti) {
		this.idGruppoClienti = idGruppoClienti;
	}



	/**
	 * @return the timeArrivo
	 */
	public long getTimeArrivo() {
		return timeArrivo;
	}

	/**
	 * @return the num_persone
	 */
	public int getNum_persone() {
		return num_persone;
	}

	/**
	 * @return the durata
	 */
	public long getDurata() {
		return durata;
	}

	/**
	 * @return the tolleranza
	 */
	public float getTolleranza() {
		return tolleranza;
	}

	/**
	 * @param timeArrivo the timeArrivo to set
	 */
	public void setTimeArrivo(long timeArrivo) {
		this.timeArrivo = timeArrivo;
	}

	/**
	 * @param num_persone the num_persone to set
	 */
	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}

	/**
	 * @param durata the durata to set
	 */
	public void setDurata(long durata) {
		this.durata = durata;
	}

	/**
	 * @param tolleranza the tolleranza to set
	 */
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	/**
	 * @return the soddisfatti
	 */
	public boolean isSoddisfatti() {
		return soddisfatti;
	}

	/**
	 * @param soddisfatti the soddisfatti to set
	 */
	public void setSoddisfatti(boolean soddisfatti) {
		this.soddisfatti = soddisfatti;
	}
	
	
	
	
	
	
	

}
