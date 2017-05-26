package it.polito.tdp.bar.model;

public class Tavolo {
	
	private int idTavolo;
	private int cont = 0;
	
	private int numPostiASedere;
	
	private boolean libero;
	
	
	private int idGruppoClienti;

	public Tavolo(int numPostiASedere) {
		
		this.numPostiASedere = numPostiASedere;
		this.libero = true;
		
		idTavolo = cont++;
	}

	/**
	 * @return the numPostiASedere
	 */
	public int getNumPostiASedere() {
		return numPostiASedere;
	}

	/**
	 * @return the libero
	 */
	public boolean isLibero() {
		return libero;
	}

	/**
	 * @param numPostiASedere the numPostiASedere to set
	 */
	public void setNumPostiASedere(int numPostiASedere) {
		this.numPostiASedere = numPostiASedere;
	}

	/**
	 * @param libero the libero to set
	 */
	public void setLibero(boolean libero) {
		this.libero = libero;
	}

	/**
	 * @return the idTavolo
	 */
	public int getIdTavolo() {
		return idTavolo;
	}

	/**
	 * @param idTavolo the idTavolo to set
	 */
	public void setIdTavolo(int idTavolo) {
		this.idTavolo = idTavolo;
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
	
	
	
	
	
	
	
	
	
	
	

}
