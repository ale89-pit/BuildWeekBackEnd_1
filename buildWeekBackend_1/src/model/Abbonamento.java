package model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import utils.DurataAbb;

@Entity
@DiscriminatorValue("abbonamenti")
public class Abbonamento extends TitoloViaggio {
	
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
		super(durata, luogoEmissione);
		this.titolare = titolare;
	}

	public Abbonamento(LocalDate dataEmissione,DurataAbb durata, Biglietteria luogoEmissione, Utente titolare) {
		super(dataEmissione, durata, luogoEmissione);
		this.titolare = titolare;
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
	
	
}
