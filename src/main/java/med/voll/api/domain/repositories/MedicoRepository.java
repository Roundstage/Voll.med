package med.voll.api.domain.repositories;

import med.voll.api.domain.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long>{}
