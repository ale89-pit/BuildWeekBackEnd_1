package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import utils.DurataAbb;

@Entity
@DiscriminatorValue("biglietti")
public class Biglietto extends TitoloViaggio {
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="mezzzo_utilizzato")
	private Mezzo utilizzatoSu;

	boolean vidimato=false;
	

	public Biglietto() {
		super();
	
	}
	public Biglietto(Biglietteria luogoEmissione) {
		super(LocalDate.now(),luogoEmissione,null);
	}
	
	public Biglietto(LocalDate dataEmissione,
			Biglietteria luogoEmissione) {
		super(dataEmissione, luogoEmissione,null);
	}

	
	
	public boolean isVidimato() {
		return vidimato;
	}
	public void setVidimato(boolean vidimato) {
		this.vidimato = vidimato;
	}
	
	public Mezzo getUtilizzato() {
		return utilizzatoSu;
	}
	public void setUtilizzato(Mezzo utilizzatoSu) {
		this.utilizzatoSu = utilizzatoSu;
		this.vidimato=true;
	}
}
