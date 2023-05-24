package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import utils.DurataAbb;

@Entity
@DiscriminatorValue("abbonamenti")
public class Abbonamento extends TitoloViaggio {
	
	
	
	@Enumerated(EnumType.STRING)
	private DurataAbb durata;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Utente titolare;

	
	public Abbonamento() {
		super();
	}

	public Abbonamento(Utente titolare) {
		super();
		this.titolare = titolare;
	}
	
	public Abbonamento(DurataAbb durata, Biglietteria luogoEmissione, Utente titolare) {
		super(luogoEmissione,
                 durata.equals(DurataAbb.SETTIMANALE) ? LocalDate.now().plusDays(7) 
                : LocalDate.now().plusMonths(1));
		this.titolare = titolare;
		this.durata = durata;
		
	}

	public Abbonamento(LocalDate dataEmissione,DurataAbb durata, Biglietteria luogoEmissione, Utente titolare) {
		super(dataEmissione, luogoEmissione,  durata.equals(DurataAbb.SETTIMANALE) ? dataEmissione.plusDays(7) 
				: dataEmissione.plusMonths(1));
		this.titolare = titolare;
		this.durata=durata;
	}

	public Utente getTitolare() {
		return titolare;
	}

	public void setTitolare(Utente titolare) {
		this.titolare = titolare;
	}

	@Override
	public String toString() {
		return "Abbonamento [ "+ super.toString() + "titolare=" + titolare + "]";
	}
	
	public boolean isValido() {
		boolean validita = (this.getDataScadenza().compareTo(LocalDate.now()) > 0) ? true : false;
		return validita;
	}
}
