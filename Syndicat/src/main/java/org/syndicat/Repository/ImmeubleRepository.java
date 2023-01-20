package org.syndicat.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.syndicat.models.Immeuble;
@RepositoryRestResource
public interface ImmeubleRepository  extends JpaRepository<Immeuble, Long> {
    @Query("select imm from Immeuble imm where imm.nom like :x")
    public Page<Immeuble> search(@Param("x")String mc, Pageable pageable);
}
