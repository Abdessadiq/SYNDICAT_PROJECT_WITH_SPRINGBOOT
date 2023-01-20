package org.syndicat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.syndicat.models.Caisse;
import org.syndicat.models.Immeuble;

@RepositoryRestResource
public interface CaisseRepository extends JpaRepository<Caisse, Long> {
}
