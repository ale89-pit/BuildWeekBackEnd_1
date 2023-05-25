package model;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tratte")
public class Tratta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numeroTratta;
	
	private Luogo partenza;
	
	private Luogo capolinea;
	
	@Column(name = "km_tratta")
	private double kmTratta;
	
	@Column(name = "tempo_stimato")
	private LocalTime tempoStimato;
	
	@OneToMany(mappedBy = "trattaAssegnata", fetch = FetchType.EAGER)
	private List<Mezzo> mezziSuTratta;
	
	
}
