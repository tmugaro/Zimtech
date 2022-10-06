package premier.league.log.table.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import premier.demo.exception.ResourceNotFoundException;
import premier.demo.entity.PremierLeague;
import premier.demo.repository.PremierLeagueRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PremierLeagueController {
	
	@Autowired
	private PremierRepository premierRepository;

	@GetMapping("/teams")
	public List<Teams> getAllTeams() {
		return PremierRepository.findAll();
	}

	@GetMapping("/team/{id}")
	public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") Long TeamId)
			throws ResourceNotFoundException {
		Team team = premierRepository.findById(teamId)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " + teamId));
		return ResponseEntity.ok().body(team);
	}

	@PostMapping("/teams")
	public Team createTeam(@Valid @RequestBody Team team) {
		return premierRepository.save(team);
	}

	@PutMapping("/team/{id}")
	public ResponseEntity<Team> updateTeam(@PathVariable(value = "id") Long teamId,
			@Valid @RequestBody Team teamDetails) throws ResourceNotFoundException {
		Team team = premierRepository.findById(teamId)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " + teamId));

		team.setTeamId(teamDetails.getTeamId());
		team.setTeamName(teamDetails.getTeamName());
		
		final Team updatedTeam = premierRepository.save(team);
		return ResponseEntity.ok(updatedTeam);
	}

	@DeleteMapping("/team/{id}")
	public Map<String, Boolean> deleteteam(@PathVariable(value = "id") Long teamId)
			throws ResourceNotFoundException {
		Team team = premierRepository.findById(teamId)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " + teamId));

		teamRepository.delete(team);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
