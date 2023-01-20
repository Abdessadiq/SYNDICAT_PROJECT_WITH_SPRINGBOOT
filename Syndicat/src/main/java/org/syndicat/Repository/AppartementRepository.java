package org.syndicat.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.syndicat.models.AnnonceUtilisateur;
import org.syndicat.models.Appartement;
import org.syndicat.models.Immeuble;

@RepositoryRestResource
public interface AppartementRepository extends JpaRepository<Appartement, Long> {
   /* @Query(value = "select app from Appartement app where app.numero like: x ORDER BY app.numero ASC", nativeQuery = true)
    public Page<Appartement> search(@Param("x") String mc, Pageable pageable);

    */

}
