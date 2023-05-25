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
	@JoinColumn(name="mezzo_utilizzato")
	private Mezzo utilizzatoSu;

	boolean vidimato=false;
	
	@Column(name = "data_vidimazione")
	private LocalDate dataVidimazione;
	

	public Biglietto() {
		super();
	
	}
	public Biglietto(Biglietteria luogoEmissione) {
		super(LocalDate.now(),luogoEmissione);
	}
	
	public Biglietto(LocalDate dataEmissione,
			Biglietteria luogoEmissione) {
		super(dataEmissione, luogoEmissione);
	}

	
	
	public boolean isVidimato() {
		return vidimato;
	}
	public void setVidimato(boolean vidimato) {
		this.vidimato = vidimato;
	}
	
	public Mezzo getUtilizzatoSu() {
		return utilizzatoSu;
	}
	public void setUtilizzatoSu(Mezzo utilizzatoSu) {
		this.utilizzatoSu = utilizzatoSu;
		this.vidimato=true;
		this.dataVidimazione = LocalDate.now();
	}
	public void setUtilizzatoSu(Mezzo utilizzatoSu,LocalDate dataVid) {
		this.utilizzatoSu = utilizzatoSu;
		this.vidimato=true;
		this.dataVidimazione = dataVid;
		if(dataVid.compareTo(this.getDataEmissione()) < 0) { 
			this.setDataEmissione(dataVid);
		}
	}
	public LocalDate getDataVidimazione() {
		return dataVidimazione;
	}
	public void setDataVidimazione(LocalDate dataVidimazione) {
		this.dataVidimazione = dataVidimazione;
	}
	@Override
	public String toString() {
		return "Biglietto ["+ super.toString()+ " utilizzato Su=" + utilizzatoSu + ", vidimato=" + vidimato + "]";
	}
	
	
}
