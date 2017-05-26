/**
 * Sample Skeleton for 'Bar.fxml' Controller Class
 */

package it.polito.tdp.bar;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Event;
import it.polito.tdp.bar.model.GruppoClienti;
import it.polito.tdp.bar.model.Simulator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BarController {
	
	private Simulator model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtResult.clear();

    }

    @FXML
    void doSimula(ActionEvent event) {
    	
    	
    	// Creo un nuovo generatore di numeri casuali con seed iniziale 42.
    	Random rn = new Random(42);
    			
    			
    			
    			
    	// Aggiungo i tavoli al mio simulatore del bar
    			
    	// Aggiungo 2 tavoli da dieci posti
    	model.aggiungiTavolo(10);
    	model.aggiungiTavolo(10);
    	    	
    	// Aggiungo 4 tavoli da otto posti
    	model.aggiungiTavolo(8);
    	model.aggiungiTavolo(8);
    	model.aggiungiTavolo(8);
    	model.aggiungiTavolo(8);
    	    	
    	// Aggiungo 4 tavoli da sei posti
    	model.aggiungiTavolo(6);
    	model.aggiungiTavolo(6);
    	model.aggiungiTavolo(6);
    	model.aggiungiTavolo(6);
    	    
    	 // Aggiungo 5 tavoli da quattro posti
    	 model.aggiungiTavolo(4);
    	 model.aggiungiTavolo(4);
    	 model.aggiungiTavolo(4);
    	 model.aggiungiTavolo(4);
    	 model.aggiungiTavolo(4);
    			
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
    		   model.addEvent(e);
    		    	
    	    	}
    	
    	 
    	  
    	  model.run();
    	  
    	  this.txtResult.appendText("STATISTICHE \n");
    	
    	  this.txtResult.appendText(model.getStatistiche().toString());

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }

	/**
	 * @param model the model to set
	 */
	public void setModel(Simulator model) {
		this.model = model;
	}
    
    
}
