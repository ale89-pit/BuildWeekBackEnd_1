package model;

import java.time.LocalDate;

import utils.Status;
import utils.TipoMezzo;

public class Mezzi {
	
	private Integer id;
	
	private Integer capienza;
	
	private Status stato;
	
	private TipoMezzo tipoMezzo;
	
	private LocalDate inizioServizio;
	
	private LocalDate fineServizio;

	public Mezzi() {
		super();
	}

	public Mezzi(TipoMezzo tipoMezzo, LocalDate inizioServizio, LocalDate fineServizio) {
		super();
		this.stato = (fineServizio.compareTo(LocalDate.now())>0)? Status.IN_SERVIZIO : Status.IN_MANUTENZIONE;
		this.inizioServizio = inizioServizio;
		this.fineServizio = fineServizio;
		this.tipoMezzo=tipoMezzo;
		
		this.capienza= tipoMezzo.equals(TipoMezzo.TRAM) ?  40 : 60; 
	}
	
	public Mezzi(TipoMezzo tipoMezzo, LocalDate inizioServizio) {
		super();
		this.inizioServizio = inizioServizio;
		this.tipoMezzo=tipoMezzo;
		this.stato=Status.IN_SERVIZIO;
		this.capienza= tipoMezzo.equals(TipoMezzo.TRAM) ?  40 : 60; 
	}
	

	public Status getStato() {
	return	(this.fineServizio.compareTo(LocalDate.now())>0)? Status.IN_SERVIZIO : Status.IN_MANUTENZIONE;
		
	}


	public LocalDate getInizioServizio() {
		return inizioServizio;
	}

	public void setInizioServizio(LocalDate inizioServizio) {
		this.inizioServizio = inizioServizio;
	}

	public LocalDate getFineServizio() {
		return fineServizio;
	}

	public void setFineServizio(LocalDate fineServizio) {
		this.fineServizio = fineServizio;
	}

	public Integer getCapienza() {
		return capienza;
	}
	
	
	
}
