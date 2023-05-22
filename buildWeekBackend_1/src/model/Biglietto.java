package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("biglietti")
public class Biglietto extends TitoloViaggio {
	
	@ManyToOne
	@JoinColumn(name = "titoli_acquistati")
	private Utente titolare;

	
	public Biglietto() {
		super();
	}
	
	public Biglietto(Utente titolare) {
		super();
		this.titolare = titolare;
	}

	public Utente getTitolare() {
		return titolare;
	}

	@Override
	public String toString() {
		return "Biglietto [" + super.toString() + "titolare=" + titolare + "]";
	}

	
}
