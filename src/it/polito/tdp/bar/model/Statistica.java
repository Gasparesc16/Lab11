package it.polito.tdp.bar.model;

public class Statistica {
	
	private int numeroTotaleClienti = 0 ; 
	private int numeroClientiSodisfatti = 0 ;
	private int numeroClientiInsodisfatti = 0 ;
	
	private int numero_totale_gruppi=0;
	private int gruppi_soddisfatti=0;
	private int gruppi_insoddisfatti=0;
	
	private int numTavoli=0;

	
	public void aggiungiClienti(GruppoClienti clienti) {
		// TODO Auto-generated method stub
		
		numero_totale_gruppi++;
		numeroTotaleClienti += clienti.getNum_persone();

		if (clienti.isSoddisfatti()) {
			numeroClientiSodisfatti += clienti.getNum_persone();
			gruppi_soddisfatti++;

		} else {
			numeroClientiInsodisfatti += clienti.getNum_persone();
			gruppi_insoddisfatti++;
		}
		
	}


	/**
	 * @param numTavoli the numTavoli to set
	 */
	public void setNumTavoli(int numTavoli) {
		this.numTavoli = numTavoli;
	}
	
	public String toString() {

		String ris = "Numero totale Gruppi:  " + this.numero_totale_gruppi + "\n";
		ris += "Numero totale Gruppi Soddisfatti:  " + this.gruppi_soddisfatti + "\n";
		ris += "Numero totale Gruppi Insoddisfatti:  " + this.gruppi_insoddisfatti + "\n";
		ris += "Numero totale Clienti:  " + this.numeroTotaleClienti + "\n";
		ris += "Numero totale Clienti Soddisfatti:  " + this.numeroClientiSodisfatti + "\n";
		ris += "Numero totale Clienti Insoddisfatti:  " + this.numeroClientiInsodisfatti + "\n";
		ris += "Numero tavoli con cui lavora il simulatore:  " + this.numTavoli + "\n\n\n";

		return ris;
	}

}
