package model;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="abbonamenti")
public class Abbonamento extends TitoloViaggio {
	
	@ManyToOne
	@JoinTable(name = "titoli_acquistati")
	@Column(nullable = false)
	private Utente titolare;
	
}
