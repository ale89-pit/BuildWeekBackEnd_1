package model;

import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente {
	
	@Id
	@SequenceGenerator(name = "numero_tessera", sequenceName = "numero_tessera", allocationSize = 1, initialValue = 5000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "numero_tessera")
	private Integer tessera;
	
	@Column(name = "emissione_tessera", nullable = false)
	private LocalDate emissioneTessera;
	@Column(name = "rinnovo_tessera")
	private LocalDate rinnovoTessera;
	@Column(name = "scadenza_tessera", nullable = false)
	private LocalDate scadenzaTessera;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private LocalDate dataNascita;
	
	@OneToMany
	@JoinColumn(name = "titoli_acquistati")
	private List<TitoloViaggio> titoliAcquistati;

}
