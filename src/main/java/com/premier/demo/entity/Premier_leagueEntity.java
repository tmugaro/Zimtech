package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "PremierTeams")
public class PremierTeams {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String teamName;
	private Int score;
	private String resultOutcome;
	
	public PremierTeams() {
		
	}
	
	public PremierTeams(String teamName, Int score, String resultOutcome) {
		this.teamName = teamName;
		this.score = score;
		this.resultOutcome = resultOutcome;
	}
	

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", score=" + score + ", resultOutcome=" + resultOutcome
				+ "]";
	}
	
}
