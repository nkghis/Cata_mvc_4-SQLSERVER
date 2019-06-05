package org.sid.dao;

import org.sid.entities.Conditionnement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionnementRepository extends JpaRepository<Conditionnement, Long> {
}
