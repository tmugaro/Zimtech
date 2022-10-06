package premier.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import premier.demo.model.PremierTeams;

@Repository
public interface PremierRepository extends JpaRepository<PremierTeams, Long>{

}
