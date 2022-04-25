package mk.ukim.finki.emt.labemtbackend.repository;

import mk.ukim.finki.emt.labemtbackend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountyRepository extends JpaRepository<Country, Long> {
}
