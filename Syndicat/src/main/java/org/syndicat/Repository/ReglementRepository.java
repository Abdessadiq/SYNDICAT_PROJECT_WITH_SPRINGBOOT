package org.syndicat.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.syndicat.models.AnnonceUtilisateur;
import org.syndicat.models.Immeuble;
import org.syndicat.models.Reglement;

@RepositoryRestResource
public interface ReglementRepository extends JpaRepository<Reglement, Long> {
    @Query("select reg from Reglement reg where reg.contenuArticle like :x")
    public Page<Reglement> search(@Param("x")String mc, Pageable pageable);
}
