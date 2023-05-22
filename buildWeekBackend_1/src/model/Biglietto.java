package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import utils.DurataAbb;

@Entity
@DiscriminatorValue("biglietti")
public class Biglietto extends TitoloViaggio {
	
	@Column(name= "durata_giornaliera")
	private  DurataAbb durataGiornaliera = DurataAbb.GIORNALIERO;

	
	public Biglietto() {
		super();
	}


	@Override
	public String toString() {
		return "Biglietto [durataGiornaliera=" + durataGiornaliera + "]";
	}
	


	

	

	
}
