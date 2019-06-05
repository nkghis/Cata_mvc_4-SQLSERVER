package org.sid.dao;

import org.sid.entities.CltProjDto;
import org.sid.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
    /*@Query("SELECT new org.sid.entities.CltProjDto(c.client_nom, p.projet_id, p.projet_nom )"+"FROM clients c INNER JOIN c.projetss p")
    List<CltProjDto> fetchCltProjDataInnerJoin();*/
}
