package org.syndicat.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.syndicat.models.AnnonceUtilisateur;
import org.syndicat.models.Immeuble;

@RepositoryRestResource
public interface AnnonceUtilisateurRepository extends JpaRepository<AnnonceUtilisateur, Long> {
    @Query("select ann from AnnonceUtilisateur ann where ann.sujet like :x")
    public Page<AnnonceUtilisateur> search(@Param("x")String mc, Pageable pageable);
}
